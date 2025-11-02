/*******************************************************************************
 * Copyright (c) 2025 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

/**
 * Simplified snippet to reproduce the SWT virtual tree crash (issue #667).
 * 
 * This snippet demonstrates the crash that occurs when:
 * 1. A virtual tree item is expanded, triggering SetData callbacks
 * 2. During SetData processing, the tree structure is modified (items removed)
 * 3. This causes gtk_tree_store_remove to be called while GTK is iterating
 * 4. GTK callbacks during removal access the partially destroyed node
 * 
 * The crash manifests as:
 * - GTK assertion: (G_NODE (iter->user_data)->parent != NULL) 
 * - Or SWTException: Widget is disposed
 * 
 * To reproduce: Run this snippet and watch for the crash when expanding the item.
 */
public class SimpleTreeCrashSnippet {

static TreeItem itemToExpand = null;
static boolean expandStarted = false;

public static void main(String[] args) {
Display display = new Display();
Shell shell = new Shell(display);
shell.setLayout(new FillLayout());
shell.setText("SWT Virtual Tree Crash Test - Issue #667");

// Create a virtual tree
final Tree tree = new Tree(shell, SWT.VIRTUAL | SWT.BORDER);
tree.setItemCount(10);

// Add SetData listener for virtual items
tree.addListener(SWT.SetData, event -> {
TreeItem item = (TreeItem) event.item;
TreeItem parentItem = item.getParentItem();

if (parentItem == null) {
// Root level item
int index = tree.indexOf(item);
System.out.println("[SetData] Root item at index: " + index);
item.setText("Parent " + index);
item.setItemCount(5); // Each parent has 5 children

// Save first item for expansion test
if (index == 0) {
itemToExpand = item;
}
} else {
// Child item - this is where the crash happens
int index = parentItem.indexOf(item);
System.out.println("[SetData] Child item at index: " + index + " of parent: " + parentItem.getText());
item.setText(parentItem.getText() + " - Child " + index);

// Trigger the crash: modify tree structure during SetData callback
// This simulates what happens in real apps when data changes
if (expandStarted && index == 2) {
System.out.println("[SetData] ** Triggering crash scenario **");
System.out.println("[SetData] Removing items while GTK is iterating tree structure...");

// Remove items from the tree - this will call gtk_tree_store_remove
// while GTK is still processing the expansion
display.asyncExec(() -> {
if (!tree.isDisposed() && tree.getItemCount() > 2) {
System.out.println("[AsyncExec] Removing tree items...");
TreeItem victim = tree.getItem(1);
if (!victim.isDisposed()) {
System.out.println("[AsyncExec] Disposing: " + victim.getText());
victim.dispose();
}

// Trigger more iteration to hit the crash
tree.setItemCount(tree.getItemCount() - 1);
}
});
}
}
});

shell.setSize(400, 300);
shell.open();

// Automatically trigger the crash scenario after UI is ready
display.timerExec(500, () -> {
if (itemToExpand != null && !itemToExpand.isDisposed()) {
System.out.println("\n[Test] Expanding first item to trigger crash...");
System.out.println("[Test] This will cause SetData callbacks for children");
System.out.println("[Test] During child processing, items will be removed");
System.out.println("[Test] This creates re-entrant gtk_tree_store_remove call\n");

expandStarted = true;

// Expand the item - this triggers SetData for children
// During child SetData processing, we'll modify the tree
itemToExpand.setExpanded(true);
}
});

// Auto-close after a few seconds if no crash
display.timerExec(3000, () -> {
System.out.println("\n[Test] No crash after 3 seconds - test may need adjustment for this GTK version");
shell.close();
});

while (!shell.isDisposed()) {
if (!display.readAndDispatch()) {
display.sleep();
}
}

display.dispose();
System.out.println("[Test] Program exited normally");
}
}
