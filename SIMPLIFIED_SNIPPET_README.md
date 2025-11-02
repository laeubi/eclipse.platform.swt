# Simplified SWT Tree Crash Reproduction Snippet

## Overview

`SimpleTreeCrashSnippet.java` is a simplified standalone snippet that demonstrates the SWT virtual tree crash (issue #667) without requiring JFace or complex user interaction.

## Key Differences from Original Test

1. **Pure SWT**: Uses only SWT APIs, no JFace dependency
2. **Direct Event Posting**: Uses `Display.post(Event)` to programmatically trigger the Expand event
3. **Self-contained**: Single Java file that can be compiled and run independently
4. **Automated**: Automatically triggers the crash scenario without manual interaction

## How It Works

The snippet reproduces the crash by:

1. Creating a virtual tree (`SWT.VIRTUAL` flag)
2. Adding a `SWT.SetData` listener for lazy item population
3. Programmatically posting an `SWT.Expand` event using `Display.post()`
4. During the SetData callback, scheduling an async item removal
5. This creates the problematic re-entrant callback scenario

## The Re-entrancy Issue

```
[SetData listener triggered]
  └─> display.asyncExec() schedules item removal
      └─> Item.dispose() called
          └─> Tree.destroyItem() 
              └─> gtk_tree_store_remove() [ENTER]
                  └─> GTK triggers callbacks
                      └─> Tree.cellDataProc() called DURING removal
                          └─> May call TreeItem.getExpanded()
                              └─> gtk_tree_model_get_path() on removing node
                                  └─> GTK ASSERTION FAILURE
```

## Running the Snippet

### Compilation
```bash
javac -cp /path/to/swt.jar SimpleTreeCrashSnippet.java
```

### Execution
```bash
java -cp .:/path/to/swt.jar SimpleTreeCrashSnippet
```

With tracing enabled (from this PR):
```bash
# Run with the modified SWT that includes tracing
java -cp .:/path/to/modified-swt.jar SimpleTreeCrashSnippet 2>&1 | tee output.log
```

## Expected Behavior

- **With GTK < 3.24**: May crash with GTK assertion failure
- **With GTK >= 3.24**: May throw `SWTException: Widget is disposed`
- **With tracing enabled**: Will show `[JAVA]` and `[NATIVE C]` printouts demonstrating the re-entrant callback

## Advantages Over Complex Test

1. **Easier to run**: No JFace, no TreeViewer, no complex setup
2. **Faster to reproduce**: Automatically triggers the scenario
3. **Easier to understand**: Clear, linear code flow
4. **Easier to modify**: Single file, easy to experiment with
5. **Better for debugging**: Can add breakpoints in a single file

## Related Files

- `CRASH_ANALYSIS.md` - Detailed analysis of the crash
- `TRACE_OUTPUT.log` - Sample trace output from complex test
- `SUMMARY.md` - Overall summary of the crash investigation
