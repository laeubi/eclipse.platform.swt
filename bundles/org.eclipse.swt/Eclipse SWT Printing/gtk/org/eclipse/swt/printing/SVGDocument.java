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
import org.eclipse.swt.internal.*;
import org.eclipse.swt.internal.cairo.*;

/**
 * Instances of this class are used to create SVG (Scalable Vector Graphics) documents.
 * Applications create a GC on an SVGDocument using <code>new GC(svgDocument)</code>
 * and then draw on the GC using the usual graphics calls.
 * <p>
 * An <code>SVGDocument</code> object may be constructed by providing
 * a filename and the image dimensions. After drawing is complete,
 * the document must be disposed to finalize the SVG file.
 * </p><p>
 * Application code must explicitly invoke the <code>SVGDocument.dispose()</code>
 * method to release the operating system resources managed by each instance
 * when those instances are no longer required.
 * </p>
 * <p>
 * The following example demonstrates how to use SVGDocument:
 * </p>
 * <pre>
 *    SVGDocument svg = new SVGDocument("output.svg", 400, 300);
 *    GC gc = new GC(svg);
 *    gc.drawRectangle(10, 10, 100, 80);
 *    gc.drawText("Hello, SVG!", 50, 50);
 *    gc.dispose();
 *    svg.dispose();
 * </pre>
 *
 * @see GC
 * @since 3.131
 */
public class SVGDocument implements Drawable {
	Device device;
	long surface;
	long cairo;
	boolean isGCCreated = false;
	boolean disposed = false;

	/**
	 * Width of the image in points (1/72 inch)
	 */
	double widthInPoints;

	/**
	 * Height of the image in points (1/72 inch)
	 */
	double heightInPoints;

	/**
	 * SVG version constant for SVG 1.1
	 */
	public static final int SVG_VERSION_1_1 = Cairo.CAIRO_SVG_VERSION_1_1;

	/**
	 * SVG version constant for SVG 1.2
	 */
	public static final int SVG_VERSION_1_2 = Cairo.CAIRO_SVG_VERSION_1_2;

	/**
	 * Constructs a new SVGDocument with the specified filename and dimensions.
	 * <p>
	 * You must dispose the SVGDocument when it is no longer required.
	 * </p>
	 *
	 * @param filename the path to the SVG file to create
	 * @param widthInPoints the width of the image in points (1/72 inch)
	 * @param heightInPoints the height of the image in points (1/72 inch)
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if filename is null</li>
	 *    <li>ERROR_INVALID_ARGUMENT - if width or height is not positive</li>
	 * </ul>
	 * @exception SWTError <ul>
	 *    <li>ERROR_NO_HANDLES - if the SVG surface could not be created</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public SVGDocument(String filename, double widthInPoints, double heightInPoints) {
		this(null, filename, widthInPoints, heightInPoints, SVG_VERSION_1_1);
	}

	/**
	 * Constructs a new SVGDocument with the specified filename, dimensions, and SVG version.
	 * <p>
	 * You must dispose the SVGDocument when it is no longer required.
	 * </p>
	 *
	 * @param filename the path to the SVG file to create
	 * @param widthInPoints the width of the image in points (1/72 inch)
	 * @param heightInPoints the height of the image in points (1/72 inch)
	 * @param svgVersion the SVG version to use (SVG_VERSION_1_1 or SVG_VERSION_1_2)
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if filename is null</li>
	 *    <li>ERROR_INVALID_ARGUMENT - if width or height is not positive</li>
	 *    <li>ERROR_INVALID_ARGUMENT - if svgVersion is not valid</li>
	 * </ul>
	 * @exception SWTError <ul>
	 *    <li>ERROR_NO_HANDLES - if the SVG surface could not be created</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public SVGDocument(String filename, double widthInPoints, double heightInPoints, int svgVersion) {
		this(null, filename, widthInPoints, heightInPoints, svgVersion);
	}

	/**
	 * Constructs a new SVGDocument with the specified filename and dimensions,
	 * associated with the given device.
	 * <p>
	 * You must dispose the SVGDocument when it is no longer required.
	 * </p>
	 *
	 * @param device the device to associate with this SVGDocument
	 * @param filename the path to the SVG file to create
	 * @param widthInPoints the width of the image in points (1/72 inch)
	 * @param heightInPoints the height of the image in points (1/72 inch)
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if filename is null</li>
	 *    <li>ERROR_INVALID_ARGUMENT - if width or height is not positive</li>
	 * </ul>
	 * @exception SWTError <ul>
	 *    <li>ERROR_NO_HANDLES - if the SVG surface could not be created</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public SVGDocument(Device device, String filename, double widthInPoints, double heightInPoints) {
		this(device, filename, widthInPoints, heightInPoints, SVG_VERSION_1_1);
	}

	/**
	 * Constructs a new SVGDocument with the specified filename, dimensions, and SVG version,
	 * associated with the given device.
	 * <p>
	 * You must dispose the SVGDocument when it is no longer required.
	 * </p>
	 *
	 * @param device the device to associate with this SVGDocument
	 * @param filename the path to the SVG file to create
	 * @param widthInPoints the width of the image in points (1/72 inch)
	 * @param heightInPoints the height of the image in points (1/72 inch)
	 * @param svgVersion the SVG version to use (SVG_VERSION_1_1 or SVG_VERSION_1_2)
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if filename is null</li>
	 *    <li>ERROR_INVALID_ARGUMENT - if width or height is not positive</li>
	 *    <li>ERROR_INVALID_ARGUMENT - if svgVersion is not valid</li>
	 * </ul>
	 * @exception SWTError <ul>
	 *    <li>ERROR_NO_HANDLES - if the SVG surface could not be created</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public SVGDocument(Device device, String filename, double widthInPoints, double heightInPoints, int svgVersion) {
		if (filename == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		if (widthInPoints <= 0 || heightInPoints <= 0) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		if (svgVersion != SVG_VERSION_1_1 && svgVersion != SVG_VERSION_1_2) SWT.error(SWT.ERROR_INVALID_ARGUMENT);

		this.device = device;
		this.widthInPoints = widthInPoints;
		this.heightInPoints = heightInPoints;

		byte[] filenameBytes = Converter.wcsToMbcs(filename, true);
		surface = Cairo.cairo_svg_surface_create(filenameBytes, widthInPoints, heightInPoints);
		if (surface == 0) SWT.error(SWT.ERROR_NO_HANDLES);

		Cairo.cairo_svg_surface_restrict_to_version(surface, svgVersion);

		cairo = Cairo.cairo_create(surface);
		if (cairo == 0) {
			Cairo.cairo_surface_destroy(surface);
			surface = 0;
			SWT.error(SWT.ERROR_NO_HANDLES);
		}

		// Get device from the current display if not provided
		if (this.device == null) {
			try {
				this.device = org.eclipse.swt.widgets.Display.getDefault();
			} catch (Exception e) {
				this.device = null;
			}
		}
	}

	/**
	 * Returns the width of the SVG document in points.
	 *
	 * @return the width in points (1/72 inch)
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	public double getWidth() {
		if (disposed) SWT.error(SWT.ERROR_WIDGET_DISPOSED);
		return widthInPoints;
	}

	/**
	 * Returns the height of the SVG document in points.
	 *
	 * @return the height in points (1/72 inch)
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 * </ul>
	 */
	public double getHeight() {
		if (disposed) SWT.error(SWT.ERROR_WIDGET_DISPOSED);
		return heightInPoints;
	}

