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
import org.eclipse.swt.printing.SVGDocument;
import org.eclipse.swt.widgets.Display;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Automated Test Suite for class org.eclipse.swt.printing.SVGDocument
 *
 * @see org.eclipse.swt.printing.SVGDocument
 */
public class Test_SVGDocument {

	private static Display display;
	
	@TempDir
	File tempDir;
	
	private SVGDocument svgDocument;

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
		if (svgDocument != null && !svgDocument.isDisposed()) {
			svgDocument.dispose();
		}
	}

	@Test
	public void test_Constructor_NullFilename() {
		assertThrows(IllegalArgumentException.class, () -> new SVGDocument(null, 400, 300));
	}

	@Test
	public void test_Constructor_InvalidDimensions() {
		String filename = new File(tempDir, "test.svg").getAbsolutePath();
		assertThrows(IllegalArgumentException.class, () -> new SVGDocument(filename, 0, 300));
		assertThrows(IllegalArgumentException.class, () -> new SVGDocument(filename, 400, 0));
		assertThrows(IllegalArgumentException.class, () -> new SVGDocument(filename, -1, 300));
		assertThrows(IllegalArgumentException.class, () -> new SVGDocument(filename, 400, -1));
	}

	@Test
	public void test_Constructor_ValidParameters() {
		String filename = new File(tempDir, "test_valid.svg").getAbsolutePath();
		svgDocument = new SVGDocument(filename, 400, 300);
		assertNotNull(svgDocument);
		assertFalse(svgDocument.isDisposed());
	}

	@Test
	public void test_Constructor_WithVersion() {
		String filename = new File(tempDir, "test_version.svg").getAbsolutePath();
		svgDocument = new SVGDocument(filename, 400, 300, SVGDocument.SVG_VERSION_1_1);
		assertNotNull(svgDocument);
		assertFalse(svgDocument.isDisposed());
	}

	@Test
	public void test_Constructor_InvalidVersion() {
		String filename = new File(tempDir, "test_invalid_version.svg").getAbsolutePath();
		assertThrows(IllegalArgumentException.class, () -> new SVGDocument(filename, 400, 300, 999));
	}

	@Test
	public void test_ConstructorWithDevice() {
		String filename = new File(tempDir, "test_device.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		assertNotNull(svgDocument);
		assertFalse(svgDocument.isDisposed());
	}

	@Test
	public void test_ConstructorWithDeviceAndVersion() {
		String filename = new File(tempDir, "test_device_version.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300, SVGDocument.SVG_VERSION_1_2);
		assertNotNull(svgDocument);
		assertFalse(svgDocument.isDisposed());
	}

	@Test
	public void test_getWidth() {
		String filename = new File(tempDir, "test_width.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		assertEquals(400.0, svgDocument.getWidth(), 0.001);
	}

	@Test
	public void test_getHeight() {
		String filename = new File(tempDir, "test_height.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		assertEquals(300.0, svgDocument.getHeight(), 0.001);
	}

	@Test
	public void test_isAutoScalable() {
		String filename = new File(tempDir, "test_autoscale.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		assertFalse(svgDocument.isAutoScalable());
	}

	@Test
	public void test_dispose() {
		String filename = new File(tempDir, "test_dispose.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		assertFalse(svgDocument.isDisposed());
		svgDocument.dispose();
		assertTrue(svgDocument.isDisposed());
	}

	@Test
	public void test_createGC() {
		String filename = new File(tempDir, "test_gc.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		GC gc = new GC(svgDocument);
		assertNotNull(gc);
		gc.dispose();
	}

	@Test
	public void test_drawOnGC() {
		String filename = new File(tempDir, "test_draw.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		GC gc = new GC(svgDocument);
		
		// Test drawing operations - should not throw exceptions
		gc.drawRectangle(10, 10, 100, 80);
		gc.drawText("Hello, SVG!", 50, 50);
		gc.drawLine(0, 0, 100, 100);
		gc.drawOval(150, 150, 50, 50);
		
		gc.dispose();
		svgDocument.dispose();
		
		// Verify file was created
		File file = new File(filename);
		assertTrue(file.exists(), "SVG file should have been created");
		assertTrue(file.length() > 0, "SVG file should not be empty");
	}

	@Test
	public void test_drawPolygon() {
		String filename = new File(tempDir, "test_polygon.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		GC gc = new GC(svgDocument);
		
		int[] points = {50, 50, 150, 50, 100, 150};
		gc.drawPolygon(points);
		gc.fillPolygon(points);
		
		gc.dispose();
		svgDocument.dispose();
		
		// Verify file was created
		File file = new File(filename);
		assertTrue(file.exists(), "SVG file should have been created");
	}

	@Test
	public void test_operationsAfterDispose() {
		String filename = new File(tempDir, "test_disposed.svg").getAbsolutePath();
		svgDocument = new SVGDocument(display, filename, 400, 300);
		svgDocument.dispose();
		
		assertThrows(Exception.class, () -> svgDocument.getWidth());
		assertThrows(Exception.class, () -> svgDocument.getHeight());
	}

	@Test
	public void test_svgVersionConstants() {
		// Verify SVG version constants are defined correctly
		assertEquals(0, SVGDocument.SVG_VERSION_1_1);
		assertEquals(1, SVGDocument.SVG_VERSION_1_2);
	}
}
