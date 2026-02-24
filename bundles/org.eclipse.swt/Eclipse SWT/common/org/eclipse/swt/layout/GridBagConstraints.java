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

import java.util.*;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

/**
 * {@link GridBagConstraints} specify the constraints for controls placed inside
 * a {@link GridBagLayout}. Each control should have its own instance of
 * GridBagConstraints set as layout data via
 * {@link Control#setLayoutData(Object)}.
 *
 * @see GridBagLayout
 * @since 3.123
 */
public class GridBagConstraints {

	private static final String DATA_KEY = GridBag.class.getName();

	private static final GridBagConstraints DEFAULT = new GridBagConstraints();

	/**
	 * Used with {@link #grid} to indicate that the component should be placed
	 * relative to the previously added component.
	 */
	public static final int RELATIVE = -1;

	/**
	 * Used with {@link #span} to indicate that the component should span the
	 * remaining columns or rows.
	 */
	public static final int REMAINDER = 0;

	/**
	 * Specify the grid coordinate where the component will be placed, starting
	 * with 0 and defaulting to {@link #RELATIVE}. When set to {@link #RELATIVE},
	 * the component is placed right after the previously added component. It is
	 * recommended to always set explicit values for more predictable layouts.
	 */
	public final Point grid = new Point(RELATIVE, RELATIVE);

	/**
	 * Specify how many columns/rows the component spans (defaults to 1). Specify
	 * {@link #REMAINDER} to take all remaining columns/rows.
	 */
	public final Point span = new Point(1, 1);

	/**
	 * The weighting factor for distributing extra space among columns (weight.x)
	 * and rows (weight.y). At least one control should define a positive weight
	 * factor for each column/row. Values in the range 0...100 are recommended for
	 * easy recognition as percentages.
	 */
	public final Point weight = new Point(0, 0);

	/**
	 * Height hint used to determine the preferred size of the component. Defaults
	 * to {@link SWT#DEFAULT}.
	 */
	public int hHint = SWT.DEFAULT;

	/**
	 * Width hint used to determine the preferred size of the component. Defaults
	 * to {@link SWT#DEFAULT}.
	 */
	public int wHint = SWT.DEFAULT;

	/**
	 * Controls how/if the control should fill its cell:
	 * <ul>
	 * <li>{@link SWT#NONE} - the component does not fill (default)</li>
	 * <li>{@link SWT#HORIZONTAL} - the component is filled horizontally</li>
	 * <li>{@link SWT#VERTICAL} - the component fills vertically</li>
	 * <li>{@link SWT#FILL} - the component is filled in both directions</li>
	 * </ul>
	 */
	public int fill = SWT.NONE;

	static GridBag getGridBag(Composite composite, boolean changed) {
		if (!changed) {
			Object data = composite.getData(DATA_KEY);
			if (data instanceof GridBag) {
				return (GridBag) data;
			}
		}
		Control[] children = composite.getChildren();
		GridBagConstraints[] constraints = new GridBagConstraints[children.length];
		GridBag grid = new GridBag();

		// First pass: resolve RELATIVE positions and compute grid dimensions
		int cursorX = 0;
		int cursorY = 0;
		int[] resolvedX = new int[children.length];
		int[] resolvedY = new int[children.length];
		int[] resolvedSpanX = new int[children.length];
		int[] resolvedSpanY = new int[children.length];

		for (int i = 0; i < children.length; i++) {
			Control control = children[i];
			GridBagConstraints c = constraints[i] = getConstraints(control);
			int x = c.grid.x;
			int y = c.grid.y;
			if (x == RELATIVE) {
				x = cursorX;
			}
			if (y == RELATIVE) {
				y = cursorY;
			}
			resolvedX[i] = x;
			resolvedY[i] = y;
			// Use at least 1 for tentative span during dimension calculation
			resolvedSpanX[i] = Math.max(1, c.span.x);
			resolvedSpanY[i] = Math.max(1, c.span.y);

			// Update grid dimensions
			int xd = x + resolvedSpanX[i];
			if (xd > grid.dimension.x) {
				grid.dimension.x = xd;
			}
			int yd = y + resolvedSpanY[i];
			if (yd > grid.dimension.y) {
				grid.dimension.y = yd;
			}

			// Advance cursor position for next RELATIVE component
			cursorX = x + resolvedSpanX[i];
			cursorY = y;

			grid.positionMap.put(control, new Point(x, y));
			grid.constraintMap.put(control, c);
		}

		// Second pass: resolve REMAINDER spans now that dimensions are known
		for (int i = 0; i < children.length; i++) {
			GridBagConstraints c = constraints[i];
			if (c.span.x == REMAINDER) {
				resolvedSpanX[i] = Math.max(1, grid.dimension.x - resolvedX[i]);
			}
			if (c.span.y == REMAINDER) {
				resolvedSpanY[i] = Math.max(1, grid.dimension.y - resolvedY[i]);
			}
		}

		// Build grid arrays
		grid.controls = new Control[grid.dimension.x][grid.dimension.y];
		grid.cols = new int[grid.dimension.x];
		grid.rows = new int[grid.dimension.y];
		grid.rowWeights = new double[grid.rows.length];
		grid.colWeights = new double[grid.cols.length];

		// Third pass: compute sizes and weights
		for (int i = 0; i < children.length; i++) {
			Control control = children[i];
			GridBagConstraints c = constraints[i];
			int spanX = resolvedSpanX[i];
			int spanY = resolvedSpanY[i];

			Point size = control.computeSize(c.wHint, c.hHint, changed);
			grid.sizeMap.put(control, size);
			grid.resolvedSpans.put(control, new Point(spanX, spanY));

			int x = resolvedX[i];
			int y = resolvedY[i];
			int w = size.x / spanX;
			int h = size.y / spanY;
			grid.controls[x][y] = control;

			for (int gi = x; gi < x + spanX; gi++) {
				if (w > grid.cols[gi]) {
					grid.cols[gi] = w;
				}
			}
			for (int gi = y; gi < y + spanY; gi++) {
				if (h > grid.rows[gi]) {
					grid.rows[gi] = h;
				}
			}

			double colWeight = (double) c.weight.x / spanX;
			double rowWeight = (double) c.weight.y / spanY;
			for (int gi = x; gi < x + spanX; gi++) {
				if (colWeight > grid.colWeights[gi]) {
					grid.colWeights[gi] = colWeight;
				}
			}
			for (int gi = y; gi < y + spanY; gi++) {
				if (rowWeight > grid.rowWeights[gi]) {
					grid.rowWeights[gi] = rowWeight;
				}
			}
		}

		composite.setData(DATA_KEY, grid);
		return grid;
	}

