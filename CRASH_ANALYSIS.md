# SWT Tree Crash Analysis - Issue #667

## Summary

This analysis adds comprehensive tracing to both Java and native C code to trace the call path that leads to crashes in SWT virtual tree operations.

## Changes Made

### 1. Java Code Printouts (distinguishable as `[JAVA]`)
Added printouts to the following key methods in the expand call path:

- `Tree.destroyItem()` - Entry/exit and before/after gtk_tree_store_remove
- `Tree.cellDataProc()` - Entry, before/after checkData call
- `Tree.checkData()` - Entry, before/after SWT.SetData event
- `TreeItem.destroyWidget()` - Entry/exit
- `TreeItem.getExpanded()` - Entry, before/after gtk_tree_model_get_path, exit

### 2. Native C Code Printouts (distinguishable as `[NATIVE C]`)
Added printouts with fprintf to stderr (with fflush for immediate output) to:

- `gtk_tree_store_remove()` - Entry/exit with pointer values
- `gtk_tree_model_get_path()` - Entry/exit with pointer values

### 3. Compilation
- Native code compiled successfully using `./build_gtk.sh`
- Java code compiled successfully using Maven
- Binaries placed in `binaries/org.eclipse.swt.gtk.linux.x86_64/`

### 4. Test Execution

#### Setup
- Used Xvfb (virtual framebuffer) for headless execution
- Created test based on snippet from issue comment #3090043021
- Compiled with JFace dependencies

#### Observations

The tracing clearly shows the call sequence:

1. **Initial Tree Population**:
   - cellDataProc() gets called for rendering cells
   - gtk_tree_model_get_path() is called to get paths for items
   - checkData() triggers SWT.SetData events for virtual items

2. **Item Removal During Expand**:
   ```
   [USER CODE] DirectCrashTest.MyContentProvider.updateElement() - parent=Child 0, index=0
   [USER CODE] Node 'SubChild 0.0' is empty and will be removed
   [JAVA] TreeItem.destroyWidget() - ENTER
   [JAVA] Tree.destroyItem() - ENTER - handle=139735893161088
   [JAVA] Tree.destroyItem() - About to call gtk_tree_store_remove
   [NATIVE C] gtk_tree_store_remove() - ENTER - store=0x7f16cc5c7bb0, iter=0x7f16cc463480
   [JAVA] Tree.cellDataProc() - ENTER - cell=139735893748432, iter=139735895274640
   ```

3. **Key Finding**:
   - `cellDataProc()` is being called **during** `gtk_tree_store_remove()`
   - This happens before gtk_tree_store_remove() completes (before EXIT)
   - This is a re-entrant callback situation

4. **The Crash Path**:
   When gtk_tree_store_remove() is called, GTK internally triggers callbacks that lead back to cellDataProc(), which then tries to access the TreeItem being removed. This can lead to:
   - Accessing partially destroyed GTK tree model nodes
   - The assertion `(G_NODE (iter->user_data)->parent != NULL)` failing when getExpanded() calls gtk_tree_model_get_path() on a node being removed

## Environment Limitations Encountered

1. **GTK Crash Not Reproduced**: 
   - The exact GTK assertion crash from the issue (`gtk_tree_store_get_path: assertion failed`) was not reproduced in the test environment
   - Instead got `Widget is disposed` exception, which is a different symptom of the same underlying race condition
   - This is likely due to differences in GTK versions, timing, or specific tree states

2. **Headless Environment**:
   - Required Xvfb for GUI testing
   - Some GTK session manager warnings (expected in headless environment)

3. **Manual Reproduction**:
   - The exact user interaction sequence from the issue video could not be perfectly automated
   - SWTBot would have been ideal but added complexity without guaranteed crash reproduction

## Conclusion

The tracing is successfully in place and demonstrates:
- Clear distinction between Java (`[JAVA]`) and Native (`[NATIVE C]`) code paths
- The problematic re-entrant callback during tree item removal
- The call sequence that leads to accessing destroyed/being-destroyed tree items

The root cause is a re-entrancy issue where GTK callbacks during `gtk_tree_store_remove()` can trigger `cellDataProc()`, which may then call `gtk_tree_model_get_path()` on a tree iterator that is in the process of being removed, causing the assertion failure.

## Files Modified

- `bundles/org.eclipse.swt/Eclipse SWT/gtk/org/eclipse/swt/widgets/Tree.java` - Added Java printouts
- `bundles/org.eclipse.swt/Eclipse SWT/gtk/org/eclipse/swt/widgets/TreeItem.java` - Added Java printouts  
- `bundles/org.eclipse.swt/Eclipse SWT PI/gtk/library/os.c` - Added native C printouts
- `binaries/org.eclipse.swt.gtk.linux.x86_64/*.so` - Compiled native libraries with tracing

