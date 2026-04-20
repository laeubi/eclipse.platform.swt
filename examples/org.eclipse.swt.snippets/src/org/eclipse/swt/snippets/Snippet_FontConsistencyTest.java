/*******************************************************************************
 * Copyright (c) 2026 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier:  EPL-2.0
 *
 * Contributors:
 *     Eclipse Community - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

/*
 * Font Cross-Platform Consistency Test
 * 
 * This snippet visualizes font rendering in fixed-size boxes to test
 * cross-platform consistency. It is based on the test case from issue #2925.
 * 
 * Expected behavior:
 * - The same font with the same height should produce the same visual size
 *   across all platforms (Windows, Linux, macOS)
 * - A font of height H should fit within a box of height 2*H with some padding
 * - The font should occupy approximately 70% of the box height (7 grid units
 *   out of 10)
 * 
 * How to use:
 * 1. Run this snippet on different platforms
 * 2. Take screenshots
 * 3. Compare visual appearance
 * 4. Fonts should appear the same size relative to the grid
 * 
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet_FontConsistencyTest {
	
	static final String DEFAULT_TEXT = "The quick brown fox jumps over the lazy dog";
	static final String[] COMMON_FONTS = {
		"Arial", "Helvetica", "Verdana", "Tahoma", 
		"Times New Roman", "Courier New", "Georgia", "System"
	};
	static final int[] COMMON_HEIGHTS = {8, 9, 10, 11, 12, 14, 16, 18, 20, 24, 28, 32, 36, 48, 72};
	static final int GRID_SIZE = 10;
	static final int BOX_PADDING = 20;
	
	private static Canvas canvas;
	private static Combo fontCombo;
	private static Combo heightCombo;
	private static Text textInput;
	private static Button boldCheck;
	private static Button italicCheck;
	private static Button showGridCheck;
	private static Label infoLabel;
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Font Cross-Platform Consistency Test");
		shell.setLayout(new GridLayout(1, false));
		
		createInfoPanel(shell, display);
		createControlPanel(shell, display);
		createCanvas(shell);
		
		shell.setSize(900, 750);
		shell.open();
		
		// Initial render
		updateCanvas();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	private static void createInfoPanel(Shell shell, Display display) {
		Composite infoPanel = new Composite(shell, SWT.BORDER);
		infoPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		infoPanel.setLayout(new GridLayout(1, false));
		infoPanel.setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		
		Label titleLabel = new Label(infoPanel, SWT.NONE);
		titleLabel.setText("Cross-Platform Font Consistency Test (Issue #2925)");
		titleLabel.setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		Font boldFont = new Font(display, "System", 10, SWT.BOLD);
		titleLabel.setFont(boldFont);
		
		infoLabel = new Label(infoPanel, SWT.WRAP);
		infoLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		infoLabel.setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		
		updateInfoLabel(display);
	}
	
	private static void updateInfoLabel(Display display) {
		Point dpi = display.getDPI();
		String platform = SWT.getPlatform();
		
		StringBuilder info = new StringBuilder();
		info.append("Platform: ").append(platform);
		info.append(" | DPI: ").append(dpi.y);
		info.append(" | Expected: Font height H should occupy ~70% of box height 2*H");
		
		if (infoLabel != null && !infoLabel.isDisposed()) {
			infoLabel.setText(info.toString());
		}
	}
	
	private static void createControlPanel(Shell shell, Display display) {
		Composite controlPanel = new Composite(shell, SWT.BORDER);
		controlPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		controlPanel.setLayout(new GridLayout(4, false));
		
		// Font selection
		Label fontLabel = new Label(controlPanel, SWT.NONE);
		fontLabel.setText("Font:");
		fontCombo = new Combo(controlPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
		
		// Populate with available fonts
		FontData[] fontList = display.getFontList(null, true);
		java.util.Set<String> uniqueFonts = new java.util.TreeSet<>();
		for (FontData fd : fontList) {
			uniqueFonts.add(fd.getName());
		}
		
		// Add common fonts first if available
		for (String commonFont : COMMON_FONTS) {
			if (uniqueFonts.contains(commonFont)) {
				fontCombo.add(commonFont);
			}
		}
		fontCombo.add("---");
		for (String fontName : uniqueFonts) {
			fontCombo.add(fontName);
		}
		fontCombo.select(0);
		fontCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCanvas();
			}
		});
		
		// Font height selection
		Label heightLabel = new Label(controlPanel, SWT.NONE);
		heightLabel.setText("Height:");
		heightCombo = new Combo(controlPanel, SWT.DROP_DOWN);
		for (int height : COMMON_HEIGHTS) {
			heightCombo.add(String.valueOf(height));
		}
		heightCombo.setText("12");
		heightCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCanvas();
			}
		});
		heightCombo.addModifyListener(e -> updateCanvas());
		
		// Text input
		Label textLabel = new Label(controlPanel, SWT.NONE);
		textLabel.setText("Text:");
		textLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		
		textInput = new Text(controlPanel, SWT.BORDER);
		textInput.setText(DEFAULT_TEXT);
		GridData textData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		textData.horizontalSpan = 3;
		textInput.setLayoutData(textData);
		textInput.addModifyListener(e -> updateCanvas());
		
		// Style options
		Label styleLabel = new Label(controlPanel, SWT.NONE);
		styleLabel.setText("Style:");
		
		boldCheck = new Button(controlPanel, SWT.CHECK);
		boldCheck.setText("Bold");
		boldCheck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCanvas();
			}
		});
		
		italicCheck = new Button(controlPanel, SWT.CHECK);
		italicCheck.setText("Italic");
		italicCheck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCanvas();
			}
		});
		
		// Show grid option
		showGridCheck = new Button(controlPanel, SWT.CHECK);
		showGridCheck.setText("Show Grid");
		showGridCheck.setSelection(true);
		showGridCheck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCanvas();
			}
		});
	}
	
	private static void createCanvas(Shell shell) {
		canvas = new Canvas(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData canvasData = new GridData(SWT.FILL, SWT.FILL, true, true);
		canvasData.heightHint = 500;
		canvas.setLayoutData(canvasData);
		canvas.setBackground(canvas.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		
		canvas.addPaintListener(e -> paintCanvas(e.gc));
	}
	
	private static void updateCanvas() {
		if (canvas != null && !canvas.isDisposed()) {
			canvas.redraw();
		}
	}
	
	private static void paintCanvas(GC gc) {
		String fontName = fontCombo.getText();
		if (fontName.equals("---")) {
			return;
		}
		
		int height;
		try {
			height = Integer.parseInt(heightCombo.getText());
		} catch (NumberFormatException e) {
			height = 12;
		}
		
		int style = SWT.NORMAL;
		if (boldCheck.getSelection()) style |= SWT.BOLD;
		if (italicCheck.getSelection()) style |= SWT.ITALIC;
		
		FontData fontData = new FontData(fontName, height, style);
		Font font = new Font(gc.getDevice(), fontData);
		
		gc.setFont(font);
		String text = textInput.getText();
		
		// Calculate box dimensions based on font height
		Rectangle clientArea = canvas.getClientArea();
		int boxHeight = height * 2;
		int boxWidth = clientArea.width - (BOX_PADDING * 2);
		int boxX = BOX_PADDING;
		int boxY = BOX_PADDING;
		
		// Draw grid background if enabled
		if (showGridCheck.getSelection()) {
			drawGrid(gc, boxX, boxY, boxWidth, boxHeight);
		}
		
		// Draw the fixed-size box
		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_DARK_GRAY));
		gc.setLineWidth(2);
		gc.drawRectangle(boxX, boxY, boxWidth, boxHeight);
		
		// Get text metrics for centering
		Point textExtent = gc.textExtent(text);
		FontMetrics metrics = gc.getFontMetrics();
		
		// Calculate centered position
		int textX = boxX + (boxWidth - textExtent.x) / 2;
		int textY = boxY + (boxHeight - textExtent.y) / 2;
		
		// Draw the text centered in the box
		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
		gc.setLineWidth(1);
		gc.drawText(text, textX, textY, true);
		
		// Draw crosshair at center for reference
		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_RED));
		gc.setLineStyle(SWT.LINE_DOT);
		int centerX = boxX + boxWidth / 2;
		int centerY = boxY + boxHeight / 2;
		gc.drawLine(centerX, boxY, centerX, boxY + boxHeight);
		gc.drawLine(boxX, centerY, boxX + boxWidth, centerY);
		gc.setLineStyle(SWT.LINE_SOLID);
		
		// Draw measurements
		Font labelFont = new Font(gc.getDevice(), "System", 8, SWT.NORMAL);
		gc.setFont(labelFont);
		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_DARK_BLUE));
		
		// Box dimensions label
		String boxLabel = String.format("Box: %d × %d (height × 2)", boxWidth, boxHeight);
		gc.drawText(boxLabel, boxX, boxY - 18, true);
		
		// Font height label
		String heightLabel = String.format("Font Height: %d pt", height);
		gc.drawText(heightLabel, boxX + boxWidth - gc.textExtent(heightLabel).x, boxY - 18, true);
		
		// Font metrics info
		int infoY = boxY + boxHeight + 20;
		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_DARK_GREEN));
		gc.drawText("Font Metrics:", boxX, infoY, true);
		infoY += 20;
		gc.drawText(String.format("  Height: %d pixels", metrics.getHeight()), boxX, infoY, true);
		infoY += 15;
		gc.drawText(String.format("  Ascent: %d pixels", metrics.getAscent()), boxX, infoY, true);
		infoY += 15;
		gc.drawText(String.format("  Descent: %d pixels", metrics.getDescent()), boxX, infoY, true);
		infoY += 15;
		gc.drawText(String.format("  Leading: %d pixels", metrics.getLeading()), boxX, infoY, true);
		infoY += 15;
		gc.drawText(String.format("  Text Extent: %d × %d pixels", textExtent.x, textExtent.y), boxX, infoY, true);
		
		// Platform info
		infoY += 25;
		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_DARK_RED));
		Point dpi = gc.getDevice().getDPI();
		gc.drawText(String.format("Platform DPI: %d", dpi.y), boxX, infoY, true);
		infoY += 15;
		String platform = SWT.getPlatform();
		gc.drawText(String.format("Platform: %s", platform), boxX, infoY, true);
		
		// Consistency check
		infoY += 25;
		float heightRatio = (float)metrics.getHeight() / boxHeight;
		boolean consistent = heightRatio >= 0.65f && heightRatio <= 0.75f;
		gc.setForeground(gc.getDevice().getSystemColor(
			consistent ? SWT.COLOR_DARK_GREEN : SWT.COLOR_DARK_RED));
		gc.drawText(String.format("Consistency Check: %s (ratio: %.2f, expected: 0.70)",
			consistent ? "PASS" : "FAIL", heightRatio), boxX, infoY, true);
		
		labelFont.dispose();
		font.dispose();
	}
	
	private static void drawGrid(GC gc, int x, int y, int width, int height) {
		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_GRAY));
		gc.setLineStyle(SWT.LINE_DOT);
		gc.setAlpha(100);
		
		// Draw vertical grid lines
		for (int i = 0; i <= width; i += GRID_SIZE) {
			gc.drawLine(x + i, y, x + i, y + height);
		}
		
		// Draw horizontal grid lines
		for (int i = 0; i <= height; i += GRID_SIZE) {
			gc.drawLine(x, y + i, x + width, y + i);
		}
		
		gc.setAlpha(255);
		gc.setLineStyle(SWT.LINE_SOLID);
	}
}
