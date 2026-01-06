# Font Size Inconsistency Investigation
## Issue #2925 - Root Cause Analysis

**Date:** January 6, 2026  
**Issue:** https://github.com/eclipse-platform/eclipse.platform.swt/issues/2925  
**Investigation Scope:** Analyze why fonts of the same point size render differently across platforms

---

## Executive Summary

This investigation examines two hypotheses for inconsistent font sizes between SWT platforms:

1. **Hypothesis 1:** The OS (specifically macOS) intentionally makes fonts smaller than they should
2. **Hypothesis 2:** The macOS SWT implementation is calling OS APIs incorrectly

Based on code analysis, **Hypothesis 2 is the root cause**. The SWT implementation has a fundamental flaw in how it handles DPI scaling and font size conversion across platforms, particularly on macOS.

---

## Background

### Problem Statement

When the same font (e.g., Arial 72pt) is created in SWT across platforms:
- **Windows & Linux (GTK):** Font occupies approximately 7 grid units (out of 14 total in a 2× height box)
- **macOS:** Font occupies approximately 5 grid units (appears ~30% smaller)

This inconsistency causes:
- Diagrams created on one platform to look different on another
- Users needing workarounds like manual DPI scaling corrections
- Breaking the cross-platform promise of SWT

### Current Workaround (Used by Applications)

```java
int DPI = Display.getCurrent().getDPI().y;
if(DPI != 96) { // Not needed on Windows, but Mac will be 72
    FontData fd = new FontData(fontToScale);
    float factor = (float)96 / DPI;
    int newHeight = (int)(fd.getHeight() * factor);
    fd.setHeight(newHeight);
}
```

---

## Technical Analysis

### Part 1: Understanding DPI in SWT

#### Device.getDPI() vs Device.getScreenDPI()

SWT has two distinct DPI concepts:

