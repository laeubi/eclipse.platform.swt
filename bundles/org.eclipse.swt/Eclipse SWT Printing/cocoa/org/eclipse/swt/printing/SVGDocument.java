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

/**
 * Instances of this class are used to create SVG (Scalable Vector Graphics) documents.
 * <p>
 * <b>Note:</b> On macOS, SVG output is not natively supported by the operating system.
 * This class is provided for API compatibility with other platforms. On macOS,
 * using this class will result in an {@link SWTException} with error code
 * {@link SWT#ERROR_NOT_IMPLEMENTED}.
 * </p>
 * <p>
 * For SVG support on macOS, consider using third-party libraries or converting
 * from PDF output, which is natively supported via {@link PDFDocument}.
 * </p>
 *
 * @see GC
 * @see PDFDocument
 * @since 3.131
 */
public class SVGDocument implements Drawable {

	/**
	 * SVG version constant for SVG 1.1
	 */
	public static final int SVG_VERSION_1_1 = 0;

	/**
	 * SVG version constant for SVG 1.2
	 */
	public static final int SVG_VERSION_1_2 = 1;

	/**
	 * Constructs a new SVGDocument with the specified filename and dimensions.
	 * <p>
	 * <b>Note:</b> SVG output is not supported on macOS. This constructor
	 * will throw an {@link SWTException} with error code {@link SWT#ERROR_NOT_IMPLEMENTED}.
	 * </p>
	 *
	 * @param filename the path to the SVG file to create
	 * @param widthInPoints the width of the image in points (1/72 inch)
	 * @param heightInPoints the height of the image in points (1/72 inch)
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_NOT_IMPLEMENTED - SVG output is not supported on macOS</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public SVGDocument(String filename, double widthInPoints, double heightInPoints) {
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED);
	}

	/**
	 * Constructs a new SVGDocument with the specified filename, dimensions, and SVG version.
	 * <p>
	 * <b>Note:</b> SVG output is not supported on macOS. This constructor
	 * will throw an {@link SWTException} with error code {@link SWT#ERROR_NOT_IMPLEMENTED}.
	 * </p>
	 *
	 * @param filename the path to the SVG file to create
	 * @param widthInPoints the width of the image in points (1/72 inch)
	 * @param heightInPoints the height of the image in points (1/72 inch)
	 * @param svgVersion the SVG version to use (SVG_VERSION_1_1 or SVG_VERSION_1_2)
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_NOT_IMPLEMENTED - SVG output is not supported on macOS</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public SVGDocument(String filename, double widthInPoints, double heightInPoints, int svgVersion) {
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED);
	}

	/**
	 * Constructs a new SVGDocument with the specified filename and dimensions,
	 * associated with the given device.
	 * <p>
	 * <b>Note:</b> SVG output is not supported on macOS. This constructor
	 * will throw an {@link SWTException} with error code {@link SWT#ERROR_NOT_IMPLEMENTED}.
	 * </p>
	 *
	 * @param device the device to associate with this SVGDocument
	 * @param filename the path to the SVG file to create
	 * @param widthInPoints the width of the image in points (1/72 inch)
	 * @param heightInPoints the height of the image in points (1/72 inch)
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_NOT_IMPLEMENTED - SVG output is not supported on macOS</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public SVGDocument(Device device, String filename, double widthInPoints, double heightInPoints) {
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED);
	}

	/**
	 * Constructs a new SVGDocument with the specified filename, dimensions, and SVG version,
	 * associated with the given device.
	 * <p>
	 * <b>Note:</b> SVG output is not supported on macOS. This constructor
	 * will throw an {@link SWTException} with error code {@link SWT#ERROR_NOT_IMPLEMENTED}.
	 * </p>
	 *
	 * @param device the device to associate with this SVGDocument
	 * @param filename the path to the SVG file to create
	 * @param widthInPoints the width of the image in points (1/72 inch)
	 * @param heightInPoints the height of the image in points (1/72 inch)
	 * @param svgVersion the SVG version to use (SVG_VERSION_1_1 or SVG_VERSION_1_2)
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_NOT_IMPLEMENTED - SVG output is not supported on macOS</li>
	 * </ul>
	 *
	 * @see #dispose()
	 */
	public SVGDocument(Device device, String filename, double widthInPoints, double heightInPoints, int svgVersion) {
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED);
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
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED);
		return 0;
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
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED);
		return 0;
	}

	/**
	 * Invokes platform specific functionality to allocate a new GC handle.
	 *
	 * @param data the platform specific GC data
	 * @return the platform specific GC handle
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public long internal_new_GC(GCData data) {
		SWT.error(SWT.ERROR_NOT_IMPLEMENTED);
		return 0;
	}

	/**
	 * Invokes platform specific functionality to dispose a GC handle.
	 *
	 * @param hDC the platform specific GC handle
	 * @param data the platform specific GC data
	 *
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public void internal_dispose_GC(long hDC, GCData data) {
		// Nothing to do
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
	 * <p>
	 * Note: Since SVG output is not supported on macOS, this always returns false
	 * as the object cannot be instantiated.
	 * </p>
	 *
	 * @return <code>true</code> when the SVGDocument is disposed and <code>false</code> otherwise
	 */
	public boolean isDisposed() {
		return false;
	}

	/**
	 * Disposes of the operating system resources associated with
	 * the SVGDocument.
	 */
	public void dispose() {
		// Nothing to dispose
	}
}
