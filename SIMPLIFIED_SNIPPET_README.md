# Simplified SWT Tree Crash Reproduction Snippet

## Overview

`SimpleTreeCrashSnippet.java` is a simplified standalone snippet that demonstrates the SWT virtual tree crash (issue #667) without requiring JFace or complex user interaction.

## Key Differences from Original Test

1. **Pure SWT**: Uses only SWT APIs, no JFace dependency
2. **Automatic Trigger**: Programmatically expands items and triggers the crash scenario
3. **Self-contained**: Single Java file that can be compiled and run independently
4. **Realistic Scenario**: Mimics real-world case where tree structure changes during expansion

## How It Works

The snippet reproduces the crash by:

1. Creating a virtual tree (`SWT.VIRTUAL` flag) with parent-child hierarchy
2. Adding a `SWT.SetData` listener for lazy item population
3. When expanding a parent item, SetData is called for each child
4. During child SetData processing (at child index 2), items are removed from the tree
5. This creates the problematic re-entrant callback scenario

## The Re-entrancy Issue

```
[Expand parent item]
  └─> GTK begins iteration over children
      └─> SetData callback for child 0
      └─> SetData callback for child 1  
      └─> SetData callback for child 2
          └─> display.asyncExec() schedules item removal
              └─> Tree.destroyItem()
                  └─> gtk_tree_store_remove() [ENTER]
                      └─> GTK triggers callbacks DURING removal
                          └─> Tree.cellDataProc() called
                              └─> May access node being removed
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

## Expected Output

### Normal execution (no crash):
```
[SetData] Root item at index: 0
[Test] Expanding first item to trigger crash...
[SetData] Child item at index: 0 of parent: Parent 0
[SetData] Child item at index: 1 of parent: Parent 0
[SetData] Child item at index: 2 of parent: Parent 0
[SetData] ** Triggering crash scenario **
[AsyncExec] Removing tree items...
```

### With crash:
The program may crash with GTK assertion or SWTException before completing.

## Crash Behavior

The crash behavior depends on GTK version and timing:
- **GTK < 3.24**: More likely to crash with GTK assertion failure
- **GTK >= 3.24**: May throw `SWTException: Widget is disposed`
- **With tracing enabled**: Will show `[JAVA]` and `[NATIVE C]` printouts demonstrating the re-entrant callback

**Note**: The crash may not occur 100% of the time as it depends on GTK's internal timing and callback ordering. If the snippet doesn't crash, try:
- Changing the child index where removal is triggered (line 72)
- Adding more children per parent
- Removing different items or multiple items

## Advantages Over Complex Test

1. **Easier to run**: No JFace, no TreeViewer, no complex setup
2. **Faster to reproduce**: Automatically triggers the scenario
3. **Easier to understand**: Clear, linear code flow
4. **Easier to modify**: Single file, easy to experiment with
5. **Better for debugging**: Can add breakpoints in a single file
6. **More realistic**: Mimics actual application behavior where data changes during UI operations

## Related Files

- `CRASH_ANALYSIS.md` - Detailed analysis of the crash
- `TRACE_OUTPUT.log` - Sample trace output from complex test
- `SUMMARY.md` - Overall summary of the crash investigation
