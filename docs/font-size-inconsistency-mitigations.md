# Font Size Inconsistency - Proposed Mitigations

This document outlines proposed solutions to fix the font size inconsistency identified in issue #2925.

---

## Solution 1: Normalize macOS getScreenDPI() to 96 DPI (Quick Fix)

### Overview
Change macOS implementation to return 96 DPI to match Windows/Linux convention, providing immediate cross-platform consistency.

### Implementation

**File:** `bundles/org.eclipse.swt/Eclipse SWT/cocoa/org/eclipse/swt/graphics/Device.java`

**Current Implementation (lines 489-498):**
```java
Point getScreenDPI () {
    NSScreen screen = getPrimaryScreen();
    if (screen == null) return new Point(0, 0);

    NSDictionary dictionary = screen.deviceDescription();
    NSValue value = new NSValue(dictionary.objectForKey(new id(OS.NSDeviceResolution())).id);
    NSSize size = value.sizeValue();
    double scaling = screen.backingScaleFactor();
    return new Point((int)(size.width / scaling), (int)(size.height / scaling));
}
```

**Proposed Change:**
```java
Point getScreenDPI () {
    // Return normalized 96 DPI for cross-platform font consistency
    // macOS natively uses 72 DPI (1 point = 1/72 inch), but SWT standardizes
    // on 96 DPI across all platforms to ensure fonts render at the same visual size.
    // 
    // Note: This affects font rendering and coordinate calculations. Printing
    // operations that need physical measurements should use NSDeviceResolution
    // directly instead of relying on this method.
    //
    // See: docs/font-size-inconsistency-investigation.md for detailed explanation
    return new Point(96, 96);
}
```

### Impact Analysis

#### Pros
- ✅ **Immediate fix** - Single line change
- ✅ **No API changes** - No breaking changes for applications
- ✅ **Fixes font inconsistency** - Fonts will render at same size across platforms
- ✅ **Backward compatible** - Existing code continues to work
- ✅ **Simple to understand** - Clear intent in comments

#### Cons
- ⚠️ **Semantically incorrect** - 96 DPI doesn't match macOS native 72 DPI
- ⚠️ **Potential printing issues** - May affect print scaling if code depends on getScreenDPI()
- ⚠️ **Hides root cause** - Doesn't address the underlying design issue
- ⚠️ **May affect coordinate calculations** - Any code using screenDPI for math will be affected

#### Testing Required
1. Font rendering tests across all platforms
2. Printing tests (verify print output physical size)
3. High DPI/Retina display tests
4. Font metrics tests
5. Existing application compatibility (Eclipse IDE, Archi, etc.)

#### Migration Notes
None required - change is transparent to applications.

---

## Solution 2: Add Font Normalization Layer (Proper Fix)

### Overview
Add explicit DPI normalization in Font class while maintaining semantic correctness of Device.getScreenDPI().

### Implementation

**File:** `bundles/org.eclipse.swt/Eclipse SWT/cocoa/org/eclipse/swt/graphics/Font.java`

**Add private helper method:**
```java
/**
 * Returns the normalized DPI baseline for font calculations.
 * SWT uses 96 DPI as the standard baseline across all platforms
 * for cross-platform font size consistency.
 * 
 * @return normalized DPI baseline (always 96)
 */
private static final int NORMALIZED_DPI = 96;

private int getNormalizedDPI() {
    return NORMALIZED_DPI;
}
```

**Modify init() method (around line 312):**
```java
void init(String name, float height, int style, String nsName) {
    if (name == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
    if (height < 0) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
    
    // Use normalized DPI for cross-platform consistency
    // macOS natively uses 72 DPI, but we normalize to 96 DPI baseline
    Point screenDPI = device.getScreenDPI();
    int normalizedDPI = getNormalizedDPI();
    
    // Convert input height (in points at 96 DPI) to macOS native size
    // height is at 96 DPI baseline, we need size at 72 DPI
    float size = height * normalizedDPI / screenDPI.y;
    
    NSFont systemFont = NSFont.systemFontOfSize(size);
    NSFont boldSystemFont = NSFont.boldSystemFontOfSize(size);
    String systemFontName = systemFont.familyName().getString();
    String boldSystemFontName = boldSystemFont.familyName().getString();
    if (systemFontName.equals(name) || boldSystemFontName.equals(name)) {
        handle = ((style & SWT.BOLD) == 0 ? systemFont : boldSystemFont);
    } else if (nsName != null) {
        handle = NSFont.fontWithName(NSString.stringWith(nsName), size);
    } else {
        NSString family = NSString.stringWith(name);
        handle = NSFont.fontWithName(family, size);
    }
    initTraits(style, systemFont);
    handle.retain();
}
```

