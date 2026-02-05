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
package org.eclipse.swt.printing;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.internal.win32.*;

/**
 * Instances of this class are used to create PDF documents.
 * Applications create a GC on a PDFDocument using <code>new GC(pdfDocument)</code>
 * and then draw on the GC using the usual graphics calls.
 * <p>
 * A <code>PDFDocument</code> object may be constructed by providing
 * a filename and the page dimensions. After drawing is complete,
 * the document must be disposed to finalize the PDF file.
 * </p><p>
 * Application code must explicitly invoke the <code>PDFDocument.dispose()</code>
 * method to release the operating system resources managed by each instance
 * when those instances are no longer required.
 * </p>
 * <p>
 * <b>Note:</b> On Windows, this class uses the built-in "Microsoft Print to PDF"
 * printer which is available on Windows 10 and later.
 * </p>
 * <p>
 * The following example demonstrates how to use PDFDocument:
 * </p>
 * <pre>
 *    PDFDocument pdf = new PDFDocument("output.pdf", 612, 792); // Letter size in points
 *    GC gc = new GC(pdf);
 *    gc.drawText("Hello, PDF!", 100, 100);
 *    gc.dispose();
 *    pdf.dispose();
 * </pre>
 *
 * @see GC
 * @since 3.133
 */
public class PDFDocument extends Device {
	long handle;
	boolean isGCCreated = false;
	boolean jobStarted = false;
	boolean pageStarted = false;
	String filename;

	/**
	 * Width of the page in device-independent units
	 */
	double width;

	/**
	 * Height of the page in device-independent units
	 */
	double height;

	/**
	 * Width of the page in points (1/72 inch)
	 */
	double widthInPoints;

	/**
	 * Height of the page in points (1/72 inch)
	 */
	double heightInPoints;

	/** The name of the Microsoft Print to PDF printer */
	private static final String PDF_PRINTER_NAME = "Microsoft Print to PDF";
	
	/** Helper class to represent a paper size with orientation */
	private static class PaperSize {
		int paperSizeConstant;
		int orientation;
		double widthInInches;
		double heightInInches;
		
		PaperSize(int paperSize, int orientation, double width, double height) {
			this.paperSizeConstant = paperSize;
			this.orientation = orientation;
			this.widthInInches = width;
			this.heightInInches = height;
		}
	}

	/**
	 * Finds the best matching standard paper size for the given dimensions.
	 * Tries both portrait and landscape orientations and selects the one that
	 * minimizes wasted space while ensuring the content fits.
	 */
	private static PaperSize findBestPaperSize(double widthInInches, double heightInInches) {
		// Common paper sizes (width x height in inches, portrait orientation)
		int[][] standardSizes = {
			{OS.DMPAPER_LETTER, 850, 1100},      // 8.5 x 11
			{OS.DMPAPER_LEGAL, 850, 1400},       // 8.5 x 14
			{OS.DMPAPER_A4, 827, 1169},          // 8.27 x 11.69
			{OS.DMPAPER_TABLOID, 1100, 1700},    // 11 x 17
			{OS.DMPAPER_A3, 1169, 1654},         // 11.69 x 16.54
			{OS.DMPAPER_EXECUTIVE, 725, 1050},   // 7.25 x 10.5
			{OS.DMPAPER_A5, 583, 827},           // 5.83 x 8.27
		};
		
		PaperSize bestMatch = null;
		double minWaste = Double.MAX_VALUE;
		
		for (int[] size : standardSizes) {
			double paperWidth = size[1] / 100.0;
			double paperHeight = size[2] / 100.0;
			
			// Try portrait orientation
			if (widthInInches <= paperWidth && heightInInches <= paperHeight) {
				double waste = (paperWidth * paperHeight) - (widthInInches * heightInInches);
				if (waste < minWaste) {
					minWaste = waste;
					bestMatch = new PaperSize(size[0], OS.DMORIENT_PORTRAIT, paperWidth, paperHeight);
				}
			}
			
			// Try landscape orientation (swap width and height)
			if (widthInInches <= paperHeight && heightInInches <= paperWidth) {
				double waste = (paperHeight * paperWidth) - (widthInInches * heightInInches);
				if (waste < minWaste) {
					minWaste = waste;
					bestMatch = new PaperSize(size[0], OS.DMORIENT_LANDSCAPE, paperHeight, paperWidth);
				}
			}
		}
		
		// Default to Letter if no match found
		if (bestMatch == null) {
			bestMatch = new PaperSize(OS.DMPAPER_LETTER, OS.DMORIENT_PORTRAIT, 8.5, 11.0);
		}
		
		return bestMatch;
	}