	/**
	 * Invokes platform specific functionality to allocate a new GC handle.
	 * <p>
	 * <b>IMPORTANT:</b> This method is <em>not</em> part of the public
	 * API for <code>SVGDocument</code>. It is marked public only so that it
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
		if (disposed) SWT.error(SWT.ERROR_WIDGET_DISPOSED);
		if (isGCCreated) SWT.error(SWT.ERROR_INVALID_ARGUMENT);

		if (data != null) {
			int mask = SWT.LEFT_TO_RIGHT | SWT.RIGHT_TO_LEFT;
			if ((data.style & mask) == 0) {
				data.style |= SWT.LEFT_TO_RIGHT;
			}
			data.device = device;
			data.cairo = cairo;
			data.width = (int) widthInPoints;
			data.height = (int) heightInPoints;
			if (device != null) {
				data.foregroundRGBA = device.getSystemColor(SWT.COLOR_BLACK).handle;
				data.backgroundRGBA = device.getSystemColor(SWT.COLOR_WHITE).handle;
				data.font = device.getSystemFont();
			} else {
				// Fallback: create default colors manually using GdkRGBA values
				data.foregroundRGBA = new org.eclipse.swt.internal.gtk.GdkRGBA();
				data.foregroundRGBA.red = 0;
				data.foregroundRGBA.green = 0;
				data.foregroundRGBA.blue = 0;
				data.foregroundRGBA.alpha = 1;
				data.backgroundRGBA = new org.eclipse.swt.internal.gtk.GdkRGBA();
				data.backgroundRGBA.red = 1;
				data.backgroundRGBA.green = 1;
				data.backgroundRGBA.blue = 1;
				data.backgroundRGBA.alpha = 1;
			}
		}
		isGCCreated = true;
		return cairo;
	}

	/**
	 * Invokes platform specific functionality to dispose a GC handle.
	 * <p>
	 * <b>IMPORTANT:</b> This method is <em>not</em> part of the public
	 * API for <code>SVGDocument</code>. It is marked public only so that it
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
	 * Returns <code>true</code> if the SVGDocument has been disposed,
	 * and <code>false</code> otherwise.
	 *
	 * @return <code>true</code> when the SVGDocument is disposed and <code>false</code> otherwise
	 */
	public boolean isDisposed() {
		return disposed;
	}

	/**
	 * Disposes of the operating system resources associated with
	 * the SVGDocument. Applications must dispose of all SVGDocuments
	 * that they allocate.
	 * <p>
	 * This method finalizes the SVG file and writes it to disk.
	 * </p>
	 */
	public void dispose() {
		if (disposed) return;
		disposed = true;

		if (cairo != 0) {
			Cairo.cairo_destroy(cairo);
			cairo = 0;
		}
		if (surface != 0) {
			Cairo.cairo_surface_finish(surface);
			Cairo.cairo_surface_destroy(surface);
			surface = 0;
		}
	}
}