	static GridBagConstraints getConstraints(Control control) {
		Object layoutData = control.getLayoutData();
		if (layoutData instanceof GridBagConstraints) {
			return (GridBagConstraints) layoutData;
		}
		return DEFAULT;
	}

	@Override
	public String toString() {
		return "GridBagConstraints [grid=" + grid.x + "," + grid.y
				+ " span=" + span.x + "," + span.y
				+ " weight=" + weight.x + "," + weight.y
				+ " fill=" + fillString(fill)
				+ "]";
	}

	private static String fillString(int fill) {
		return switch (fill) {
		case SWT.HORIZONTAL -> "SWT.HORIZONTAL";
		case SWT.VERTICAL -> "SWT.VERTICAL";
		case SWT.FILL -> "SWT.FILL";
		default -> "SWT.NONE";
		};
	}

	static final class GridBag {

		int[] cols;

		int[] rows;

		double[] rowWeights;

		double[] colWeights;

		Point dimension = new Point(0, 0);

		Map<Control, Point> positionMap = new HashMap<>();

		Map<Control, GridBagConstraints> constraintMap = new HashMap<>();

		Map<Control, Point> sizeMap = new HashMap<>();

		Map<Control, Point> resolvedSpans = new HashMap<>();

		Control[][] controls;

		Point getSize(Control control) {
			return sizeMap.get(control);
		}

		Point getResolvedSpan(Control control) {
			return resolvedSpans.get(control);
		}

		int[] getRowHeights(int height) {
			if (rows.length == 0) {
				return new int[0];
			}
			int[] is = new int[rows.length];
			double weights = 0;
			for (int i = 0; i < is.length; i++) {
				weights += rowWeights[i];
			}
			if (weights <= 0) {
				// No weights defined: distribute equally
				int perRow = height / rows.length;
				Arrays.fill(is, perRow);
				is[is.length - 1] += height - perRow * rows.length;
				return is;
			}
			double dy = (double) height / weights;
			int sum = 0;
			for (int i = 0; i < is.length; i++) {
				is[i] = (int) Math.rint(dy * rowWeights[i]);
				sum += is[i];
			}
			// any rounding error goes to the last row
			is[is.length - 1] += height - sum;
			return is;
		}

		int[] getColumnWidths(int width) {
			if (cols.length == 0) {
				return new int[0];
			}
			int[] is = new int[cols.length];
			double weights = 0;
			for (int i = 0; i < is.length; i++) {
				weights += colWeights[i];
			}
			if (weights <= 0) {
				// No weights defined: distribute equally
				int perCol = width / cols.length;
				Arrays.fill(is, perCol);
				is[is.length - 1] += width - perCol * cols.length;
				return is;
			}
			double dx = (double) width / weights;
			int sum = 0;
			for (int i = 0; i < is.length; i++) {
				is[i] = (int) Math.rint(dx * colWeights[i]);
				sum += is[i];
			}
			// any rounding error goes to the last column
			is[is.length - 1] += width - sum;
			return is;
		}

	}
}