	/**
	 * Constructs a new PDFDocument with the specified filename and page dimensions.
	 * <p>
	 * You must dispose the PDFDocument when it is no longer required.
	 * </p>
	 *
	 * @param filename the path to the PDF file to create
	 * @param width the width of each page in device-independent units
	 * @param height the height of each page in device-independent units
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if filename is null</li>
	 *    <li>ERROR_INVALID_ARGUMENT - if width or height is not positive</li>
	 * </ul>
	 * @exception SWTError <ul>
	 *    <li>ERROR_NO_HANDLES - if the PDF printer is not available</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public PDFDocument(String filename, double width, double height) {
		this(checkData(filename, width, height));
		this.filename = filename;
		this.width = width;
		this.height = height;
	}

	/**
	 * Internal constructor that passes a DeviceData to Device superclass.
	 */
	PDFDocument(DeviceData data) {
		super(data);
	}

	/**
	 * Validates and prepares the data for construction.
	 */
	static DeviceData checkData(String filename, double width, double height) {
		if (filename == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		if (width <= 0 || height <= 0) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		DeviceData data = new DeviceData();
		return data;
	}

	/**
	 * Creates the PDF device in the operating system.
	 * This method is called before <code>init</code>.
	 *
	 * @param data the DeviceData which describes the receiver
	 */
	@Override
	protected void create(DeviceData data) {
		// Calculate physical size in inches from screen pixels
		int screenDpiX = 96;
		int screenDpiY = 96;
		
		double widthInInches = width / screenDpiX;
		double heightInInches = height / screenDpiY;
		
		// Microsoft Print to PDF doesn't support custom page sizes
		// Find the best matching standard paper size
		PaperSize bestMatch = findBestPaperSize(widthInInches, heightInInches);
		this.widthInPoints = bestMatch.widthInInches * 72.0;
		this.heightInPoints = bestMatch.heightInInches * 72.0;

		// Create printer DC for "Microsoft Print to PDF"
		TCHAR driver = new TCHAR(0, "WINSPOOL", true);
		TCHAR deviceName = new TCHAR(0, PDF_PRINTER_NAME, true);

		// Get printer settings
		long[] hPrinter = new long[1];
		if (OS.OpenPrinter(deviceName, hPrinter, 0)) {
			int dwNeeded = OS.DocumentProperties(0, hPrinter[0], deviceName, 0, 0, 0);
			if (dwNeeded >= 0) {
				long hHeap = OS.GetProcessHeap();
				long lpInitData = OS.HeapAlloc(hHeap, OS.HEAP_ZERO_MEMORY, dwNeeded);
				if (lpInitData != 0) {
					int rc = OS.DocumentProperties(0, hPrinter[0], deviceName, lpInitData, 0, OS.DM_OUT_BUFFER);
					if (rc == OS.IDOK) {
						DEVMODE devmode = new DEVMODE();
						OS.MoveMemory(devmode, lpInitData, DEVMODE.sizeof);
						devmode.dmPaperSize = (short) bestMatch.paperSizeConstant;
						devmode.dmOrientation = (short) bestMatch.orientation;
						devmode.dmFields = OS.DM_PAPERSIZE | OS.DM_ORIENTATION;
						OS.MoveMemory(lpInitData, devmode, DEVMODE.sizeof);
						handle = OS.CreateDC(driver, deviceName, 0, lpInitData);
					}
					OS.HeapFree(hHeap, 0, lpInitData);
				}
			}
			OS.ClosePrinter(hPrinter[0]);
		}

		if (handle == 0) {
			SWT.error(SWT.ERROR_NO_HANDLES);
		}
	}

	/**
	 * Initializes any internal resources needed by the device.
	 * This method is called after <code>create</code>.
	 */
	@Override
	protected void init() {
		super.init();
	}

	/**
	 * Ensures the print job has been started
	 */
	private void ensureJobStarted() {
		if (!jobStarted) {
			DOCINFO di = new DOCINFO();
			di.cbSize = DOCINFO.sizeof;
			long hHeap = OS.GetProcessHeap();

			// Set output filename
			TCHAR buffer = new TCHAR(0, filename, true);
			int byteCount = buffer.length() * TCHAR.sizeof;
			long lpszOutput = OS.HeapAlloc(hHeap, OS.HEAP_ZERO_MEMORY, byteCount);
			OS.MoveMemory(lpszOutput, buffer, byteCount);
			di.lpszOutput = lpszOutput;

			// Set document name
			TCHAR docName = new TCHAR(0, "SWT PDF Document", true);
			int docByteCount = docName.length() * TCHAR.sizeof;
			long lpszDocName = OS.HeapAlloc(hHeap, OS.HEAP_ZERO_MEMORY, docByteCount);
			OS.MoveMemory(lpszDocName, docName, docByteCount);
			di.lpszDocName = lpszDocName;

			int rc = OS.StartDoc(handle, di);

			OS.HeapFree(hHeap, 0, lpszOutput);
			OS.HeapFree(hHeap, 0, lpszDocName);

			if (rc <= 0) {
				SWT.error(SWT.ERROR_NO_HANDLES);
			}
			jobStarted = true;
		}
	}

	/**
	 * Ensures the current page has been started
	 */
	private void ensurePageStarted() {
		ensureJobStarted();
		if (!pageStarted) {
			OS.StartPage(handle);
			pageStarted = true;
		}
	}

	/**
	 * Starts a new page in the PDF document.
	 * <p>
	 * This method should be called after completing the content of one page
	 * and before starting to draw on the next page. The new page will have
	 * the same dimensions as the initial page.
	 * </p>
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_DEVICE_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	public void newPage() {
		checkDevice();
		if (pageStarted) {
			OS.EndPage(handle);
			pageStarted = false;
		}
		ensurePageStarted();
	}

	/**
	 * Starts a new page in the PDF document with the specified dimensions.
	 * <p>
	 * This method should be called after completing the content of one page
	 * and before starting to draw on the next page.
	 * </p>
	 * <p>
	 * <b>Note:</b> On Windows, changing page dimensions after the document
	 * has been started may not be fully supported by all printer drivers.
	 * </p>
	 *
	 * @param widthInPoints the width of the new page in points (1/72 inch)
	 * @param heightInPoints the height of the new page in points (1/72 inch)
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_INVALID_ARGUMENT - if width or height is not positive</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_DEVICE_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	public void newPage(double widthInPoints, double heightInPoints) {
		checkDevice();
		if (widthInPoints <= 0 || heightInPoints <= 0) SWT.error(SWT.ERROR_INVALID_ARGUMENT);

		this.widthInPoints = widthInPoints;
		this.heightInPoints = heightInPoints;
		newPage();
	}

	/**
	 * Returns the width of the current page in points.
	 *
	 * @return the width in points (1/72 inch)
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_DEVICE_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	public double getWidth() {
		checkDevice();
		return widthInPoints;
	}

	/**
	 * Returns the height of the current page in points.
	 *
	 * @return the height in points (1/72 inch)
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_DEVICE_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	public double getHeight() {
		checkDevice();
		return heightInPoints;
	}

	/**
	 * Returns the DPI (dots per inch) of the PDF document.
	 * This returns the actual DPI of the underlying PDF printer device.
	 *
	 * @return a point whose x coordinate is the horizontal DPI and whose y coordinate is the vertical DPI
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_DEVICE_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	@Override
	public Point getDPI() {
		checkDevice();
		int dpiX = OS.GetDeviceCaps(handle, OS.LOGPIXELSX);
		int dpiY = OS.GetDeviceCaps(handle, OS.LOGPIXELSY);
		return new Point(dpiX, dpiY);
	}

	/**
	 * Returns a rectangle describing the receiver's size and location.
	 * The rectangle dimensions are in points (1/72 inch).
	 *
	 * @return the bounding rectangle
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_DEVICE_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	@Override
	public Rectangle getBounds() {
		checkDevice();
		return new Rectangle(0, 0, (int) widthInPoints, (int) heightInPoints);
	}

	/**
	 * Returns a rectangle which describes the area of the
	 * receiver which is capable of displaying data.
	 * For a PDF document, this is the same as the bounds.
	 *
	 * @return the client area
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_DEVICE_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	@Override
	public Rectangle getClientArea() {
		return getBounds();
	}

	/**
	 * Invokes platform specific functionality to allocate a new GC handle.
	 * <p>
	 * <b>IMPORTANT:</b> This method is <em>not</em> part of the public
	 * API for <code>PDFDocument</code>. It is marked public only so that it
	 * can be shared within the packages provided by SWT. It is not
	 * available on all platforms, and should never be called from
	 * application code.
	 * </p>
	 *
	 * @param data the platform specific GC data
	 * @return the platform specific GC handle
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public long internal_new_GC(GCData data) {
		checkDevice();
		if (isGCCreated) SWT.error(SWT.ERROR_INVALID_ARGUMENT);

		ensurePageStarted();

		if (data != null) {
			int mask = SWT.LEFT_TO_RIGHT | SWT.RIGHT_TO_LEFT;
			if ((data.style & mask) != 0) {
				data.layout = (data.style & SWT.RIGHT_TO_LEFT) != 0 ? OS.LAYOUT_RTL : 0;
			} else {
				data.style |= SWT.LEFT_TO_RIGHT;
			}
			data.device = this;
			data.nativeZoom = 100;
			data.font = getSystemFont();
		}
		
		// Set up coordinate system scaling
		// Get screen DPI (use 96 as default)
		int screenDpiX = 96;
		int screenDpiY = 96;
		
		// Get PDF printer DPI
		int pdfDpiX = OS.GetDeviceCaps(handle, OS.LOGPIXELSX);
		int pdfDpiY = OS.GetDeviceCaps(handle, OS.LOGPIXELSY);
		
		// Calculate content size in inches (what user wanted)
		double contentWidthInInches = width / screenDpiX;
		double contentHeightInInches = height / screenDpiY;
		
		// Calculate scale factor to fit content to page
		// The page size is the physical paper size we selected
		double pageWidthInInches = widthInPoints / 72.0;
		double pageHeightInInches = heightInPoints / 72.0;
		double scaleToFitWidth = pageWidthInInches / contentWidthInInches;
		double scaleToFitHeight = pageHeightInInches / contentHeightInInches;
		
		// Use the smaller scale to ensure both width and height fit
		double scaleToFit = Math.min(scaleToFitWidth, scaleToFitHeight);
		
		// Combined scale: fit-to-page * DPI conversion
		float scaleX = (float)(scaleToFit * pdfDpiX / screenDpiX);
		float scaleY = (float)(scaleToFit * pdfDpiY / screenDpiY);
		
		OS.SetGraphicsMode(handle, OS.GM_ADVANCED);
		float[] transform = new float[] {scaleX, 0, 0, scaleY, 0, 0};
		OS.SetWorldTransform(handle, transform);
		
		isGCCreated = true;
		return handle;
	}

	/**
	 * Invokes platform specific functionality to dispose a GC handle.
	 * <p>
	 * <b>IMPORTANT:</b> This method is <em>not</em> part of the public
	 * API for <code>PDFDocument</code>. It is marked public only so that it
	 * can be shared within the packages provided by SWT. It is not
	 * available on all platforms, and should never be called from
	 * application code.
	 * </p>
	 *
	 * @param hDC the platform specific GC handle
	 * @param data the platform specific GC data
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public void internal_dispose_GC(long hDC, GCData data) {
		if (data != null) isGCCreated = false;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public boolean isAutoScalable() {
		return false;
	}

	/**
	 * Destroys the PDF document handle.
	 * This method is called internally by the dispose
	 * mechanism of the <code>Device</code> class.
	 */
	@Override
	protected void destroy() {
		if (handle != 0) {
			if (pageStarted) {
				OS.EndPage(handle);
			}
			if (jobStarted) {
				OS.EndDoc(handle);
			}
			OS.DeleteDC(handle);
			handle = 0;
		}
	}
}
