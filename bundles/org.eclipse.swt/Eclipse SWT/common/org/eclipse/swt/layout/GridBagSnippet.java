/********************************************************************************
 * Copyright (c) 2023 christoph and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   christoph - initial API and implementation
 ********************************************************************************/

package org.eclipse.swt.layout;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

/**
 * @author christoph
 * @since 3.123
 */
public class GridBagSnippet {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("GridBagLayout Demo");
		shell.setLayout(new FillLayout());
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		TabItem tab1 = new TabItem(tabFolder, SWT.NONE);
		tab1.setText("Example");
		tab1.setControl(createBagExample(tabFolder));
		TabItem tab2 = new TabItem(tabFolder, SWT.NONE);
		tab2.setText("Debug Your GridBags");
		tab2.setControl(createDebugExample(tabFolder));
		tabFolder.setSelection(1);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private static Composite createBagExample(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridBagLayout());
		Table table = createTable(composite);
		GridBagConstraints tableConstraints = new GridBagConstraints();
		// The table is placed at position 0, 0
		tableConstraints.grid.x = 0;
		tableConstraints.grid.y = 0;
		// ... it always uses all space
		tableConstraints.fill = SWT.FILL;
		// ... and 80 % of vertical space
		tableConstraints.weight.y = 80;
		// ... and spawns 2 columns
		tableConstraints.span.x = 2;
		table.setLayoutData(tableConstraints);
		Control text = createTextArea(composite, table);
		GridBagConstraints textConstraints = new GridBagConstraints();
		// The text area is placed at position 0, 1 just below the table
		textConstraints.grid.x = 0;
		textConstraints.grid.y = 1;
		textConstraints.fill = SWT.FILL;
		// it takes one third
		textConstraints.weight.x = 30;
		textConstraints.weight.y = 20;
		text.setLayoutData(textConstraints);
		Label label = createLabel(composite, table);
		// the label is placed at position 1, 1
		GridBagConstraints labelConstraints = new GridBagConstraints();
		labelConstraints.grid.x = 1;
		labelConstraints.grid.y = 1;
		labelConstraints.weight.x = 30;
		labelConstraints.fill = SWT.FILL;
		label.setLayoutData(labelConstraints);
		Control buttons = createButtons(composite);
		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.grid.x = 2;
		buttonConstraints.grid.y = 0;
		buttonConstraints.weight.x = 30;
		buttonConstraints.span.y = 2;
		buttonConstraints.fill = SWT.FILL;
		buttons.setLayoutData(buttonConstraints);
		return composite;
	}

	/**
	 * Creates a control that enables the debug painting for a layout
	 * @param parent
	 * @return
	 */
	private static Composite createDebugExample(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridBagLayout(composite));
		Label c1 = new Label(composite, SWT.NONE);
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.grid.x = 0;
		gbc1.grid.y = 0;
		gbc1.fill = SWT.FILL;
		gbc1.weight.y = 80;
		gbc1.span.x = 2;
		c1.setLayoutData(gbc1);
		Control c2 = new Label(composite, SWT.NONE);
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.grid.x = 0;
		gbc2.grid.y = 1;
		gbc2.fill = SWT.FILL;
		// it takes one third
		gbc2.weight.x = 30;
		gbc2.weight.y = 20;
		c2.setLayoutData(gbc2);
		Label c3 = new Label(composite, SWT.NONE);
		// the label is placed at position 1, 1
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.grid.x = 1;
		gbc3.grid.y = 1;
		gbc3.weight.x = 30;
		gbc3.fill = SWT.FILL;
		c3.setLayoutData(gbc3);
		Control c4 = new Label(composite, SWT.NONE);
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.grid.x = 2;
		gbc4.grid.y = 0;
		gbc4.weight.x = 30;
		gbc4.span.y = 2;
		c4.setLayoutData(gbc4);
		c1.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		c2.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_GREEN));
		c3.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_YELLOW));
		c4.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_GREEN));
		return composite;
	}

	/**
	 * @param shell
	 * @return
	 */
	private static Control createButtons(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, true));
		for (int i = 0; i < 10; i++) {
			new Button(composite, SWT.PUSH).setText("Button " + i);
		}
		return composite;
	}

	private static Label createLabel(Composite parent, Table table) {
		Label label = new Label(parent, SWT.CENTER);
		label.setText("");
		label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = table.getSelectionIndex();
				label.setText("You selected " + index);
				if (index % 2 == 0) {
					label.setBackground(e.display.getSystemColor(SWT.COLOR_BLUE));
				} else {
					label.setBackground(e.display.getSystemColor(SWT.COLOR_RED));
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		return label;
	}

	private static Control createTextArea(Composite parent, Table table) {
		ScrolledComposite composite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		composite.setLayout(new FillLayout());
		Text text = new Text(composite, SWT.MULTI);
		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				StringBuilder sb = new StringBuilder();
				for (TableItem item : table.getSelection()) {
					for (int i = 0; i < table.getColumnCount(); i++) {
						sb.append(item.getText(i));
						sb.append(" | ");
					}
					sb.append(Text.DELIMITER);
				}
				text.setText(sb.toString());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		text.setText("Select a table item!");
		composite.setContent(text);
		composite.setMinSize(800, 800);
		composite.setExpandHorizontal(true);
		composite.setExpandVertical(true);
		return composite;
	}

	// From Snippet38
	public static Table createTable(Composite parent) {
		Table table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		String[] titles = { " ", "C", "!", "Description", "Resource", "In Folder", "Location" };
		for (String title : titles) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(title);
		}
		int count = 128;
		for (int i = 0; i < count; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, "x");
			item.setText(1, "y");
			item.setText(2, "!");
			item.setText(3, "this stuff behaves the way I expect");
			item.setText(4, "almost everywhere");
			item.setText(5, "some.folder");
			item.setText(6, "line " + i + " in nowhere");
		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}
		return table;
	}
}
