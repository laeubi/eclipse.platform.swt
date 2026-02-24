/********************************************************************************
 * Copyright (c) 2023 Christoph Läubrich and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christoph Läubrich - initial API and implementation
 ********************************************************************************/

package org.eclipse.swt.layout;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.GridBagConstraints.*;
import org.eclipse.swt.widgets.*;

/**
 * This implements a layout similar to the <a href=
 * "https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html">Swing
 * GridBagLayout</a>.
 * <p>
 * Controls are placed in a grid of cells, where each cell's size is determined
 * by the weight assigned to its column and row. The key principle is to compute
 * the grid ("bags") first, assign sizes based on weights, then use those sizes
 * as hints when asking controls for their preferred size.
 * </p>
 *
 * @see GridBagConstraints
 * @since 3.123
 */
public class GridBagLayout extends Layout {

	/**
	 * Creates a new GridBagLayout.
	 */
	public GridBagLayout() {
	}

	/**
	 * Creates a GridBagLayout and installs it on the given composite, adding a
	 * debug paint listener that visualizes the grid structure.
	 *
	 * @param component the composite to install the layout on
	 */
	public GridBagLayout(Composite component) {
		component.setLayout(this);
		component.addPaintListener(e -> {
			Point size = component.getSize();
			GridBag gridBag = GridBagConstraints.getGridBag(component, false);
			GC gc = e.gc;
			int[] columnWidths = gridBag.getColumnWidths(size.x);
			int[] rowHeights = gridBag.getRowHeights(size.y);
			gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
			gc.setLineWidth(3);
			for (int x = 0; x < gridBag.dimension.x; x++) {
				for (int y = 0; y < gridBag.dimension.y; y++) {
					Control control = gridBag.controls[x][y];
					if (control == null) {
						continue;
					}
					Point l = control.getLocation();
					Point resolvedSpan = gridBag.getResolvedSpan(control);
					int w = columnWidths[x];
					int colspan = resolvedSpan.x;
					for (int i = 1; i < colspan; i++) {
						w += columnWidths[x + i];
					}
					int h = rowHeights[y];
					int rowspan = resolvedSpan.y;
					for (int i = 1; i < rowspan; i++) {
						h += rowHeights[y + i];
					}
					Point pos = gridBag.positionMap.get(control);
					gc.drawRectangle(l.x, l.y, w, h);
					String xs = String.valueOf(pos.x);
					if (colspan > 1) {
						xs += " + " + (colspan - 1);
					}
					String ys = String.valueOf(pos.y);
					if (rowspan > 1) {
						ys += " + " + (rowspan - 1);
					}
					String msg = control + " (" + xs + ", " + ys + ")";
					Point extent = gc.stringExtent(msg);
					gc.drawString(msg, l.x + w / 2 - extent.x / 2, l.y + h / 2 - extent.y / 2);
				}
			}
		});
	}

	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		GridBag grid = GridBagConstraints.getGridBag(composite, flushCache);
		int width = wHint;
		if (width == SWT.DEFAULT) {
			width = 0;
			for (int x = 0; x < grid.dimension.x; x++) {
				width += grid.cols[x];
			}
		}
		int height = hHint;
		if (height == SWT.DEFAULT) {
			height = 0;
			for (int y = 0; y < grid.dimension.y; y++) {
				height += grid.rows[y];
			}
		}
		return new Point(Math.max(0, width), Math.max(0, height));
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Rectangle clientArea = composite.getClientArea();
		GridBag grid = GridBagConstraints.getGridBag(composite, flushCache);
		int[] columnWidths = grid.getColumnWidths(clientArea.width);
		int[] rowHeights = grid.getRowHeights(clientArea.height);
		int offsetX = clientArea.x;
		for (int x = 0; x < grid.dimension.x; x++) {
			int offsetY = clientArea.y;
			int columnWidth = columnWidths[x];
			for (int y = 0; y < grid.dimension.y; y++) {
				int rowHeight = rowHeights[y];
				Control control = grid.controls[x][y];
				if (control != null) {
					GridBagConstraints c = grid.constraintMap.get(control);
					Point resolvedSpan = grid.getResolvedSpan(control);
					int spanX = resolvedSpan.x;
					int spanY = resolvedSpan.y;
					// Compute total cell size including spanned columns/rows
					int cellWidth = columnWidth;
					for (int i = 1; i < spanX; i++) {
						cellWidth += columnWidths[x + i];
					}
					int cellHeight = rowHeight;
					for (int i = 1; i < spanY; i++) {
						cellHeight += rowHeights[y + i];
					}
					// Use cell dimensions as hints when computing control size
					int wHint = c.wHint != SWT.DEFAULT ? c.wHint : cellWidth;
					int hHint = c.hHint != SWT.DEFAULT ? c.hHint : cellHeight;
					Point size = control.computeSize(wHint, hHint, false);
					int width;
					if (c.fill == SWT.FILL || c.fill == SWT.HORIZONTAL) {
						width = cellWidth;
					} else {
						width = Math.min(size.x, cellWidth);
					}
					int height;
					if (c.fill == SWT.FILL || c.fill == SWT.VERTICAL) {
						height = cellHeight;
					} else {
						height = Math.min(size.y, cellHeight);
					}
					control.setBounds(offsetX, offsetY, width, height);
				}
				offsetY += rowHeight;
			}
			offsetX += columnWidth;
		}
	}

}
