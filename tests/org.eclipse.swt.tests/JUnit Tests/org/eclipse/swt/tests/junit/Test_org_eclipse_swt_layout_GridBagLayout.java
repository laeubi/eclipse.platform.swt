/*******************************************************************************
 * Copyright (c) 2024 Christoph Läubrich and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.tests.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridBagConstraints;
import org.eclipse.swt.layout.GridBagLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Automated Test Suite for class {@link GridBagLayout}
 */
public class Test_org_eclipse_swt_layout_GridBagLayout {
	Display display;

	@BeforeEach
	public void setUp() {
		display = Display.getDefault();
	}

	@Test
	public void testEmptyLayout() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(800, 600);
		shell.open();
		SwtTestUtil.processEvents();
		// Empty layout should not throw
		Point size = shell.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		assertEquals(0, size.x);
		assertEquals(0, size.y);
		shell.dispose();
	}

	@Test
	public void testSingleControlFill() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(800, 600);
		MockControl control = new MockControl(shell);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.grid.x = 0;
		gbc.grid.y = 0;
		gbc.weight.x = 100;
		gbc.weight.y = 100;
		gbc.fill = SWT.FILL;
		control.setLayoutData(gbc);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle bounds = control.getBounds();
		assertEquals(0, bounds.x);
		assertEquals(0, bounds.y);
		assertEquals(clientArea.width, bounds.width);
		assertEquals(clientArea.height, bounds.height);
		shell.dispose();
	}

	@Test
	public void testWeightDistribution() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(800, 600);
		MockControl left = new MockControl(shell);
		GridBagConstraints gbcLeft = new GridBagConstraints();
		gbcLeft.grid.x = 0;
		gbcLeft.grid.y = 0;
		gbcLeft.weight.x = 25;
		gbcLeft.weight.y = 100;
		gbcLeft.fill = SWT.FILL;
		left.setLayoutData(gbcLeft);
		MockControl right = new MockControl(shell);
		GridBagConstraints gbcRight = new GridBagConstraints();
		gbcRight.grid.x = 1;
		gbcRight.grid.y = 0;
		gbcRight.weight.x = 75;
		gbcRight.weight.y = 100;
		gbcRight.fill = SWT.FILL;
		right.setLayoutData(gbcRight);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle leftBounds = left.getBounds();
		Rectangle rightBounds = right.getBounds();
		// Left should get ~25% of width, right ~75%
		int expectedLeftWidth = (int) Math.rint(clientArea.width * 25.0 / 100);
		int expectedRightWidth = clientArea.width - expectedLeftWidth;
		// Allow 1px tolerance for rounding
		assertTrue(Math.abs(leftBounds.width - expectedLeftWidth) <= 1,
				"Left width " + leftBounds.width + " should be ~" + expectedLeftWidth);
		assertTrue(Math.abs(rightBounds.width - expectedRightWidth) <= 1,
				"Right width " + rightBounds.width + " should be ~" + expectedRightWidth);
		// Both should use full height
		assertEquals(clientArea.height, leftBounds.height);
		assertEquals(clientArea.height, rightBounds.height);
		// Left starts at 0, right starts after left
		assertEquals(0, leftBounds.x);
		assertEquals(leftBounds.width, rightBounds.x);
		shell.dispose();
	}

	@Test
	public void testColumnSpanning() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(600, 400);
		// Row 0: spanning control across 2 columns
		MockControl spanning = new MockControl(shell);
		GridBagConstraints gbcSpan = new GridBagConstraints();
		gbcSpan.grid.x = 0;
		gbcSpan.grid.y = 0;
		gbcSpan.span.x = 2;
		gbcSpan.weight.x = 50;
		gbcSpan.weight.y = 50;
		gbcSpan.fill = SWT.FILL;
		spanning.setLayoutData(gbcSpan);
		// Row 1: two controls
		MockControl bottomLeft = new MockControl(shell);
		GridBagConstraints gbcBL = new GridBagConstraints();
		gbcBL.grid.x = 0;
		gbcBL.grid.y = 1;
		gbcBL.weight.x = 50;
		gbcBL.weight.y = 50;
		gbcBL.fill = SWT.FILL;
		bottomLeft.setLayoutData(gbcBL);
		MockControl bottomRight = new MockControl(shell);
		GridBagConstraints gbcBR = new GridBagConstraints();
		gbcBR.grid.x = 1;
		gbcBR.grid.y = 1;
		gbcBR.weight.x = 50;
		gbcBR.weight.y = 50;
		gbcBR.fill = SWT.FILL;
		bottomRight.setLayoutData(gbcBR);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle spanBounds = spanning.getBounds();
		// Spanning control should take full width
		assertEquals(clientArea.width, spanBounds.width);
		// Bottom controls should each take half the width
		Rectangle blBounds = bottomLeft.getBounds();
		Rectangle brBounds = bottomRight.getBounds();
		assertEquals(clientArea.width, blBounds.width + brBounds.width);
		shell.dispose();
	}

	@Test
	public void testRowSpanning() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(600, 400);
		// Column 0, spanning 2 rows
		MockControl spanning = new MockControl(shell);
		GridBagConstraints gbcSpan = new GridBagConstraints();
		gbcSpan.grid.x = 0;
		gbcSpan.grid.y = 0;
		gbcSpan.span.y = 2;
		gbcSpan.weight.x = 50;
		gbcSpan.weight.y = 50;
		gbcSpan.fill = SWT.FILL;
		spanning.setLayoutData(gbcSpan);
		// Column 1, row 0
		MockControl topRight = new MockControl(shell);
		GridBagConstraints gbcTR = new GridBagConstraints();
		gbcTR.grid.x = 1;
		gbcTR.grid.y = 0;
		gbcTR.weight.x = 50;
		gbcTR.weight.y = 50;
		gbcTR.fill = SWT.FILL;
		topRight.setLayoutData(gbcTR);
		// Column 1, row 1
		MockControl bottomRight = new MockControl(shell);
		GridBagConstraints gbcBR = new GridBagConstraints();
		gbcBR.grid.x = 1;
		gbcBR.grid.y = 1;
		gbcBR.weight.x = 50;
		gbcBR.weight.y = 50;
		gbcBR.fill = SWT.FILL;
		bottomRight.setLayoutData(gbcBR);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle spanBounds = spanning.getBounds();
		// Spanning control should take full height
		assertEquals(clientArea.height, spanBounds.height);
		// Right controls should each take half the height
		Rectangle trBounds = topRight.getBounds();
		Rectangle brBounds = bottomRight.getBounds();
		assertEquals(clientArea.height, trBounds.height + brBounds.height);
		shell.dispose();
	}

	@Test
	public void testFillNone() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(800, 600);
		MockControl control = new MockControl(shell);
		control.reportedWidth = 50;
		control.reportedHeight = 30;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.grid.x = 0;
		gbc.grid.y = 0;
		gbc.weight.x = 100;
		gbc.weight.y = 100;
		gbc.fill = SWT.NONE;
		control.setLayoutData(gbc);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle bounds = control.getBounds();
		// With NONE fill, control should use its preferred size (capped at cell)
		assertEquals(50, bounds.width);
		assertEquals(30, bounds.height);
		shell.dispose();
	}

	@Test
	public void testFillHorizontal() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(800, 600);
		MockControl control = new MockControl(shell);
		control.reportedWidth = 50;
		control.reportedHeight = 30;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.grid.x = 0;
		gbc.grid.y = 0;
		gbc.weight.x = 100;
		gbc.weight.y = 100;
		gbc.fill = SWT.HORIZONTAL;
		control.setLayoutData(gbc);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle bounds = control.getBounds();
		// HORIZONTAL fill: full width, preferred height
		assertEquals(clientArea.width, bounds.width);
		assertEquals(30, bounds.height);
		shell.dispose();
	}

	@Test
	public void testFillVertical() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(800, 600);
		MockControl control = new MockControl(shell);
		control.reportedWidth = 50;
		control.reportedHeight = 30;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.grid.x = 0;
		gbc.grid.y = 0;
		gbc.weight.x = 100;
		gbc.weight.y = 100;
		gbc.fill = SWT.VERTICAL;
		control.setLayoutData(gbc);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle bounds = control.getBounds();
		// VERTICAL fill: preferred width, full height
		assertEquals(50, bounds.width);
		assertEquals(clientArea.height, bounds.height);
		shell.dispose();
	}

	@Test
	public void testComputeSize() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		MockControl c1 = new MockControl(shell);
		c1.reportedWidth = 100;
		c1.reportedHeight = 50;
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.grid.x = 0;
		gbc1.grid.y = 0;
		gbc1.weight.x = 50;
		gbc1.weight.y = 100;
		c1.setLayoutData(gbc1);
		MockControl c2 = new MockControl(shell);
		c2.reportedWidth = 200;
		c2.reportedHeight = 80;
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.grid.x = 1;
		gbc2.grid.y = 0;
		gbc2.weight.x = 50;
		gbc2.weight.y = 100;
		c2.setLayoutData(gbc2);
		// computeSize with SWT.DEFAULT should sum preferred widths and use max height
		Point size = shell.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		// width = sum of column preferred widths = 100 + 200 = 300
		assertTrue(size.x >= 300,
				"Computed width " + size.x + " should be at least 300");
		// height = max row height = max(50, 80) = 80
		assertTrue(size.y >= 80,
				"Computed height " + size.y + " should be at least 80");
		shell.dispose();
	}

	@Test
	public void testComputeSizeWithHints() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		MockControl control = new MockControl(shell);
		control.reportedWidth = 100;
		control.reportedHeight = 50;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.grid.x = 0;
		gbc.grid.y = 0;
		gbc.weight.x = 100;
		gbc.weight.y = 100;
		control.setLayoutData(gbc);
		// When hints are provided, they should be returned
		Point size = shell.computeSize(500, 400);
		assertEquals(500, size.x);
		assertEquals(400, size.y);
		shell.dispose();
	}

	@Test
	public void testRelativePositioning() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(600, 400);
		// First control: RELATIVE position (defaults), should go to (0,0)
		MockControl c1 = new MockControl(shell);
		GridBagConstraints gbc1 = new GridBagConstraints();
		// grid defaults to (RELATIVE, RELATIVE)
		gbc1.weight.x = 50;
		gbc1.weight.y = 100;
		gbc1.fill = SWT.FILL;
		c1.setLayoutData(gbc1);
		// Second control: RELATIVE position, should go to (1,0)
		MockControl c2 = new MockControl(shell);
		GridBagConstraints gbc2 = new GridBagConstraints();
		// grid defaults to (RELATIVE, RELATIVE)
		gbc2.weight.x = 50;
		gbc2.weight.y = 100;
		gbc2.fill = SWT.FILL;
		c2.setLayoutData(gbc2);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle b1 = c1.getBounds();
		Rectangle b2 = c2.getBounds();
		// c1 at (0,0), c2 at (1,0)
		assertEquals(0, b1.x);
		assertEquals(0, b1.y);
		assertTrue(b2.x > 0, "Second control should be to the right of first");
		assertEquals(0, b2.y);
		// Both should have equal width (~50% each)
		assertEquals(clientArea.width, b1.width + b2.width);
		shell.dispose();
	}

	@Test
	public void testRemainderSpan() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(600, 400);
		// Row 0: three columns
		for (int col = 0; col < 3; col++) {
			MockControl c = new MockControl(shell);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.grid.x = col;
			gbc.grid.y = 0;
			gbc.weight.x = 33;
			gbc.weight.y = 50;
			gbc.fill = SWT.FILL;
			c.setLayoutData(gbc);
		}
		// Row 1: control with REMAINDER span.x from column 0
		MockControl spanning = new MockControl(shell);
		GridBagConstraints gbcSpan = new GridBagConstraints();
		gbcSpan.grid.x = 0;
		gbcSpan.grid.y = 1;
		gbcSpan.span.x = GridBagConstraints.REMAINDER;
		gbcSpan.weight.y = 50;
		gbcSpan.fill = SWT.FILL;
		spanning.setLayoutData(gbcSpan);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle spanBounds = spanning.getBounds();
		// REMAINDER control should span all 3 columns = full width
		assertEquals(clientArea.width, spanBounds.width);
		shell.dispose();
	}

	@Test
	public void testRemainderSpanPartial() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(600, 400);
		// Row 0: three columns
		for (int col = 0; col < 3; col++) {
			MockControl c = new MockControl(shell);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.grid.x = col;
			gbc.grid.y = 0;
			gbc.weight.x = 33;
			gbc.weight.y = 50;
			gbc.fill = SWT.FILL;
			c.setLayoutData(gbc);
		}
		// Row 1: col 0 is fixed, col 1 with REMAINDER spans to end
		MockControl fixedCol = new MockControl(shell);
		GridBagConstraints gbcFixed = new GridBagConstraints();
		gbcFixed.grid.x = 0;
		gbcFixed.grid.y = 1;
		gbcFixed.weight.y = 50;
		gbcFixed.fill = SWT.FILL;
		fixedCol.setLayoutData(gbcFixed);
		MockControl spanning = new MockControl(shell);
		GridBagConstraints gbcSpan = new GridBagConstraints();
		gbcSpan.grid.x = 1;
		gbcSpan.grid.y = 1;
		gbcSpan.span.x = GridBagConstraints.REMAINDER;
		gbcSpan.weight.y = 50;
		gbcSpan.fill = SWT.FILL;
		spanning.setLayoutData(gbcSpan);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle fixedBounds = fixedCol.getBounds();
		Rectangle spanBounds = spanning.getBounds();
		// Spanning control should start at fixedCol's right edge
		assertEquals(fixedBounds.x + fixedBounds.width, spanBounds.x);
		// And extend to the right edge
		assertEquals(clientArea.width, spanBounds.x + spanBounds.width);
		shell.dispose();
	}

	@Test
	public void testZeroWeightsDistributeEqually() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(600, 400);
		// Two controls with no weights set
		MockControl c1 = new MockControl(shell);
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.grid.x = 0;
		gbc1.grid.y = 0;
		gbc1.fill = SWT.FILL;
		c1.setLayoutData(gbc1);
		MockControl c2 = new MockControl(shell);
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.grid.x = 1;
		gbc2.grid.y = 0;
		gbc2.fill = SWT.FILL;
		c2.setLayoutData(gbc2);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		Rectangle b1 = c1.getBounds();
		Rectangle b2 = c2.getBounds();
		// With zero weights, should distribute equally
		int halfWidth = clientArea.width / 2;
		assertTrue(Math.abs(b1.width - halfWidth) <= 1,
				"Control 1 width " + b1.width + " should be ~" + halfWidth);
		assertTrue(Math.abs(b2.width - (clientArea.width - halfWidth)) <= 1,
				"Control 2 width " + b2.width + " should be ~" + (clientArea.width - halfWidth));
		shell.dispose();
	}

	@Test
	public void testGridBagConstraintsToString() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.grid.x = 1;
		gbc.grid.y = 2;
		gbc.span.x = 3;
		gbc.span.y = 4;
		gbc.weight.x = 50;
		gbc.weight.y = 60;
		gbc.fill = SWT.FILL;
		String str = gbc.toString();
		assertTrue(str.contains("1"), "toString should contain grid x");
		assertTrue(str.contains("2"), "toString should contain grid y");
		assertTrue(str.contains("SWT.FILL"), "toString should contain fill");
	}

	@Test
	public void testMultipleRowsAndColumns() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(900, 600);
		// Create a 3x3 grid
		MockControl[][] controls = new MockControl[3][3];
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				controls[col][row] = new MockControl(shell);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.grid.x = col;
				gbc.grid.y = row;
				gbc.weight.x = 33;
				gbc.weight.y = 33;
				gbc.fill = SWT.FILL;
				controls[col][row].setLayoutData(gbc);
			}
		}
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		// Each cell should be approximately 1/3 of the total size
		int expectedWidth = clientArea.width / 3;
		int expectedHeight = clientArea.height / 3;
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				Rectangle bounds = controls[col][row].getBounds();
				assertTrue(Math.abs(bounds.width - expectedWidth) <= 2,
						"Cell [" + col + "," + row + "] width " + bounds.width
								+ " should be ~" + expectedWidth);
				assertTrue(Math.abs(bounds.height - expectedHeight) <= 2,
						"Cell [" + col + "," + row + "] height " + bounds.height
								+ " should be ~" + expectedHeight);
			}
		}
		shell.dispose();
	}

	@Test
	public void testCellHintsPassedToControl() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(800, 600);
		MockControl control = new MockControl(shell);
		control.reportedWidth = 50;
		control.reportedHeight = 30;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.grid.x = 0;
		gbc.grid.y = 0;
		gbc.weight.x = 100;
		gbc.weight.y = 100;
		gbc.fill = SWT.NONE;
		control.setLayoutData(gbc);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		Rectangle clientArea = shell.getClientArea();
		// The layout should pass cell dimensions as hints to the control
		// Since no explicit wHint/hHint in constraints, the cell size is used
		assertTrue(control.lastWHint > 0,
				"wHint should be passed as cell width, was " + control.lastWHint);
		assertTrue(control.lastHHint > 0,
				"hHint should be passed as cell height, was " + control.lastHHint);
		shell.dispose();
	}

	@Test
	public void testExplicitHintsOverrideCellSize() {
		Shell shell = new Shell(display);
		shell.setLayout(new GridBagLayout());
		shell.setSize(800, 600);
		MockControl control = new MockControl(shell);
		control.reportedWidth = 50;
		control.reportedHeight = 30;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.grid.x = 0;
		gbc.grid.y = 0;
		gbc.weight.x = 100;
		gbc.weight.y = 100;
		gbc.wHint = 200;
		gbc.hHint = 100;
		gbc.fill = SWT.NONE;
		control.setLayoutData(gbc);
		shell.open();
		shell.layout();
		SwtTestUtil.processEvents();
		// When explicit hints are set in constraints, they should be used
		assertEquals(200, control.lastWHint);
		assertEquals(100, control.lastHHint);
		shell.dispose();
	}

	private static final class MockControl extends Canvas {

		private int lastWHint;
		private int lastHHint;

		private int reportedHeight = -1;
		private int reportedWidth = -1;

		public MockControl(Composite parent) {
			super(parent, SWT.NONE);
			setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		}

		@Override
		public Point computeSize(int wHint, int hHint, boolean changed) {
			this.lastWHint = wHint;
			this.lastHHint = hHint;
			if (reportedHeight > 0 && reportedWidth > 0) {
				return new Point(reportedWidth, reportedHeight);
			}
			return super.computeSize(wHint, hHint, changed);
		}

	}

}