**Modify getFontData() method (around line 245):**
```java
public FontData[] getFontData() {
    if (isDisposed()) SWT.error(SWT.ERROR_GRAPHIC_DISPOSED);
    NSAutoreleasePool pool = null;
    if (!NSThread.isMainThread()) pool = (NSAutoreleasePool) new NSAutoreleasePool().alloc().init();
    try {
        NSString family = handle.familyName();
        String name = family.getString();
        NSString str = handle.fontName();
        String nsName = str.getString();
        NSFontManager manager = NSFontManager.sharedFontManager();
        long traits = manager.traitsOfFont(handle);
        int style = SWT.NORMAL;
        if ((traits & OS.NSItalicFontMask) != 0) style |= SWT.ITALIC;
        if ((traits & OS.NSBoldFontMask) != 0) style |= SWT.BOLD;
        if ((extraTraits & OS.NSItalicFontMask) != 0) style |= SWT.ITALIC;
        if ((extraTraits & OS.NSBoldFontMask) != 0) style |= SWT.BOLD;
        
        // Convert macOS native size back to normalized 96 DPI baseline
        Point screenDPI = device.getScreenDPI();
        int normalizedDPI = getNormalizedDPI();
        float height = (float)handle.pointSize() * screenDPI.y / normalizedDPI;
        
        FontData data = new FontData(name, height, style);
        data.nsName = nsName;
        return new FontData[]{data};
    } finally {
        if (pool != null) pool.release();
    }
}
```

**Also update Device.init() to not scale system font (around line 625):**
```java
protected void init () {
    // ... existing code ...
    
    /* Initialize the system font slot */
    boolean smallFonts = System.getProperty("org.eclipse.swt.internal.carbon.smallFonts") != null;
    double systemFontSize = smallFonts ? NSFont.smallSystemFontSize() : NSFont.systemFontSize();
    
    // System font is already in native macOS size, no conversion needed here
    // Font.init() will handle normalization
    NSFont font = NSFont.systemFontOfSize(systemFontSize);
    font.retain();
    systemFont = Font.cocoa_new(this, font);
}
```

### Impact Analysis

#### Pros
- ✅ **Semantically correct** - Preserves accurate 72 DPI in Device.getScreenDPI()
- ✅ **Fixes font inconsistency** - Fonts render at same size across platforms
- ✅ **Isolated change** - Only affects Font class
- ✅ **Printing unaffected** - Printing can still use accurate screenDPI
- ✅ **Clear documentation** - Explicit normalization layer is documented

#### Cons
- ⚠️ **More complex** - Additional conversion logic in Font class
- ⚠️ **Performance** - Extra multiplication/division (negligible)
- ⚠️ **Still hardcoded** - 96 DPI baseline is still a magic number

#### Testing Required
Same as Solution 1, plus:
1. Verify Device.getScreenDPI() still returns 72
2. Verify printing uses correct physical measurements
3. Test font metrics calculations

#### Migration Notes
None required - change is transparent to applications.

---

## Solution 3: Add Configuration API (Long-term Solution)

### Overview
Provide explicit API for applications to control DPI baseline and font rendering modes.

### Implementation

**File:** `bundles/org.eclipse.swt/Eclipse SWT/common/org/eclipse/swt/graphics/Device.java`

