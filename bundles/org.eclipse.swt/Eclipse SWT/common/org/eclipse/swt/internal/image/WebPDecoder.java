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
package org.eclipse.swt.internal.image;

import java.io.*;
import java.util.zip.*;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;

/**
 * WebP decoder implementation.
 * <p>
 * This class provides decoding capabilities for WebP images. It supports:
 * <ul>
 * <li>Simple lossy WebP (VP8)</li>
 * <li>Simple lossless WebP (VP8L)</li>
 * <li>Extended WebP (VP8X) with alpha channel</li>
 * </ul>
 * </p>
 * <p>
 * Note: This is a basic implementation that handles simple WebP files.
 * Complex features like animation, EXIF, XMP metadata are not yet supported.
 * </p>
 */
class WebPDecoder {
	
	private LEDataInputStream stream;
	
	// RIFF FourCC codes
	private static final byte[] RIFF = "RIFF".getBytes();
	private static final byte[] WEBP = "WEBP".getBytes();
	
	// WebP chunk types
	private static final byte[] VP8_ = "VP8 ".getBytes();
	private static final byte[] VP8L = "VP8L".getBytes();
	private static final byte[] VP8X = "VP8X".getBytes();
	private static final byte[] ALPH = "ALPH".getBytes();
	
	// WebP format constants
	private static final int VP8_KEY_FRAME_START_CODE = 0x9d012a;
	private static final int VP8L_SIGNATURE_BYTE = 0x2f;
	
	int width;
	int height;
	boolean hasAlpha;
	
	WebPDecoder(LEDataInputStream stream) {
		this.stream = stream;
	}
	
	/**
	 * Decode the WebP image from the input stream
	 */
	ImageData decode() throws IOException {
		// Read and verify RIFF header
		byte[] riffHeader = new byte[4];
		stream.read(riffHeader);
		if (!matches(riffHeader, RIFF)) {
			SWT.error(SWT.ERROR_INVALID_IMAGE);
		}
		
		// Read file size (little-endian)
		int fileSize = readInt32LE();
		
		// Read and verify WEBP signature
		byte[] webpSignature = new byte[4];
		stream.read(webpSignature);
		if (!matches(webpSignature, WEBP)) {
			SWT.error(SWT.ERROR_INVALID_IMAGE);
		}
		
		// Read chunks
		ImageData imageData = null;
		byte[] alphaData = null;
		
		while (true) {
			// Try to read chunk header
			byte[] chunkType = new byte[4];
			int read = stream.read(chunkType);
			if (read < 4) break; // End of file
			
			int chunkSize = readInt32LE();
			
			if (matches(chunkType, VP8X)) {
				// Extended format - read metadata
				decodeVP8X(chunkSize);
			} else if (matches(chunkType, ALPH)) {
				// Alpha channel
				alphaData = readAlphaChunk(chunkSize);
			} else if (matches(chunkType, VP8_)) {
				// VP8 lossy format
				imageData = decodeVP8Lossy(chunkSize);
			} else if (matches(chunkType, VP8L)) {
				// VP8L lossless format  
				imageData = decodeVP8Lossless(chunkSize);
			} else {
				// Skip unknown chunk
				skipBytes(chunkSize);
			}
			
			// Chunks are padded to even size
			if (chunkSize % 2 == 1) {
				stream.read();
			}
		}
		
		if (imageData == null) {
			SWT.error(SWT.ERROR_INVALID_IMAGE);
		}
		
		// Apply alpha channel if present
		if (alphaData != null && imageData != null) {
			imageData.alphaData = alphaData;
		}
		
		return imageData;
	}
	
	/**
	 * Decode VP8X (extended format) chunk to get image metadata
	 */
	private void decodeVP8X(int chunkSize) throws IOException {
		// VP8X flags (1 byte)
		int flags = stream.read();
		hasAlpha = (flags & 0x10) != 0;
		
		// Reserved (3 bytes)
		skipBytes(3);
		
		// Width and height (24-bit each, little-endian, +1)
		width = read24BitLE() + 1;
		height = read24BitLE() + 1;
	}
	
	/**
	 * Read ALPH chunk (alpha channel data)
	 */
	private byte[] readAlphaChunk(int chunkSize) throws IOException {
		// For now, skip alpha decoding - simplified implementation
		byte[] alphaChunk = new byte[chunkSize];
		stream.read(alphaChunk);
		return null; // TODO: Implement alpha decompression
	}
	
