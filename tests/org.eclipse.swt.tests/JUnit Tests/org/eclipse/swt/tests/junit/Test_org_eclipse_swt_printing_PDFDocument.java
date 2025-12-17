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
package org.eclipse.swt.tests.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.printing.PDFDocument;
import org.eclipse.swt.widgets.Display;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Automated Test Suite for class org.eclipse.swt.printing.PDFDocument
 *
 * @see org.eclipse.swt.printing.PDFDocument
 */
public class Test_org_eclipse_swt_printing_PDFDocument {

	Display display;
	PDFDocument pdfDocument;
	GC gc;
	File tempFile;

	@TempDir
	Path tempDir;

	@BeforeEach
	public void setUp() {
		display = Display.getDefault();
	}

	/**
	 * Extracts and decodes text content from a PDF file.
	 * PDF content streams are often compressed using Flate (zlib) compression.
	 * This method finds all content streams in the PDF and decompresses them.
	 *
	 * @param pdfBytes the raw PDF file bytes
	 * @return a string containing all decompressed content from the PDF
	 */
	private String extractPDFContent(byte[] pdfBytes) throws IOException, DataFormatException {
		StringBuilder allContent = new StringBuilder();
		String pdfString = new String(pdfBytes, "ISO-8859-1");

		// Pattern to find stream objects with FlateDecode filter
		// PDF structure: ... /Filter /FlateDecode ... stream\n<data>\nendstream
		Pattern streamPattern = Pattern.compile(
			"stream\\r?\\n(.*?)\\r?\\nendstream",
			Pattern.DOTALL
		);

		Matcher matcher = streamPattern.matcher(pdfString);
		while (matcher.find()) {
			int streamStart = matcher.start(1);
			int streamEnd = matcher.end(1);

			// Extract the compressed data
			byte[] compressedData = new byte[streamEnd - streamStart];
			System.arraycopy(pdfBytes, streamStart, compressedData, 0, compressedData.length);

			try {
				// Try to decompress the stream
				String decompressed = decompressFlate(compressedData);
				allContent.append(decompressed).append(" ");
			} catch (DataFormatException e) {
				// Some streams might not be compressed or use different compression
				// Try adding the raw content as well
				String rawContent = new String(compressedData, "ISO-8859-1");
				allContent.append(rawContent).append(" ");
			}
		}

		// Also check for uncompressed text in the PDF (less common but possible)
		allContent.append(pdfString);

		return allContent.toString();
	}

	/**
	 * Decompresses data using Flate (zlib) decompression.
	 *
	 * @param compressedData the compressed byte array
	 * @return the decompressed string
	 */
	private String decompressFlate(byte[] compressedData) throws DataFormatException, IOException {
		Inflater inflater = new Inflater();
		inflater.setInput(compressedData);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressedData.length);
		byte[] buffer = new byte[1024];

		while (!inflater.finished()) {
			int count = inflater.inflate(buffer);
			outputStream.write(buffer, 0, count);
		}

		outputStream.close();
		inflater.end();

		return outputStream.toString("ISO-8859-1");
	}

	@AfterEach
	public void tearDown() {
		if (gc != null && !gc.isDisposed()) {
			gc.dispose();
		}
		if (pdfDocument != null && !pdfDocument.isDisposed()) {
			pdfDocument.dispose();
		}
		if (tempFile != null && tempFile.exists()) {
			tempFile.delete();
		}
	}

	@Test
	public void test_createPDFDocumentWithHelloWorld() throws IOException, DataFormatException {
		// Create a temporary file for the PDF
		tempFile = Files.createTempFile(tempDir, "test", ".pdf").toFile();
		String filename = tempFile.getAbsolutePath();

		// Create PDF document with standard letter size (612 x 792 points)
		pdfDocument = new PDFDocument(filename, 612, 792);
		assertNotNull(pdfDocument, "PDFDocument should be created");

		// Create a GC on the PDF document
		gc = new GC(pdfDocument);
		assertNotNull(gc, "GC should be created on PDFDocument");

		// Draw "hello world" text
		gc.drawText("hello world", 100, 100);

		// Dispose of resources to finalize the PDF
		gc.dispose();
		gc = null;
		pdfDocument.dispose();
		pdfDocument = null;

		// Verify the PDF file was created and is not empty
		assertTrue(tempFile.exists(), "PDF file should exist");
		assertTrue(tempFile.length() > 0, "PDF file should not be empty");

		// Verify PDF magic bytes and content
		byte[] fileContent = Files.readAllBytes(tempFile.toPath());
		assertTrue(fileContent.length >= 5, "PDF file should have at least 5 bytes for header");

		// Check for PDF magic bytes: %PDF-
		String headerString = new String(fileContent, 0, Math.min(5, fileContent.length));
		assertTrue(headerString.startsWith("%PDF-"), 
			"PDF file should start with %PDF- magic bytes, but got: " + headerString);

		// Check if "hello world" appears in the PDF content
		// PDF content streams are often compressed, so we need to decompress them
		String content = extractPDFContent(fileContent);
		assertTrue(content.contains("hello world"), 
			"PDF content should contain 'hello world' text");
	}

	@Test
	public void test_createPDFDocumentMultiplePages() throws IOException, DataFormatException {
		// Create a temporary file for the PDF
		tempFile = Files.createTempFile(tempDir, "test_multipage", ".pdf").toFile();
		String filename = tempFile.getAbsolutePath();

		// Create PDF document
		pdfDocument = new PDFDocument(filename, 612, 792);
		gc = new GC(pdfDocument);

		// Draw on first page
		gc.drawText("Page 1", 100, 100);

		// Create a new page
		pdfDocument.newPage();

		// Draw on second page
		gc.drawText("Page 2", 100, 100);

		// Dispose resources
		gc.dispose();
		gc = null;
		pdfDocument.dispose();
		pdfDocument = null;

		// Verify the PDF file was created
		assertTrue(tempFile.exists(), "PDF file should exist");
		assertTrue(tempFile.length() > 0, "PDF file should not be empty");

		// Verify PDF magic bytes and content
		byte[] fileContent = Files.readAllBytes(tempFile.toPath());
		assertTrue(fileContent.length >= 5, "PDF file should have at least 5 bytes for header");
		String headerString = new String(fileContent, 0, Math.min(5, fileContent.length));
		assertTrue(headerString.startsWith("%PDF-"), 
			"PDF file should start with %PDF- magic bytes");

		// Verify both page texts are present in the PDF
		// PDF content streams are often compressed, so we need to decompress them
		String content = extractPDFContent(fileContent);
		assertTrue(content.contains("Page 1"), 
			"PDF content should contain 'Page 1' text");
		assertTrue(content.contains("Page 2"), 
			"PDF content should contain 'Page 2' text");
	}
}