**Add new methods:**
```java
/**
 * The logical DPI baseline used for font and coordinate calculations.
 * Default is 96 DPI on all platforms for cross-platform consistency.
 */
private int logicalDPI = 96;

/**
 * Sets the logical DPI baseline for this device.
 * This affects font sizing and coordinate calculations.
 * <p>
 * The default value is 96 DPI, which provides consistent rendering
 * across Windows, Linux, and macOS. Applications that need native
 * platform DPI behavior can set this to match the physical screen DPI.
 * </p>
 * <p>
 * <b>Note:</b> This method must be called before any fonts are created
 * or graphics operations are performed. Changing the logical DPI after
 * initialization may result in inconsistent rendering.
 * </p>
 * 
 * @param dpi the logical DPI baseline (typically 72 or 96)
 * @throws IllegalArgumentException if dpi is less than 1
 * @throws IllegalStateException if called after device initialization
 * 
 * @since 3.x.x
 */
public void setLogicalDPI(int dpi) {
    checkDevice();
    if (dpi < 1) throw new IllegalArgumentException("DPI must be positive");
    // Check if already initialized (e.g., fonts created)
    if (systemFont != null) {
        throw new IllegalStateException("Cannot change logical DPI after device initialization");
    }
    this.logicalDPI = dpi;
}

/**
 * Returns the logical DPI baseline for this device.
 * This value is used for font sizing and coordinate calculations.
 * <p>
 * The default is 96 DPI on all platforms, providing cross-platform
 * consistency. This may differ from the physical screen DPI returned
 * by {@link #getPhysicalDPI()}.
 * </p>
 * 
 * @return the logical DPI baseline
 * @see #setLogicalDPI(int)
 * @see #getPhysicalDPI()
 * 
 * @since 3.x.x
 */
public int getLogicalDPI() {
    checkDevice();
    return logicalDPI;
}

/**
 * Returns the physical screen DPI.
 * This represents the actual screen resolution and may differ from
 * the logical DPI returned by {@link #getLogicalDPI()}.
 * <p>
 * On macOS, this returns 72 DPI (the native point-based coordinate system).
 * On Windows and Linux, this typically returns 96 DPI.
 * </p>
 * <p>
 * Most applications should use {@link #getLogicalDPI()} instead,
 * which provides cross-platform consistency. Use this method only when
 * physical measurements are required (e.g., for printing).
 * </p>
 * 
 * @return the physical screen DPI as a Point
 * @see #getLogicalDPI()
 * 
 * @since 3.x.x
 */
public Point getPhysicalDPI() {
    checkDevice();
    return getScreenDPI();
}
```

**File:** `bundles/org.eclipse.swt/Eclipse SWT/common/org/eclipse/swt/graphics/GC.java`

**Add font rendering mode:**
```java
/**
 * Font rendering mode constants
 */
 
/**
 * Font rendering mode: Use native platform DPI.
 * Fonts will render according to the platform's native conventions:
 * - macOS: 72 DPI (may appear smaller)
 * - Windows/Linux: 96 DPI
 * 
 * @since 3.x.x
 */
public static final int FONT_MODE_NATIVE = 0;

/**
 * Font rendering mode: Use normalized 96 DPI baseline.
 * Fonts will render consistently across all platforms.
 * This is the default mode.
 * 
 * @since 3.x.x
 */
public static final int FONT_MODE_NORMALIZED = 1;

/**
 * Current font rendering mode
 */
private int fontMode = FONT_MODE_NORMALIZED;

/**
 * Sets the font rendering mode for this graphics context.
 * <p>
 * The font rendering mode affects how font sizes are interpreted:
 * </p>
 * <ul>
 * <li>{@link #FONT_MODE_NATIVE}: Fonts render using native platform DPI,
 * which may differ across platforms.</li>
 * <li>{@link #FONT_MODE_NORMALIZED}: Fonts render using 96 DPI baseline
 * for cross-platform consistency (default).</li>
 * </ul>
 * <p>
 * This setting only affects fonts set after calling this method.
 * Existing font rendering is not changed.
 * </p>
 * 
 * @param mode one of {@link #FONT_MODE_NATIVE} or {@link #FONT_MODE_NORMALIZED}
 * @throws IllegalArgumentException if mode is invalid
 * 
 * @since 3.x.x
 */
public void setFontRenderingMode(int mode) {
    if (handle == 0) SWT.error(SWT.ERROR_GRAPHIC_DISPOSED);
    if (mode != FONT_MODE_NATIVE && mode != FONT_MODE_NORMALIZED) {
        throw new IllegalArgumentException("Invalid font rendering mode");
    }
    this.fontMode = mode;
    // Platform-specific implementation to apply mode
}

/**
 * Returns the current font rendering mode.
 * 
 * @return one of {@link #FONT_MODE_NATIVE} or {@link #FONT_MODE_NORMALIZED}
 * @see #setFontRenderingMode(int)
 * 
 * @since 3.x.x
 */
public int getFontRenderingMode() {
    if (handle == 0) SWT.error(SWT.ERROR_GRAPHIC_DISPOSED);
    return fontMode;
}
```