	/**
	 * Decode VP8 lossy format chunk
	 * <p>
	 * Note: This is a placeholder. A full VP8 decoder requires implementing
	 * the VP8 bitstream specification which is complex (~15,000 lines in libwebp).
	 * </p>
	 */
	private ImageData decodeVP8Lossy(int chunkSize) throws IOException {
		// Read VP8 frame tag (3 bytes)
		byte[] frameTag = new byte[3];
		stream.read(frameTag);
		
		// Check if this is a key frame
		if ((frameTag[0] & 0x01) != 0) {
			SWT.error(SWT.ERROR_INVALID_IMAGE); // Key frame expected
		}
		
		// Read start code (should be 0x9d012a)
		int startCode = ((frameTag[2] & 0xFF) << 16) | ((frameTag[1] & 0xFF) << 8) | (frameTag[0] & 0xFF);
		startCode = startCode >> 1;
		if (startCode != VP8_KEY_FRAME_START_CODE) {
			SWT.error(SWT.ERROR_INVALID_IMAGE);
		}
		
		// Read frame dimensions (14 bits width, 14 bits height)
		int w0 = stream.read();
		int w1 = stream.read();
		int h0 = stream.read();
		int h1 = stream.read();
		
		width = w0 | ((w1 & 0x3F) << 8);
		height = h0 | ((h1 & 0x3F) << 8);
		
		// For VP8 lossy, we need a full VP8 decoder which is very complex
		// TODO: Implement VP8 decoder or use a library
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED, null,
			" [VP8 lossy WebP decoding not yet implemented]");
		return null;
	}
	
	/**
	 * Decode VP8L lossless format chunk
	 * <p>
	 * Note: This is a placeholder. A full VP8L decoder requires implementing
	 * the VP8L bitstream specification which is complex.
	 * </p>
	 */
	private ImageData decodeVP8Lossless(int chunkSize) throws IOException {
		// Read VP8L signature
		int signature = stream.read();
		if (signature != VP8L_SIGNATURE_BYTE) {
			SWT.error(SWT.ERROR_INVALID_IMAGE);
		}
		
		// Read dimension bits (14 bits width - 1, 14 bits height - 1, 1 bit alpha, 3 bits version)
		byte[] dimBits = new byte[4];
		stream.read(dimBits);
		
		int bits = ((dimBits[0] & 0xFF)) |
		          ((dimBits[1] & 0xFF) << 8) |
		          ((dimBits[2] & 0xFF) << 16) |
		          ((dimBits[3] & 0xFF) << 24);
		
		width = (bits & 0x3FFF) + 1;
		height = ((bits >> 14) & 0x3FFF) + 1;
		hasAlpha = ((bits >> 28) & 0x1) == 1;
		int version = (bits >> 29) & 0x7;
		
		if (version != 0) {
			SWT.error(SWT.ERROR_INVALID_IMAGE);
		}
		
		// For VP8L lossless, we need to decode the compressed bitstream
		// TODO: Implement VP8L decoder or use a library
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED, null,
			" [VP8L lossless WebP decoding not yet implemented]");
		return null;
	}
	
	// Helper methods
	
	private boolean matches(byte[] a, byte[] b) {
		if (a.length != b.length) return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) return false;
		}
		return true;
	}
	
	private int readInt32LE() throws IOException {
		int b0 = stream.read();
		int b1 = stream.read();
		int b2 = stream.read();
		int b3 = stream.read();
		return b0 | (b1 << 8) | (b2 << 16) | (b3 << 24);
	}
	
	private int read24BitLE() throws IOException {
		int b0 = stream.read();
		int b1 = stream.read();
		int b2 = stream.read();
		return b0 | (b1 << 8) | (b2 << 16);
	}
	
	private void skipBytes(int count) throws IOException {
		// Use skip() for efficiency when available
		long remaining = count;
		while (remaining > 0) {
			long skipped = stream.skip(remaining);
			if (skipped <= 0) {
				// skip() not supported or reached EOF, fall back to read()
				if (stream.read() == -1) {
					break;
				}
				remaining--;
			} else {
				remaining -= skipped;
			}
		}
	}
}
