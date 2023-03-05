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
 * GridBagLayout</a>
 *
 * @since 3.123
 */
public class GridBagLayout extends Layout {

	/**
	 *
	 */
	public GridBagLayout() {
	}

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
					GridBagConstraints constraints = gridBag.constraintMap.get(control);
					int w = columnWidths[x];
					int colspan = constraints.span.x;
					for (int i = 1; i < colspan; i++) {
						w += columnWidths[x + i];
					}
					int h = rowHeights[y];
					int rowspan = constraints.span.y;
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
		// FIXME need to use max of summ of computed site
//		GridBag grid = GridBagConstraints.getGridBag(composite, flushCache);
//		if (wHint < 0) {
//			int width = 0;
//			for (int x = 0; x < grid.dimension.x; x++) {
//				width += grid.getColumnWidth(x);
//			}
//			wHint = width;
//		}
//		if (hHint < 0) {
//			int height = 0;
//			for (int y = 0; y < grid.dimension.y; y++) {
//				height += grid.getRowHeight(y);
//			}
//			hHint = height;
//		}
		return new Point(wHint, hHint);
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Rectangle clientArea = composite.getClientArea();
		GridBag grid = GridBagConstraints.getGridBag(composite, flushCache);
		int[] columnWidths = grid.getColumnWidths(clientArea.width);
		int[] rowHeights = grid.getRowHeights(clientArea.height);
		double offsetX = clientArea.x;
		for (int x = 0; x < grid.dimension.x; x++) {
			double offsetY = clientArea.y;
			int columnWidth = columnWidths[x];
			for (int y = 0; y < grid.dimension.y; y++) {
				int rowHeight = rowHeights[y];
				Control control = grid.controls[x][y];
				if (control != null) {
					GridBagConstraints c = grid.constraintMap.get(control);
					// TODO compute size according to grid size as hints!?
					Point size = grid.getSize(control);
					int width;
					int maxWidth = columnWidth;
					for (int i = 1; i < c.span.x; i++) {
						maxWidth += columnWidths[y + i];
					}
					if (c.fill == SWT.ALL || c.fill == SWT.HORIZONTAL) {
						width = maxWidth;
					} else {
						width = size.x;
					}
					int height;
					int maxHeight = rowHeight;
					for (int i = 1; i < c.span.y; i++) {
						maxHeight += rowHeights[y + i];
					}
					if (c.fill == SWT.ALL || c.fill == SWT.VERTICAL) {
						height = maxHeight;
					} else {
						height = size.y;
					}
					control.setBounds((int) offsetX, (int) offsetY, Math.min(width, maxWidth),
							Math.min(height, maxHeight));
				}
				offsetY += rowHeight;
			}
			offsetX += columnWidth;
		}

	}

}
