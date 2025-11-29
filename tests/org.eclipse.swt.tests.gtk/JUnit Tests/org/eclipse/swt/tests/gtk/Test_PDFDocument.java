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
package org.eclipse.swt.tests.gtk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.printing.PDFDocument;
import org.eclipse.swt.widgets.Display;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Automated Test Suite for class org.eclipse.swt.printing.PDFDocument
 *
 * @see org.eclipse.swt.printing.PDFDocument
 */
public class Test_PDFDocument {

	private static Display display;
	
	@TempDir
	File tempDir;
	
	private PDFDocument pdfDocument;

	@BeforeAll
	public static void setUpBeforeClass() {
		display = Display.getDefault();
	}

	@AfterAll
	public static void tearDownAfterClass() {
		if (display != null && !display.isDisposed()) {
			display.dispose();
		}
	}
	
	@AfterEach
	public void tearDown() {
		if (pdfDocument != null && !pdfDocument.isDisposed()) {
			pdfDocument.dispose();
		}
	}

	@Test
	public void test_Constructor_NullFilename() {
		assertThrows(IllegalArgumentException.class, () -> new PDFDocument(null, 612, 792));
	}

	@Test
	public void test_Constructor_InvalidDimensions() {
		String filename = new File(tempDir, "test.pdf").getAbsolutePath();
		assertThrows(IllegalArgumentException.class, () -> new PDFDocument(filename, 0, 792));
		assertThrows(IllegalArgumentException.class, () -> new PDFDocument(filename, 612, 0));
		assertThrows(IllegalArgumentException.class, () -> new PDFDocument(filename, -1, 792));
		assertThrows(IllegalArgumentException.class, () -> new PDFDocument(filename, 612, -1));
	}

	@Test
	public void test_Constructor_ValidParameters() {
		String filename = new File(tempDir, "test_valid.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(filename, 612, 792);
		assertNotNull(pdfDocument);
		assertFalse(pdfDocument.isDisposed());
	}

	@Test
	public void test_ConstructorWithDevice() {
		String filename = new File(tempDir, "test_device.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		assertNotNull(pdfDocument);
		assertFalse(pdfDocument.isDisposed());
	}

	@Test
	public void test_getWidth() {
		String filename = new File(tempDir, "test_width.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		assertEquals(612.0, pdfDocument.getWidth(), 0.001);
	}

	@Test
	public void test_getHeight() {
		String filename = new File(tempDir, "test_height.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		assertEquals(792.0, pdfDocument.getHeight(), 0.001);
	}

	@Test
	public void test_isAutoScalable() {
		String filename = new File(tempDir, "test_autoscale.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		assertFalse(pdfDocument.isAutoScalable());
	}

	@Test
	public void test_dispose() {
		String filename = new File(tempDir, "test_dispose.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		assertFalse(pdfDocument.isDisposed());
		pdfDocument.dispose();
		assertTrue(pdfDocument.isDisposed());
	}

	@Test
	public void test_createGC() {
		String filename = new File(tempDir, "test_gc.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		GC gc = new GC(pdfDocument);
		assertNotNull(gc);
		gc.dispose();
	}

	@Test
	public void test_drawOnGC() {
		String filename = new File(tempDir, "test_draw.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		GC gc = new GC(pdfDocument);
		
		// Test drawing operations - should not throw exceptions
		gc.drawRectangle(10, 10, 100, 80);
		gc.drawText("Hello, PDF!", 50, 50);
		gc.drawLine(0, 0, 100, 100);
		
		gc.dispose();
		pdfDocument.dispose();
		
		// Verify file was created
		File file = new File(filename);
		assertTrue(file.exists(), "PDF file should have been created");
		assertTrue(file.length() > 0, "PDF file should not be empty");
	}

	@Test
	public void test_newPage() {
		String filename = new File(tempDir, "test_newpage.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		GC gc = new GC(pdfDocument);
		
		gc.drawText("Page 1", 50, 50);
		pdfDocument.newPage();
		gc.drawText("Page 2", 50, 50);
		
		gc.dispose();
		pdfDocument.dispose();
		
		// Verify file was created
		File file = new File(filename);
		assertTrue(file.exists(), "PDF file should have been created");
	}

	@Test
	public void test_newPageWithDifferentSize() {
		String filename = new File(tempDir, "test_newpage_size.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792); // Letter size
		
		assertEquals(612.0, pdfDocument.getWidth(), 0.001);
		assertEquals(792.0, pdfDocument.getHeight(), 0.001);
		
		GC gc = new GC(pdfDocument);
		gc.drawText("Page 1 - Letter", 50, 50);
		
		pdfDocument.newPage(842, 595); // A4 Landscape
		
		assertEquals(842.0, pdfDocument.getWidth(), 0.001);
		assertEquals(595.0, pdfDocument.getHeight(), 0.001);
		
		gc.drawText("Page 2 - A4 Landscape", 50, 50);
		
		gc.dispose();
		pdfDocument.dispose();
	}

	@Test
	public void test_operationsAfterDispose() {
		String filename = new File(tempDir, "test_disposed.pdf").getAbsolutePath();
		pdfDocument = new PDFDocument(display, filename, 612, 792);
		pdfDocument.dispose();
		
		assertThrows(Exception.class, () -> pdfDocument.getWidth());
		assertThrows(Exception.class, () -> pdfDocument.getHeight());
		assertThrows(Exception.class, () -> pdfDocument.newPage());
	}
}
