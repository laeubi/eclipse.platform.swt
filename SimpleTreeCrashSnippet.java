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
 * This snippet demonstrates the crash by directly posting Expand events to trigger
 * the problematic code path without needing JFace or complex user interaction.
 * 
 * Steps to reproduce:
 * 1. Create a virtual tree with a few items
 * 2. Post an Expand event to trigger lazy loading
 * 3. During lazy loading, remove items
 * 4. This triggers the re-entrant callback issue in gtk_tree_store_remove()
 * 
 * Expected result: GTK assertion failure or JVM crash
 * Actual result: Demonstrates the re-entrancy issue where cellDataProc() 
 *                is called during gtk_tree_store_remove()
 */
public class SimpleTreeCrashSnippet {

static int itemCount = 5;
static boolean crashTriggered = false;

public static void main(String[] args) {
Display display = new Display();
Shell shell = new Shell(display);
shell.setLayout(new FillLayout());
shell.setText("SWT Virtual Tree Crash Test - Issue #667");

// Create a virtual tree
final Tree tree = new Tree(shell, SWT.VIRTUAL | SWT.BORDER);
tree.setItemCount(itemCount);

// Add SetData listener for virtual items
tree.addListener(SWT.SetData, event -> {
TreeItem item = (TreeItem) event.item;
int index = tree.indexOf(item);

System.out.println("[SetData] Setting data for item at index: " + index);
item.setText("Item " + index);

// Give each item some children to enable expansion
if (index < 3) {
item.setItemCount(3);
}

// Simulate the crash scenario: remove items during expansion
if (!crashTriggered && index == 1) {
crashTriggered = true;
System.out.println("[SetData] Triggering crash scenario - removing items during expansion...");

// This removal during SetData callback creates the re-entrancy issue
display.asyncExec(() -> {
if (!tree.isDisposed() && tree.getItemCount() > 0) {
System.out.println("[AsyncExec] Removing first tree item...");
TreeItem firstItem = tree.getItem(0);
if (!firstItem.isDisposed()) {
firstItem.dispose(); // This triggers gtk_tree_store_remove
}
}
});
}
});

// Add Expand listener for child items
tree.addListener(SWT.Expand, event -> {
TreeItem item = (TreeItem) event.item;
System.out.println("[Expand] Expanding: " + item.getText());

// Populate children when expanded
for (TreeItem child : item.getItems()) {
if (child.getText().isEmpty()) {
int childIndex = item.indexOf(child);
child.setText(item.getText() + " - Child " + childIndex);
}
}
});

shell.setSize(400, 300);
shell.open();

// Automatically trigger the crash scenario after UI is ready
display.timerExec(500, () -> {
if (!tree.isDisposed() && tree.getItemCount() > 0) {
System.out.println("\n[Test] Programmatically expanding first item to trigger crash...");

TreeItem firstItem = tree.getItem(0);

// Post an Expand event directly to trigger the problematic code path
Event expandEvent = new Event();
expandEvent.type = SWT.Expand;
expandEvent.item = firstItem;
expandEvent.widget = tree;

// This will trigger SetData events, which may cause re-entrant callbacks
display.post(expandEvent);

// Also try to set expanded state directly
display.timerExec(100, () -> {
if (!firstItem.isDisposed()) {
System.out.println("[Test] Setting expanded state...");
firstItem.setExpanded(true);
}
});
}
});

// Auto-close after a few seconds if no crash
display.timerExec(3000, () -> {
System.out.println("\n[Test] No crash after 3 seconds - closing...");
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
