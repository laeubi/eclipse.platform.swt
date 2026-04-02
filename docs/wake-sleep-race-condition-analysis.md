# Display.wake()/sleep() Race Condition Analysis

## Summary

The GTK implementation of `Display.sleep()` contained a race condition that could cause the
UI thread to miss wakeup signals, leading to the event loop becoming unresponsive until an
external event (mouse movement, timer, etc.) occurred. This manifested as intermittent hangs
in `BusyIndicator.showWhile()` tests on Linux CI environments, where there are no external
input events to accidentally break the deadlock.

## Related Issues

- [#3044](https://github.com/eclipse-platform/eclipse.platform.swt/issues/3044) - Test_org_eclipse_swt_custom_BusyIndicator fails on Linux
- [#3053](https://github.com/eclipse-platform/eclipse.platform.swt/issues/3053) - `g_main_context_wakeup` Is Maybe Not Buggy
- [#3059](https://github.com/eclipse-platform/eclipse.platform.swt/issues/3059) - sleep() does not react to thread interruption
- [#3060](https://github.com/eclipse-platform/eclipse.platform.swt/issues/3060) - Display#wake must likely be volatile

## Root Cause Analysis

### The `wake` Flag Race Condition

The core issue was in `Display.sleep()` (GTK implementation) at the line `wake = false` inside
the `do-while` loop. This reset of the `wake` flag created a race condition with
`wakeThread()` called from other threads.

#### Before Fix (Problematic Code)

```java
// Display.sleep() - GTK
do {
    if (OS.g_main_context_acquire(context)) {
        result = OS.g_main_context_prepare(context, max_priority);
        // ... query poll descriptors ...
        if (poll != 0) {
            if (nfds > 0 || timeout[0] != 0) {
                if (timeout[0] < 0) timeout[0] = 50;
                wake = false;                              // ← PROBLEM: Resets flag inside loop
                OS.Call(poll, fds, nfds, timeout[0]);      // ← Blocks in poll()
            }
        }
        OS.g_main_context_check(context, ...);             // ← Consumes wakeup fd signal
        OS.g_main_context_release(context);
    }
} while (!result && synchronizer.isMessagesEmpty() && !wake);
wake = false;
```

```java
// Display.wakeThread() - called from other threads
void wakeThread() {
    OS.g_main_context_wakeup(0);   // Signals the wakeup eventfd
    wake = true;                    // Sets the flag
}
```

#### The Race Scenario

```
UI Thread (sleep loop)                 Background Thread
========================               ======================

Loop iteration N completes.
Poll returned (timeout/event).
g_main_context_check() runs.
Loop condition: !wake → true
  (wake is still false, loop continues)
                                       wakeThread() called:
                                         g_main_context_wakeup(0) → signals eventfd
                                         wake = true               → sets flag

wake = false  ← OVERWRITES true!       (flag is now lost!)
OS.Call(poll, ...) → returns immediately
  (eventfd was still signaled)
g_main_context_check() → CONSUMES the eventfd signal
Loop condition: !wake → true
  (wake was overwritten to false!)

Next iteration:
wake = false
OS.Call(poll, ...) → blocks for 50ms
  (no eventfd signal, no events)
... repeats every 50ms indefinitely ...
```

The wakeup is **permanently lost** because:
1. `wake = false` inside the loop overwrites the `true` set by `wakeThread()`
2. `g_main_context_check()` consumes the eventfd signal
3. With `wake` back to `false` and no eventfd signal, the loop has no exit condition

The loop only breaks when:
- A GTK event arrives (mouse move, timer, etc.) causing `result` to be `true`
- A synchronizer message is added (causing `isMessagesEmpty()` to return `false`)
- Another call to `wakeThread()` happens to be timed correctly

### The `volatile` Issue

Additionally, the `wake` field was **not volatile**, meaning:
- The JVM could cache the value in a CPU register
- Writes from background threads might not be visible to the UI thread
- The compiler could reorder reads/writes around the field

### Why This Only Manifested in CI

In normal desktop usage, external events (mouse movements, window repaints, system timers)
frequently cause the poll to return and `g_main_context_prepare()` to return `true`, breaking
the loop naturally. In headless CI environments on Linux, there are no such external events,
making the race condition much more likely to cause an observable hang.

## The "Bug in GTK" Comment

The original code contained this comment (from October 2004, commit `400a4197`):

```java
/*
 * Bug in GTK. For some reason, g_main_context_wakeup() may
 * fail to wake up the UI thread from the polling function.
 * The fix is to sleep for a maximum of 50 milliseconds.
 */
if (timeout[0] < 0) timeout[0] = 50;
```

### Analysis

As demonstrated in [issue #3053](https://github.com/eclipse-platform/eclipse.platform.swt/issues/3053),
`g_main_context_wakeup()` works correctly on modern GLib (tested on GLib 2.84). The function
uses an eventfd-based mechanism that reliably wakes polling threads.

The original "bug" reported in 2004 was likely a symptom of the same race condition in SWT's
own code (`wake = false` overwriting `wake = true`), not a bug in GTK's `g_main_context_wakeup`.
When the wakeup appeared to "fail", it was actually SWT's flag reset that lost the signal.

The 50ms timeout cap serves as a useful **safety net** to limit the maximum sleep duration, but
it was not a fix for a GTK bug — it was masking the race condition in SWT's own code.

## Platform Comparison

| Platform | `wake` field? | `sleep()` mechanism | `wakeThread()` mechanism | Race condition? |
|----------|--------------|---------------------|-------------------------|-----------------|
| **GTK**  | `boolean wake` (was not volatile) | Manual poll loop with `g_main_context_*` | `g_main_context_wakeup(0)` + `wake = true` | **YES** (fixed) |
| **Win32** | None | `OS.WaitMessage()` | `OS.PostThreadMessage(threadId, WM_NULL, ...)` | No — uses message queue |
| **Cocoa** | None | `NSRunLoop.runMode()` | `performSelectorOnMainThread()` | No — uses run loop event |

Win32 and Cocoa don't have this issue because they use native event queue mechanisms to both
block and wake, with no separate boolean flag.

## Fixes Applied

### Fix 1: Move `wake = false` Before the Loop (Display.sleep)

The `wake = false` statement is moved from inside the `do-while` loop to before it. This
ensures the flag is reset once at the start of `sleep()`, clearing any stale signal, but
is never overwritten during the loop. Once `wakeThread()` sets `wake = true`, the flag
stays true and the loop exits.

### Fix 2: Make `wake` Volatile (Display field)

The `wake` field is now declared `volatile` to ensure cross-thread visibility. This
guarantees that writes from `wakeThread()` (called from background threads) are
immediately visible to the UI thread checking the flag in the loop condition.

### Fix 3: Use `asyncExec` in BusyIndicator (Defense in Depth)

`BusyIndicator.showWhile()` now uses `display.asyncExec(() -> {})` instead of
`display.wake()` to signal the UI thread when a `CompletionStage` completes. This
works through a different code path: `asyncExec` adds a message to the synchronizer
queue, and `Display.sleep()`'s loop condition checks `synchronizer.isMessagesEmpty()`.
This provides an additional, independent mechanism to break the sleep loop.

## Historical Timeline

| Date | Event |
|------|-------|
| 2004-10-08 | Original `wake = false` and 50ms timeout added (commit `400a4197`) |
| 2004-10-08 | "Bug in GTK" comment added — likely misattributed SWT race condition to GTK |
| 2026-02-02 | Issue #3044 opened — BusyIndicator test hang on Linux CI |
| 2026-02-04 | Issue #3053 opened — Analysis showing g_main_context_wakeup works correctly |
| 2026-02-05 | Issues #3059 and #3060 opened — sleep() interrupt support and volatile wake |
| 2026-04-01 | HeikoKlare confirms removing `wake = false` inside loop fixes the issue |
| 2026-04-02 | This fix applied — race condition eliminated, comment corrected |
