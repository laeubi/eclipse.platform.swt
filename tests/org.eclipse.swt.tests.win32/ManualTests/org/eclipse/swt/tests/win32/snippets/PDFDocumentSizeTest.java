/*******************************************************************************
 * Copyright (c) 2025 Eclipse Platform Contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eclipse Platform Contributors - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.tests.win32.snippets;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.printing.*;
import org.eclipse.swt.widgets.*;

/**
 * Manual test to verify that PDFDocument correctly adjusts the MediaBox
 * in generated PDF files to match the requested dimensions.
 */
public class PDFDocumentSizeTest {

	/** Pattern to find MediaBox entries in PDF files */
	private static final Pattern MEDIABOX_PATTERN = Pattern.compile("/MediaBox\\s*\\[\\s*([0-9.]+)\\s+([0-9.]+)\\s+([0-9.]+)\\s+([0-9.]+)\\s*\\]");

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("PDF Size Test");
		shell.setSize(400, 300);

		Button testButton = new Button(shell, SWT.PUSH);
		testButton.setText("Test PDF Size Adjustment");
		testButton.setBounds(100, 100, 200, 30);
		
		testButton.addListener(SWT.Selection, e -> {
			try {
				String tempDir = System.getProperty("java.io.tmpdir");
				String pdfPath = tempDir + "/test_pdf_size.pdf";
				
				// Create a PDF with custom dimensions (600x800 pixels at 96 DPI = 6.25x8.33 inches = 450x600 points)
				double width = 600;
				double height = 800;
				
				PDFDocument pdf = new PDFDocument(pdfPath, width, height);
				
				// Verify getWidth() and getHeight() return correct values
				double pdfWidth = pdf.getWidth();
				double pdfHeight = pdf.getHeight();
				double expectedWidthInPoints = width / 96.0 * 72.0;
				double expectedHeightInPoints = height / 96.0 * 72.0;
				
				System.out.println("PDFDocument.getWidth() = " + pdfWidth + " points (expected " + expectedWidthInPoints + ")");
				System.out.println("PDFDocument.getHeight() = " + pdfHeight + " points (expected " + expectedHeightInPoints + ")");
				
				GC gc = new GC(pdf);
				
				// Draw some content
				gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
				gc.drawString("Testing PDF Size: " + width + "x" + height, 50, 50);
				gc.drawRectangle(50, 100, 400, 300);
				
				gc.dispose();
				pdf.dispose();
				
				// Verify the PDF has correct MediaBox
				String result = verifyPdfMediaBox(pdfPath, width, height);
				
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				messageBox.setText("Test Result");
				messageBox.setMessage(result);
				messageBox.open();
				
				System.out.println(result);
				System.out.println("PDF created at: " + pdfPath);
				
			} catch (Exception ex) {
				MessageBox errorBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
				errorBox.setText("Error");
				errorBox.setMessage("Test failed: " + ex.getMessage());
				errorBox.open();
				ex.printStackTrace();
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	/**
	 * Verifies that the PDF file has the correct MediaBox dimensions.
	 */
	private static String verifyPdfMediaBox(String pdfPath, double requestedWidth, double requestedHeight) {
		try {
			// Read the PDF file
			byte[] pdfData = readFileBytes(pdfPath);
			String pdfContent = new String(pdfData, StandardCharsets.ISO_8859_1);
			
			// Find MediaBox entries
			Matcher matcher = MEDIABOX_PATTERN.matcher(pdfContent);
			
			// Calculate expected dimensions in points (1/72 inch)
			// At 96 DPI: width/96 * 72 points
			double expectedWidthInPoints = requestedWidth / 96.0 * 72.0;
			double expectedHeightInPoints = requestedHeight / 96.0 * 72.0;
			
			StringBuilder result = new StringBuilder();
			result.append("Expected dimensions:\n");
			result.append(String.format("  Width: %.2f points (%.2f inches)\n", expectedWidthInPoints, expectedWidthInPoints / 72.0));
			result.append(String.format("  Height: %.2f points (%.2f inches)\n", expectedHeightInPoints, expectedHeightInPoints / 72.0));
			result.append("\n");
			
			if (matcher.find()) {
				double llx = Double.parseDouble(matcher.group(1));
				double lly = Double.parseDouble(matcher.group(2));
				double urx = Double.parseDouble(matcher.group(3));
				double ury = Double.parseDouble(matcher.group(4));
				
				double actualWidth = urx - llx;
				double actualHeight = ury - lly;
				
				result.append("Actual MediaBox:\n");
				result.append(String.format("  [%.2f %.2f %.2f %.2f]\n", llx, lly, urx, ury));
				result.append(String.format("  Width: %.2f points (%.2f inches)\n", actualWidth, actualWidth / 72.0));
				result.append(String.format("  Height: %.2f points (%.2f inches)\n", actualHeight, actualHeight / 72.0));
				result.append("\n");
				
				// Check if dimensions match (with small tolerance for rounding)
				double tolerance = 1.0; // 1 point tolerance
				boolean widthMatches = Math.abs(actualWidth - expectedWidthInPoints) < tolerance;
				boolean heightMatches = Math.abs(actualHeight - expectedHeightInPoints) < tolerance;
				
				if (widthMatches && heightMatches) {
					result.append("✓ SUCCESS: PDF has correct dimensions!");
				} else {
					result.append("✗ FAIL: PDF dimensions don't match expected values!");
				}
			} else {
				result.append("✗ FAIL: Could not find MediaBox in PDF!");
			}
			
			return result.toString();
			
		} catch (Exception e) {
			return "Error verifying PDF: " + e.getMessage();
		}
	}

	private static byte[] readFileBytes(String filePath) throws IOException {
		try (FileInputStream fis = new FileInputStream(filePath);
			 ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[8192];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
			return baos.toByteArray();
		}
	}
}