1. **`Device.getDPI()`** - "Logical DPI" used for scaling
   - **Deprecated** as of recent versions (PR #2872)
   - Returns scaled DPI values

2. **`Device.getScreenDPI()`** - "Physical Screen DPI"
   - Returns the actual DPI reported by the OS
   - Platform-specific values

#### Platform DPI Values

| Platform | `getDPI()` | `getScreenDPI()` | Notes |
|----------|------------|------------------|-------|
| **Windows** | 96 | 96 | Always 96 (with DPI-aware mode) |
| **Linux (GTK)** | 96 | 96 | Default, can be configured |
| **macOS** | 72 | 72 | Native macOS DPI |

---

### Part 2: Font Creation Analysis

#### macOS (Cocoa) - Font.java

**In `init()` method (lines 312-332):**

```java
void init(String name, float height, int style, String nsName) {
    Point dpi = device.dpi, screenDPI = device.getScreenDPI();
    float size = height * dpi.y / screenDPI.y;  // Line 316
    // ...
    handle = NSFont.fontWithName(family, size);
}
```

**Analysis:**
- Input: `height` = font height in **points** (e.g., 72)
- `device.dpi` = 72 (set during Device initialization)
- `screenDPI` = 72 (native macOS DPI)
- Calculation: `size = 72 * 72 / 72 = 72` ✓

**In `getFontData()` method (lines 245-268):**

```java
public FontData[] getFontData() {
    Point dpi = device.dpi, screenDPI = device.getScreenDPI();
    FontData data = new FontData(name, 
        (float)handle.pointSize() * screenDPI.y / dpi.y,  // Line 262
        style);
}
```

**Analysis:**
- The conversion is **reversed** here: `pointSize * screenDPI / dpi`
- This maintains consistency for round-trip conversion

---

#### Linux (GTK) - Font.java

**In `init()` method (lines 254-279):**

```java
void init(String name, float height, int style, byte[] fontString) {
    Point dpi = device.dpi, screenDPI = device.getScreenDPI();
    float size = height * dpi.y / screenDPI.y;  // Line 258
    // ...
    OS.pango_font_description_set_size(handle, (int)(0.5f + size * OS.PANGO_SCALE));
}
```

**Analysis:**
- Input: `height` = font height in **points** (e.g., 72)
- `device.dpi` = 96 (from Device.init())
- `screenDPI` = 96 (GTK default)
- Calculation: `size = 72 * 96 / 96 = 72` ✓
- Then: `pango_size = 72 * 1024 = 73728` (PANGO_SCALE = 1024)

**In `getFontData()` method (lines 185-210):**

```java
public FontData[] getFontData() {
    float height = (float)OS.pango_font_description_get_size(handle) / OS.PANGO_SCALE;
    Point dpi = device.dpi, screenDPI = device.getScreenDPI();
    float size = height * screenDPI.y / dpi.y;  // Line 195
}
```

---

### Part 3: The Critical Difference - Device Initialization

#### macOS Device.init() (cocoa/Device.java, lines 595-629)

```java
protected void init () {
    // ...
    Point dpi = this.dpi = getDPI(), screenDPI = getScreenDPI();
    NSFont font = NSFont.systemFontOfSize(systemFontSize * dpi.y / screenDPI.y);
    // ...
}
```

**Key line 625-626:**
```java
Point dpi = this.dpi = getDPI(), screenDPI = getScreenDPI();
NSFont font = NSFont.systemFontOfSize(systemFontSize * dpi.y / screenDPI.y);
```

- `this.dpi` is set to `getDPI()` which returns `getScreenDPI()`
- **Result:** `device.dpi = 72` on macOS

#### Linux (GTK) Device.init() (gtk/Device.java, lines 654-745)

```java
protected void init () {
    // ...
    this.dpi = getDPI();  // Line 705
    Point screenDPI = getScreenDPI();
    if (this.dpi.y != screenDPI.y) {
        int size = OS.pango_font_description_get_size(defaultFont);
        OS.pango_font_description_set_size(defaultFont, size * dpi.y / screenDPI.y);
    }
    // ...
}
```

**Key lines 737-741:**
```java
Point screenDPI = getScreenDPI();
if (this.dpi.y != screenDPI.y) {
    int size = OS.pango_font_description_get_size(defaultFont);
    OS.pango_font_description_set_size(defaultFont, size * dpi.y / screenDPI.y);
}
```

- `this.dpi` is set to `getDPI()` which returns `getScreenDPI()` 
- **Result:** `device.dpi = 96` on Linux

---

### Part 4: Root Cause Identification

## THE FUNDAMENTAL FLAW

The issue is **NOT** in Font.java itself. The font conversion logic is mathematically correct:

```java
// Font.init() - Convert input points to platform-specific size
float size = height * dpi.y / screenDPI.y;

// Font.getFontData() - Convert platform size back to points
float height = platformSize * screenDPI.y / dpi.y;
```

**The real problem is in the DPI values themselves:**

### The macOS `getScreenDPI()` Implementation

**File:** `bundles/org.eclipse.swt/Eclipse SWT/cocoa/org/eclipse/swt/graphics/Device.java` (lines 489-498)

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

**Analysis:**

1. **`NSDeviceResolution`** returns the **native** screen resolution (typically 72 DPI on macOS)
2. **`backingScaleFactor()`** accounts for Retina displays (1.0, 2.0, etc.)
3. **Division by scaling factor** converts physical pixels back to points

**The Issue:** This returns 72 DPI, which is the **typographic point** convention (1 point = 1/72 inch), NOT the logical display DPI.

---

## Root Cause Summary

### Hypothesis 1: OS Makes Fonts Smaller ❌

**Verdict:** **FALSE**

- macOS is NOT intentionally making fonts smaller
- macOS follows the PostScript/typography convention where 1 point = 1/72 inch
- When you request a 72-point font, macOS gives you exactly that: 1 inch tall

### Hypothesis 2: SWT Implementation Error ✓

**Verdict:** **TRUE**

The SWT implementation has a **conceptual mismatch**:

1. **Windows/GTK Assumption:**
   - Uses 96 DPI as the "standard" logical DPI
   - Font points are scaled relative to 96 DPI
   - This creates a 96/72 = 1.33× size multiplier

2. **macOS Reality:**
   - Uses 72 DPI (the actual typographic definition)
   - Font points are NOT scaled
   - 1 point = 1/72 inch (correct definition)

3. **The Mismatch:**
   - SWT's internal logic assumes ALL platforms use 96 DPI as baseline
   - macOS correctly uses 72 DPI as baseline
   - Result: Same point size creates **25% smaller** fonts on macOS (72/96 = 0.75)

---

## Detailed Evidence

### Evidence 1: Font Size Formula

The formula used in Font.init():

```java
float size = height * dpi.y / screenDPI.y;
```

With actual values:

| Platform | height | dpi.y | screenDPI.y | size | Result |
|----------|--------|-------|-------------|------|--------|
| **Windows** | 72 | 96 | 96 | 72 | Correct |
| **Linux** | 72 | 96 | 96 | 72 | Correct |
| **macOS** | 72 | 72 | 72 | 72 | Appears smaller! |

The **mathematical result is the same (72)**, but the **visual result differs** because:
- macOS interprets 72 points as 72 units at 72 DPI = 1 inch physical
- Windows/Linux interprets 72 points as 72 units at 96 DPI = 0.75 inch physical

### Evidence 2: Drawing Operations

From issue comment #3713746175:

> "GC figures (boxes and lines) are drawn in pixels (x pixels by y pixels)"

This is **WRONG**. According to @laeubi:

> "This should not be the case. SWT uses 'points' everywhere and maybe translates it into pixels"

**Reality:**
- GTK: Uses points, automatically scaled to pixels based on DPI
- macOS: Uses points directly (1 point = 1/72 inch)
- Windows: Uses logical pixels at 96 DPI

### Evidence 3: Test Results

From the snippet test (comment #3713681469):

**Linux (96 DPI):**
- Font height 72 occupies ~7 grid units out of 14 (box height = 144)
- Visual size is **consistent** with expectations

**macOS (72 DPI):**
- Font height 72 occupies ~5 grid units out of 14 (box height = 144)
- Visual size is **~25% smaller** than expected

**Windows (96 DPI):**
- Font height 72 occupies ~7 grid units out of 14 (box height = 144)
- Visual size is **consistent** with Linux

---

## The Deeper Problem: Mixed Units

SWT has a fundamental inconsistency in unit handling:

### What SWT Claims:

From various javadocs and comments:
> "SWT uses points everywhere"

### What SWT Actually Does:

1. **FontData.height** is documented as **points**
2. **Drawing operations** (rectangles, lines) are in **logical units**
3. **Logical units** are treated as:
   - **Points** on macOS (72 per inch)
   - **Pixels** on Windows (96 per inch at 100% scaling)
   - **Points** on GTK (96 per inch)

This creates an **impedance mismatch** where:
- A 72-point font and a 72-point rectangle should have the same size
- On macOS: They do (both 1 inch)
- On Windows/Linux: Font is 0.75 inch, rectangle is 0.75 inch at 96 DPI
- **But when comparing across platforms, fonts appear different sizes**

---

## Why Windows/Linux Match but macOS Differs

### Historical Context

1. **Windows:** Historically used 96 DPI as "logical DPI" for displays
   - This became the de facto standard for desktop computing
   - 1 logical pixel = 1/96 inch at 100% scaling

2. **Linux (GTK):** Follows X11/Freedesktop conventions
   - Default DPI is 96 (configurable)
   - Matches Windows convention for compatibility

3. **macOS:** Follows PostScript/typography conventions
   - 1 point = 1/72 inch (Adobe PostScript definition)
   - macOS UI uses points, not pixels
   - Retina displays use 2× pixel density but maintain point sizes

### Why SWT Matches Windows/Linux

SWT was originally developed for Eclipse on Windows and Linux. The 96 DPI convention became baked into the assumptions:

1. Font size calculations assumed 96 DPI baseline
2. Drawing operations assumed 96 DPI logical units
3. macOS port adapted to macOS APIs but kept 96 DPI assumptions

**Result:** macOS correctly implements 72 DPI points, but this breaks SWT's implicit 96 DPI assumption.

---

## Proof: The System Font

Look at how the system font is initialized:

### macOS (cocoa/Device.java, lines 623-628):

```java
boolean smallFonts = System.getProperty("org.eclipse.swt.internal.carbon.smallFonts") != null;
double systemFontSize = smallFonts ? NSFont.smallSystemFontSize() : NSFont.systemFontSize();
Point dpi = this.dpi = getDPI(), screenDPI = getScreenDPI();
NSFont font = NSFont.systemFontOfSize(systemFontSize * dpi.y / screenDPI.y);
font.retain();
systemFont = Font.cocoa_new(this, font);
```

- `systemFontSize` is the macOS system font size (typically 13 points)
- The calculation `systemFontSize * dpi.y / screenDPI.y` = `13 * 72 / 72 = 13`
- **No scaling is applied** because dpi and screenDPI are the same

### Linux (gtk/Device.java, lines 737-742):

```java
Point screenDPI = getScreenDPI();
if (this.dpi.y != screenDPI.y) {
    int size = OS.pango_font_description_get_size(defaultFont);
    OS.pango_font_description_set_size(defaultFont, size * dpi.y / screenDPI.y);
}
systemFont = Font.gtk_new (this, defaultFont);
```

- If `dpi != screenDPI`, the font size is **scaled**
- Default: `dpi = 96`, `screenDPI = 96`, so no scaling
- **But the logic exists** to handle different DPI values

**The difference:** GTK's implementation **acknowledges** that dpi might differ from screenDPI and adjusts. macOS implementation assumes they're always the same.

---

## Why the Current Workaround Works

Users currently compensate with:

```java
int DPI = Display.getCurrent().getDPI().y;
float factor = (float)96 / DPI;
int newHeight = (int)(fontHeight * factor);
```

**On macOS:**
- `DPI = 72`
- `factor = 96 / 72 = 1.333`
- `newHeight = fontHeight * 1.333`

This **artificially inflates** the font size on macOS to match Windows/Linux appearance.

**This is a workaround for SWT's inconsistency, not a fix for an OS problem.**

---

## Conclusions

### Primary Finding

**The macOS SWT implementation is correct according to typography standards but inconsistent with SWT's implicit 96 DPI baseline.**

### Secondary Finding

**SWT has a hidden assumption that 96 DPI is the "standard" logical DPI, which is not documented and not enforced across platforms.**

### Tertiary Finding

**The deprecation of `getDPI()` removes the only API that allowed applications to detect and compensate for DPI differences.**

---

## Recommendations

### Recommendation 1: Normalize Font Handling (HIGH PRIORITY)

**Modify macOS implementation to use 96 DPI as the logical baseline**

#### Option A: Change `getScreenDPI()` on macOS

**File:** `bundles/org.eclipse.swt/Eclipse SWT/cocoa/org/eclipse/swt/graphics/Device.java`

```java
Point getScreenDPI () {
    // Return 96 DPI to match Windows/Linux convention
    // This makes fonts visually consistent across platforms
    return new Point(96, 96);
}
```

**Pros:**
- Minimal code change
- Fixes font size inconsistency immediately
- No application code changes needed

**Cons:**
- Breaks semantic correctness (macOS is actually 72 DPI)
- May affect printing and other DPI-dependent operations
- Hides the real problem rather than fixing it

#### Option B: Add Platform-Specific Scaling in Font.init()

```java
void init(String name, float height, int style, String nsName) {
    if (name == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
    if (height < 0) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
    
    Point dpi = device.dpi, screenDPI = device.getScreenDPI();
    
    // Normalize to 96 DPI baseline for cross-platform consistency
    float normalizedHeight = height * 96 / screenDPI.y;
    float size = normalizedHeight * dpi.y / screenDPI.y;
    
    // ... rest of font creation
}
```

**Pros:**
- Semantically correct (preserves 72 DPI truth)
- Fixes visual inconsistency
- Isolated to Font class

**Cons:**
- More complex conversion logic
- May affect font metrics
- Still has hardcoded 96 DPI assumption

### Recommendation 2: Provide Configuration API (MEDIUM PRIORITY)

Add a Device property to explicitly set the logical DPI baseline:

```java
/**
 * Sets the logical DPI baseline for this device.
 * Default is 96 on all platforms for consistency.
 * 
 * @param dpi the logical DPI (typically 72 or 96)
 */
public void setLogicalDPI(int dpi);

/**
 * Gets the logical DPI baseline for this device.
 * 
 * @return the logical DPI
 */
public int getLogicalDPI();
```

This allows applications to:
1. Query the actual baseline being used
2. Override it if needed (e.g., for printing)
3. Make informed decisions about font scaling

### Recommendation 3: Document DPI Behavior (HIGH PRIORITY)

Update javadocs to explicitly state:

1. **FontData.height** is in **points** relative to 96 DPI baseline
2. **Drawing coordinates** are in **logical units** (96 per inch)
3. **Platform differences:**
   - Windows: 96 DPI native
   - Linux: 96 DPI default
   - macOS: Scaled from 72 DPI native to 96 DPI logical

### Recommendation 4: Add GC Configuration Option (MEDIUM PRIORITY)

As suggested by @akoch-yatta in issue comment, provide a GC-level option:

```java
/**
 * Sets the font rendering mode for this GC.
 * 
 * @param mode one of:
 *   - GC.FONT_MODE_NATIVE: Use native platform DPI (may differ across platforms)
 *   - GC.FONT_MODE_NORMALIZED: Use 96 DPI baseline for consistency (default)
 */
public void setFontMode(int mode);
```

This allows applications that need pixel-perfect cross-platform rendering to opt into normalized mode, while applications that need native platform appearance can use native mode.

### Recommendation 5: Replacement for getDPI() (HIGH PRIORITY)

Since `getDPI()` is deprecated, provide a replacement API:

```java
/**
 * Returns the logical DPI for the device.
 * This represents the device's coordinate system, not necessarily
 * the physical screen DPI.
 * 
 * On most platforms, this returns 96 DPI.
 * Applications should use this for unit conversion calculations.
 * 
 * @return the logical DPI as a Point
 */
public Point getLogicalDPI();

/**
 * Returns the physical screen DPI.
 * This represents the actual screen resolution.
 * 
 * Note: This may differ from getLogicalDPI() and should only be used
 * for specific calculations that need physical measurements.
 * 
 * @return the physical screen DPI as a Point
 */
public Point getPhysicalDPI(); // Rename from getScreenDPI()
```

---

## Implementation Strategy

### Phase 1: Quick Fix (For Next Release)

1. Change macOS `getScreenDPI()` to return `new Point(96, 96)`
2. Add deprecation notice explaining the change
3. Document the behavior in release notes

### Phase 2: Proper Solution (For Major Release)

1. Add `getLogicalDPI()` and `getPhysicalDPI()` APIs
2. Update Font.init() to use normalized baseline
3. Add GC font rendering mode option
4. Provide migration guide for applications

### Phase 3: Testing & Validation

1. Create comprehensive cross-platform font rendering tests
2. Test with existing applications (Eclipse IDE, Archi, GMF, etc.)
3. Validate printing behavior
4. Performance testing for font scaling overhead

---

## Testing Recommendations

### Test 1: Cross-Platform Visual Test

Use the snippet from issue comment #3713681469 to validate:
- Same font height produces same visual size
- Grid alignment is consistent
- Text fits in sized boxes identically

### Test 2: Font Metrics Test

Verify that font metrics return consistent values:
```java
Font font = new Font(display, "Arial", 72, SWT.NORMAL);
GC gc = new GC(display);
gc.setFont(font);
FontMetrics metrics = gc.getFontMetrics();

// These should be proportional across platforms:
int height = metrics.getHeight();
int ascent = metrics.getAscent();
int descent = metrics.getDescent();
```

### Test 3: Round-Trip Test

Verify font data survives round-trip conversion:
```java
Font original = new Font(display, "Arial", 72, SWT.NORMAL);
FontData[] fd = original.getFontData();
Font restored = new Font(display, fd);

// Should be identical
assertEquals(original.getFontData()[0].getHeight(), 
             restored.getFontData()[0].getHeight());
```

### Test 4: Drawing Consistency Test

Verify that text height matches rectangle height:
```java
int fontSize = 72;
Font font = new Font(display, "Arial", fontSize, SWT.NORMAL);
gc.setFont(font);

Point textSize = gc.textExtent("Test");
gc.drawRectangle(0, 0, textSize.x, textSize.y);
gc.drawText("Test", 0, 0);

// Text should fit within rectangle
```

---

## Appendix A: Platform DPI Details

### macOS DPI Behavior

**Standard Displays:**
- Logical DPI: 72 (native)
- Physical DPI: Varies (typically 110-130)
- Backing Scale Factor: 1.0

**Retina Displays:**
- Logical DPI: 72 (native)
- Physical DPI: 220 (2× 110)
- Backing Scale Factor: 2.0

**Key Point:** macOS uses a **resolution-independent** coordinate system where 1 point = 1/72 inch regardless of physical pixel density.

### Windows DPI Behavior

**Standard DPI:**
- Logical DPI: 96 (system default)
- Physical DPI: Matches logical DPI at 100% scaling
- Scaling Factor: 1.0 (100%)

**High DPI:**
- Logical DPI: Still 96 (for DPI-aware applications)
- Physical DPI: 120, 144, 192, etc.
- Scaling Factor: 1.25 (125%), 1.5 (150%), 2.0 (200%), etc.

**Key Point:** Windows uses **logical pixels** scaled from 96 DPI baseline.

### Linux (GTK) DPI Behavior

**Default:**
- Logical DPI: 96 (freedesktop.org standard)
- Physical DPI: Detected from EDID or configured
- Scaling Factor: Computed from scale factor setting

**Configurable:**
- User can set text scaling factor
- GNOME/KDE have per-monitor DPI settings
- GTK_SCALE environment variable for integer scaling

**Key Point:** GTK follows Windows convention but with more configurability.

---

## Appendix B: Code References

### Key Files for Investigation

1. **Font Implementation:**
   - `bundles/org.eclipse.swt/Eclipse SWT/cocoa/org/eclipse/swt/graphics/Font.java`
   - `bundles/org.eclipse.swt/Eclipse SWT/gtk/org/eclipse/swt/graphics/Font.java`
   - `bundles/org.eclipse.swt/Eclipse SWT/win32/org/eclipse/swt/graphics/Font.java`

2. **Device/DPI Implementation:**
   - `bundles/org.eclipse.swt/Eclipse SWT/cocoa/org/eclipse/swt/graphics/Device.java`
   - `bundles/org.eclipse.swt/Eclipse SWT/gtk/org/eclipse/swt/graphics/Device.java`
   - `bundles/org.eclipse.swt/Eclipse SWT/win32/org/eclipse/swt/graphics/Device.java`

3. **FontData Implementation:**
   - `bundles/org.eclipse.swt/Eclipse SWT/cocoa/org/eclipse/swt/graphics/FontData.java`
   - `bundles/org.eclipse.swt/Eclipse SWT/gtk/org/eclipse/swt/graphics/FontData.java`
   - `bundles/org.eclipse.swt/Eclipse SWT/win32/org/eclipse/swt/graphics/FontData.java`

### Key Methods

1. **`Device.getScreenDPI()`** - Returns physical screen DPI
2. **`Device.getDPI()`** - Returns logical DPI (deprecated)
3. **`Font.init(String, float, int, ...)`** - Font creation and size conversion
4. **`Font.getFontData()`** - Retrieves font information including size

---

## Appendix C: Mathematical Proof

### Theorem: Current Implementation Creates 25% Size Difference

Given:
- Windows/Linux logical DPI: 96
- macOS logical DPI: 72
- Font point size: `H` (in points)

**Windows/Linux visual size:**
```
Visual size = H points × (1 inch / 96 points) = H/96 inches
```

**macOS visual size:**
```
Visual size = H points × (1 inch / 72 points) = H/72 inches
```

**Ratio:**
```
macOS size / Windows size = (H/72) / (H/96) = 96/72 = 1.333
```

Therefore:
- macOS fonts appear 33% LARGER if we consider absolute inches
- OR Windows/Linux fonts appear 33% LARGER than macOS if we normalize to the same logical units

**But in practice:**
Since SWT normalizes to 96 DPI baseline:
- Windows/Linux: Font size `H` → logical size `H` at 96 DPI
- macOS: Font size `H` → logical size `H` at 72 DPI = `H * (72/96)` = `H * 0.75` relative to 96 DPI

**Result: macOS fonts appear 25% SMALLER** (0.75 = 75% = 25% smaller)

---

## Appendix D: Historical Context

### Why 96 DPI?

In the early days of Windows (3.x era), Microsoft chose 96 DPI as the logical display resolution because:

1. **CRT monitors** of the time had physical DPI around 96
2. **VGA/SVGA** resolutions (640×480, 800×600) with typical monitor sizes yielded ~96 DPI
3. **Integer scaling** from 96 to 72 (typography standard) is 4:3, a clean ratio

### Why 72 DPI?

Adobe PostScript standardized on 72 DPI because:

1. **Typography convention:** 1 point = 1/72 inch (established in printing industry)
2. **Clean conversion:** 6 picas = 1 inch, 12 points = 1 pica, so 72 points = 1 inch
3. **Apple adoption:** macOS (née Mac OS) adopted PostScript for its imaging model

### The Divergence

- **Microsoft** chose 96 DPI for practical display reasons
- **Apple** chose 72 DPI for typography/printing reasons
- **Linux** followed Microsoft for compatibility

**Result:** Two competing standards that SWT must bridge.

---

## Conclusion

The font size inconsistency in SWT is due to **a valid design choice by macOS** (72 DPI typography standard) conflicting with **an undocumented assumption in SWT** (96 DPI baseline).

**The fix requires SWT to explicitly normalize to a single baseline** (preferably 96 DPI for backward compatibility) while maintaining semantic correctness in documentation and providing APIs for applications that need fine-grained control.

---

## References

1. GitHub Issue #2925: https://github.com/eclipse-platform/eclipse.platform.swt/issues/2925
2. PR #2872 (getDPI deprecation): https://github.com/eclipse-platform/eclipse.platform.swt/pull/2872
3. PostScript Language Reference: https://www.adobe.com/products/postscript/pdfs/PLRM.pdf
4. Windows DPI documentation: https://docs.microsoft.com/en-us/windows/win32/hidpi/high-dpi-desktop-application-development-on-windows
5. GTK DPI scaling: https://wiki.gnome.org/HowDoI/HiDpi