### Impact Analysis

#### Pros
- ✅ **Full control** - Applications can choose native or normalized mode
- ✅ **Future-proof** - Extensible for future DPI handling needs
- ✅ **Explicit** - Clear API makes behavior obvious
- ✅ **Backward compatible** - Default behavior matches normalized (current best practice)
- ✅ **Documented** - Clear javadocs explain trade-offs

#### Cons
- ⚠️ **API surface expansion** - New public APIs to maintain
- ⚠️ **Complexity** - Applications need to understand DPI concepts
- ⚠️ **Implementation effort** - Significant code changes across platforms
- ⚠️ **Testing burden** - Must test both modes on all platforms

#### Testing Required
1. Test both FONT_MODE_NATIVE and FONT_MODE_NORMALIZED on all platforms
2. Test setLogicalDPI() with various values
3. Test error handling (setting after init, invalid values)
4. Comprehensive font rendering tests in both modes
5. Backward compatibility tests

#### Migration Notes
Applications that want native macOS appearance:
```java
Display display = Display.getDefault();
// Must be called before creating any fonts or graphics
display.setLogicalDPI(display.getPhysicalDPI().y);
```

Applications that want normalized cross-platform appearance (default):
```java
// No changes needed - this is the default behavior
```

---

## Solution 4: Provide Replacement for Deprecated getDPI()

### Overview
Add new APIs to replace the deprecated `getDPI()` method with clearer semantics.

### Implementation

**File:** `bundles/org.eclipse.swt/Eclipse SWT/common/org/eclipse/swt/graphics/Device.java`

**Update getDPI() deprecation:**
```java
/**
 * Returns a point whose x coordinate is the logical horizontal
 * dots per inch of the display, and whose y coordinate
 * is the logical vertical dots per inch of the display.
 *
 * @return the horizontal and vertical DPI
 *
 * @exception SWTException <ul>
 *    <li>ERROR_DEVICE_DISPOSED - if the receiver has been disposed</li>
 * </ul>
 *
 * @deprecated This method returns a single global DPI value
 * that does not reflect per-monitor DPI settings on modern operating systems.
 * In environments with different scaling factors across monitors, it may provide
 * a misleading or meaningless result, as it does not correspond to the actual DPI
 * of any specific monitor.
 * <p>
 * Use {@link #getLogicalDPI()} for the baseline DPI used in coordinate
 * calculations, or {@link #getPhysicalDPI()} for the actual screen DPI.
 * </p>
 * <p>
 * Note: While deprecated for general {@code Device} instances like {@code Display},
 * this method may still be validly used when called on a {@code Printer} instance,
 * where a single global DPI value is meaningful and expected.
 * </p>
 */
@Deprecated
public Point getDPI () {
    checkDevice ();
    return getScreenDPI();
}
```

### Impact Analysis

#### Pros
- ✅ **Clear migration path** - Applications know what to use instead
- ✅ **Better semantics** - Separate logical vs physical DPI
- ✅ **Minimal change** - Just adds replacement methods

#### Cons
- ⚠️ **Requires Solution 3** - Needs the configuration API
- ⚠️ **Migration required** - Applications must update code

#### Migration Notes
Replace deprecated calls:

**Before:**
```java
Point dpi = Display.getCurrent().getDPI();
float factor = 96.0f / dpi.y;
```

**After (for cross-platform consistency):**
```java
int logicalDPI = Display.getCurrent().getLogicalDPI();
// logicalDPI is always 96, so no scaling needed
```

**After (for native platform behavior):**
```java
Point physicalDPI = Display.getCurrent().getPhysicalDPI();
float factor = 96.0f / physicalDPI.y;
```

---

## Recommended Implementation Order

### Phase 1: Quick Fix (v3.x.1)
1. Implement **Solution 1** (Normalize macOS getScreenDPI to 96)
2. Add extensive testing
3. Document change in release notes
4. Monitor for issues from community

### Phase 2: API Enhancement (v3.x+1.0)
1. Implement **Solution 3** (Configuration API)
2. Implement **Solution 4** (getDPI replacement)
3. Update Solution 1 to use the new logicalDPI infrastructure
4. Provide migration guide

