/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;
 
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
 
public class TreeColumn extends Item {
	Tree2 parent;
	int index;
	int x, width;
	boolean resizable = true;
	int textWidth;
	
public TreeColumn (Tree2 parent, int style) {
	this (parent, style, checkNull (parent).getColumnCount ());
}
public TreeColumn(Tree2 parent, int style, int index) {
	super (parent, checkStyle (style), index);
	if (!(0 <= index && index <= parent.getColumnCount ())) error(SWT.ERROR_INVALID_RANGE);
	this.parent = parent;
	this.index = index;	
	parent.addColumn (this);
}
public void addControlListener(ControlListener listener) {
	checkWidget();
	if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
	TypedListener typedListener = new TypedListener (listener);
	addListener (SWT.Resize,typedListener);
	addListener (SWT.Move,typedListener);
}
public void addSelectionListener (SelectionListener listener) {
	checkWidget();
	if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
	TypedListener typedListener = new TypedListener (listener);
	addListener (SWT.Selection,typedListener);
	addListener (SWT.DefaultSelection,typedListener);
}
static Tree2 checkNull (Tree2 tree) {
	if (tree == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
	return tree;
}
static int checkStyle (int style) {
	return checkBits (style, SWT.LEFT, SWT.CENTER, SWT.RIGHT, 0, 0, 0);
}
protected void checkSubclass () {
	if (!isValidSubclass ()) error (SWT.ERROR_INVALID_SUBCLASS);
}
public void dispose() {
	if (isDisposed()) return;
	dispose(true);
	Rectangle bounds = parent.getClientArea();
	parent.redraw(x, 0, bounds.width - x, bounds.height, true);
}
void dispose(boolean notifyParent) {
	super.dispose();	/* the use of super is intentional here */
	if (notifyParent) parent.removeColumn(this);
	parent = null;
}
public int getAlignment () {
	checkWidget();
	if ((style & SWT.CENTER) != 0) return SWT.CENTER;
	if ((style & SWT.RIGHT) != 0) return SWT.RIGHT;
	return SWT.LEFT;
}
Rectangle getBounds() {
	return new Rectangle(x, 0, width, parent.getClientArea().height);
}
int getIndex() {
	return index;
}
public Tree2 getParent() {
	checkWidget();
	return parent;
}
public boolean getResizable() {
	checkWidget();
	return resizable;
}
/*
 * Returns the rightmost point that belongs to the receiver.
 */
int getRightmostX() {
	return x + width;
}
public int getWidth () {
	checkWidget();
	return width;
}
int getX() {
	return x;
}
void internalSetWidth(int value) {
	width = value;
}
void paint(GC gc) {
	int padding = parent.getHeaderPadding();
	
	int startX;
	if ((style & SWT.LEFT) != 0) {
		startX = x + padding;
	} else {
		int contentWidth = textWidth;
		if (image != null) {
			contentWidth += image.getBounds().width + Tree2.MARGIN_IMAGE;
		}
		if ((style & SWT.RIGHT) != 0) {
			startX = x + width - padding - contentWidth;	
		} else {	/* SWT.CENTER */
			startX = x + (width - contentWidth) / 2;	
		}
	}
	startX = Math.max (startX, padding);
	int headerHeight = parent.getHeaderHeight();

	/* while painting the header's contents restrict the clipping region */
	Rectangle oldClipping = gc.getClipping();
	gc.setClipping(
		x + padding,
		padding,
		Math.max (0, width - 2 * padding),
		Math.max (0, headerHeight - 2 * padding));
	
	if (image != null) {
		Rectangle imageBounds = image.getBounds();
		int drawHeight = Math.min (imageBounds.height, headerHeight - 2 * padding);
		gc.drawImage(
			image,
			0, 0,
			imageBounds.width, imageBounds.height,
			startX, (headerHeight - drawHeight) / 2,
			imageBounds.width, drawHeight); 
		startX += imageBounds.width + Tree2.MARGIN_IMAGE; 
	}
	if (text.length() > 0) {
		int fontHeight = parent.getFontHeight();
		gc.drawText(text, startX, (headerHeight - fontHeight) / 2);
	}
	
	/* restore the original clipping */
	gc.setClipping(oldClipping);
}
public void removeControlListener (ControlListener listener) {
	checkWidget();
	if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
	if (eventTable == null) return;
	eventTable.unhook (SWT.Move, listener);
	eventTable.unhook (SWT.Resize, listener);
}
public void removeSelectionListener(SelectionListener listener) {
	checkWidget();
	if (listener == null) error(SWT.ERROR_NULL_ARGUMENT);
	removeListener(SWT.Selection, listener);
	removeListener(SWT.DefaultSelection, listener);
}
public void setAlignment (int alignment) {
	checkWidget();
	if ((style & alignment) != 0) return;				/* same value */
	style &= ~(SWT.LEFT | SWT.CENTER | SWT.RIGHT);
	style |= alignment;
	parent.redraw(x, 0, width, parent.getClientArea().height, true);
}
public void setImage (Image value) {
	checkWidget();
	if (value == image) return;
	if (value != null && value.equals(image)) return;	/* same value */
	super.setImage (value);
	
	/*
	 * If this is the first image being put into the header then the header
	 * height may be adjusted, in which case a full redraw is needed.
	 */
	if (parent.getHeaderImageHeight() == 0) {
		int oldHeaderHeight = parent.getHeaderHeight();
		parent.setHeaderImageHeight(value.getBounds().height);
		if (oldHeaderHeight != parent.getHeaderHeight()) {
			parent.redrawHeader();
			parent.redraw();
			return;
		}
	}
	
	parent.redraw(x, 0, width, parent.getHeaderHeight(), true);
}
void setIndex(int value) {
	index = value;
}
public void setResizable (boolean value) {
	checkWidget();
	resizable = value;
}
public void setText (String value) {
	checkWidget();
	if (value == null) error(SWT.ERROR_NULL_ARGUMENT);
	if (value.equals(text)) return;						/* same value */
	super.setText (value);
	GC gc = new GC (parent);
	textWidth = gc.textExtent(value).x;
	gc.dispose();
	parent.redraw(x, 0, width, parent.getHeaderHeight(), true);
}
public void setWidth (int value) {
	checkWidget();
	if (width == value) return;							/* same value */
	parent.updateColumnWidth (this, value);
}
void setX(int value) {
	x = value;
}
/*
 * The parent's font has changed, so recompute the receiver's cached text size.
 */
void treeFontChange () {
	String text = getText();
	if (text.length() > 0) {
		GC gc = new GC(parent);
		textWidth = gc.textExtent(text).x;
		gc.dispose();	
	}
}
}
