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

	/** PDF files use ISO-8859-1 (Latin-1) encoding for text content */
	private static final String PDF_ENCODING = "ISO-8859-1";

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

		// Find all stream objects and their starting positions in the byte array
		// We need to work with bytes directly to avoid encoding issues
		int pos = 0;
		while (pos < pdfBytes.length - 6) {
			// Look for "stream" keyword followed by newline
			if (pdfBytes[pos] == 's' && pdfBytes[pos+1] == 't' && pdfBytes[pos+2] == 'r' &&
				pdfBytes[pos+3] == 'e' && pdfBytes[pos+4] == 'a' && pdfBytes[pos+5] == 'm') {
				
				// Skip past "stream" and any CR/LF
				int streamStart = pos + 6;
				if (streamStart < pdfBytes.length && pdfBytes[streamStart] == '\r') {
					streamStart++;
				}
				if (streamStart < pdfBytes.length && pdfBytes[streamStart] == '\n') {
					streamStart++;
				}

				// Find the corresponding "endstream"
				int streamEnd = findEndStream(pdfBytes, streamStart);
				if (streamEnd > streamStart) {
					// Extract the stream data
					byte[] streamData = new byte[streamEnd - streamStart];
					System.arraycopy(pdfBytes, streamStart, streamData, 0, streamData.length);

					try {
						// Try to decompress the stream (most PDF streams are compressed)
						String decompressed = decompressFlate(streamData);
						allContent.append(decompressed).append(" ");
					} catch (DataFormatException e) {
						// If decompression fails, the stream might be uncompressed
						// Add the raw content
						String rawContent = new String(streamData, PDF_ENCODING);
						allContent.append(rawContent).append(" ");
					}
					
					pos = streamEnd;
				} else {
					pos++;
				}
			} else {
				pos++;
			}
		}

		return allContent.toString();
	}

	/**
	 * Finds the position of "endstream" keyword after a stream start.
	 *
	 * @param data the PDF byte array
	 * @param startPos the position to start searching from
	 * @return the position of the start of "endstream", or -1 if not found
	 */
	private int findEndStream(byte[] data, int startPos) {
		for (int i = startPos; i < data.length - 9; i++) {
			if (data[i] == 'e' && data[i+1] == 'n' && data[i+2] == 'd' &&
				data[i+3] == 's' && data[i+4] == 't' && data[i+5] == 'r' &&
				data[i+6] == 'e' && data[i+7] == 'a' && data[i+8] == 'm') {
				// Backtrack to remove any trailing CR/LF before endstream
				int endPos = i;
				if (endPos > 0 && data[endPos-1] == '\n') {
					endPos--;
				}
				if (endPos > 0 && data[endPos-1] == '\r') {
					endPos--;
				}
				return endPos;
			}
		}
		return -1;
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

		return outputStream.toString(PDF_ENCODING);
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