### Phase 3: Refinement (v3.x+2.0)
1. Consider implementing **Solution 2** for ultimate correctness
2. Add GC-level font rendering modes
3. Optimize performance if needed
4. Complete documentation

---

## Testing Strategy

### Unit Tests
```java
@Test
public void testFontSizeConsistency() {
    // Create same font on all platforms
    Font font = new Font(display, "Arial", 72, SWT.NORMAL);
    
    // Get metrics
    GC gc = new GC(display);
    gc.setFont(font);
    FontMetrics metrics = gc.getFontMetrics();
    
    // Height should be consistent across platforms (within rounding)
    int height = metrics.getHeight();
    assertTrue("Font height should be ~72 points", 
               Math.abs(height - 72) < 5);
}

@Test
public void testFontDataRoundTrip() {
    Font original = new Font(display, "Arial", 72, SWT.NORMAL);
    FontData[] fd = original.getFontData();
    Font restored = new Font(display, fd);
    
    assertEquals("Font height should survive round trip",
                 original.getFontData()[0].getHeight(),
                 restored.getFontData()[0].getHeight(),
                 0.01f);
}

@Test
public void testDPIConsistency() {
    int logicalDPI = display.getLogicalDPI();
    Point physicalDPI = display.getPhysicalDPI();
    
    // Logical DPI should be 96 by default
    assertEquals("Default logical DPI should be 96", 96, logicalDPI);
    
    // Physical DPI should be platform-specific
    if (isMacOS()) {
        assertEquals("macOS physical DPI should be 72", 72, physicalDPI.y);
    } else {
        assertEquals("Windows/Linux physical DPI should be 96", 96, physicalDPI.y);
    }
}
```

### Visual Tests
1. **Cross-Platform Comparison:**
   - Run same snippet on Windows, Linux, macOS
   - Take screenshots
   - Measure pixel dimensions
   - Verify fonts appear same size

2. **Grid Alignment Test:**
   - Use the snippet from issue #2925
   - Verify font fits in 2× height box consistently
   - Check grid alignment

### Integration Tests
1. Test with Eclipse IDE
2. Test with Archi tool
3. Test with GMF applications
4. Test printing functionality
5. Test high DPI displays

---

## Documentation Updates

### JavaDoc Updates Required
1. Update `FontData` class javadoc to clarify point size interpretation
2. Update `Font` constructor javadocs
3. Add package-level documentation for org.eclipse.swt.graphics explaining DPI handling
4. Update SWT FAQ with DPI information

### User Documentation
1. Add migration guide for applications using getDPI()
2. Add "Understanding DPI in SWT" guide
3. Update platform-specific readmes
4. Add examples showing cross-platform font handling

---

## Backward Compatibility Considerations

### Breaking Changes (None Expected)
The proposed solutions maintain backward compatibility:
- Solution 1: Transparent change, no API impact
- Solution 2: Internal implementation change only
- Solution 3: Additive API, default behavior unchanged
- Solution 4: Deprecation only, existing API still works

### Applications That May Be Affected
Applications that:
1. Use `getDPI()` and make assumptions about its value
2. Directly compare font sizes across platforms
3. Perform custom DPI scaling

These applications will **benefit** from the fix and may be able to remove workarounds.

---

## Performance Considerations

### Solution 1 & 2: Negligible Impact
- Font creation happens infrequently
- Additional multiplication/division is trivial
- No memory overhead

### Solution 3: Minimal Impact
- Configuration API adds one int field per Device
- Font rendering mode adds one int field per GC
- No performance impact on existing code paths

---

## Security Considerations

No security implications identified. The changes affect:
- Internal DPI calculations (no user input)
- Font rendering (bounded by OS APIs)
- Configuration APIs (validated input)

---

## Conclusion

**Recommended Approach:**
1. Implement Solution 1 immediately for quick fix
2. Plan Solution 3 for next major release
3. Consider Solution 2 for ultimate correctness

This provides:
- Immediate relief for users (Solution 1)
- Long-term proper solution (Solution 3)
- Option for semantic correctness (Solution 2)

**Timeline Estimate:**
- Solution 1: 1-2 weeks (implementation + testing)
- Solution 3: 1-2 months (API design + implementation + testing)
- Solution 2: 2-4 weeks (implementation + testing)
