/*******************************************************************************
 * Copyright (c) 2025 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.tests.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.ImageLoader;
import org.junit.jupiter.api.Test;

/**
 * Automated tests for WebP image format support.
 */
public class Test_WebP_Format {

	/**
	 * Test that WebP format is properly detected
	 */
	@Test
	public void test_WebPFormatDetection() throws IOException {
		// Create a minimal valid WebP file header
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// RIFF header
		baos.write("RIFF".getBytes());
		// File size (little-endian, excluding first 8 bytes)
		baos.write(new byte[] {0x1e, 0x00, 0x00, 0x00}); // 30 bytes
		// WEBP signature
		baos.write("WEBP".getBytes());
		// VP8L chunk
		baos.write("VP8L".getBytes());
		// Chunk size
		baos.write(new byte[] {0x05, 0x00, 0x00, 0x00}); // 5 bytes
		// VP8L signature
		baos.write(0x2f);
		// Dimension bits (1x1 image, no alpha, version 0)
		baos.write(new byte[] {0x00, 0x00, 0x00, 0x00});
		
		byte[] webpData = baos.toByteArray();
		
		ImageLoader loader = new ImageLoader();
		
		// Try to load the WebP data
		// Currently, WebP decoding is not implemented, so we expect ERROR_NOT_IMPLEMENTED
		try (ByteArrayInputStream bais = new ByteArrayInputStream(webpData)) {
			SWTException exception = assertThrows(SWTException.class, () -> loader.load(bais),
					"Expected ERROR_NOT_IMPLEMENTED for WebP decoding");
			
			// Verify it's specifically a NOT_IMPLEMENTED error, not UNSUPPORTED_FORMAT
			// This proves the format was detected correctly
			assertEquals(SWT.ERROR_NOT_IMPLEMENTED, exception.code,
					"WebP format should be detected (NOT_IMPLEMENTED), not UNSUPPORTED_FORMAT");
		}
	}
	
	/**
	 * Test that invalid WebP files are rejected
	 */
	@Test
	public void test_InvalidWebPHeader() {
		ImageLoader loader = new ImageLoader();
		
		// Create an invalid WebP file (wrong WEBP signature)
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write("RIFF".getBytes(), 0, 4);
		baos.write(new byte[] {0x1e, 0x00, 0x00, 0x00}, 0, 4);
		baos.write("WEBX".getBytes(), 0, 4); // Wrong signature (should be WEBP)
		
		byte[] invalidData = baos.toByteArray();
		
		try (ByteArrayInputStream bais = new ByteArrayInputStream(invalidData)) {
			SWTException exception = assertThrows(SWTException.class, () -> loader.load(bais),
					"Expected exception for invalid WebP file");
			
			// Should be UNSUPPORTED_FORMAT since it's not recognized as WebP
			assertEquals(SWT.ERROR_UNSUPPORTED_FORMAT, exception.code,
					"Invalid WebP file should result in UNSUPPORTED_FORMAT error");
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}
	
	/**
	 * Test that WebP constant is defined
	 */
	@Test
	public void test_WebPConstantDefined() {
		// Verify that IMAGE_WEBP constant is defined and has the expected value
		// Using reflection to check if the constant exists since the test module
		// might be compiled against older SWT binaries
		try {
			java.lang.reflect.Field field = SWT.class.getDeclaredField("IMAGE_WEBP");
			int value = field.getInt(null);
			assertEquals(9, value, "IMAGE_WEBP should be defined as 9");
		} catch (NoSuchFieldException e) {
			fail("IMAGE_WEBP constant not found in SWT class");
		} catch (IllegalAccessException e) {
			fail("Cannot access IMAGE_WEBP constant: " + e.getMessage());
		}
	}
}
