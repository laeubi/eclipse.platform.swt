# Font Size Inconsistency Investigation - Executive Summary

**Issue:** [#2925 - Now that Device.getDPI() is deprecated, what is the recommended way to get the current display DPI?](https://github.com/eclipse-platform/eclipse.platform.swt/issues/2925)

**Date:** January 6, 2026

---

## TL;DR

Fonts of the same point size appear **25% smaller on macOS** compared to Windows/Linux. This is due to SWT implicitly assuming 96 DPI as the baseline on all platforms, while macOS correctly uses its native 72 DPI.

**Root Cause:** Design inconsistency, not a bug  
**Impact:** Cross-platform applications have to manually compensate  
**Solution:** Normalize DPI handling across platforms  

---

## The Problem

When users create a font with the same point size (e.g., Arial 72pt) across platforms:
- **Windows & Linux:** Font occupies ~7 grid units (of 14 total, ≈70% of box)
- **macOS:** Font occupies ~5 grid units (of 14 total, ≈50% of box)

Visual comparison from issue:
- **Linux (96 DPI):** ✓ Font height = 72pt matches expectations
- **macOS (72 DPI):** ✗ Font height = 72pt appears 25% smaller
- **Windows (96 DPI):** ✓ Font height = 72pt matches expectations

---

## Root Cause Analysis

### Hypothesis 1: macOS Makes Fonts Smaller ❌

**VERDICT: FALSE**

macOS is NOT making fonts smaller. It correctly follows the typographic standard where **1 point = 1/72 inch**.

### Hypothesis 2: SWT Implementation Error ✓

**VERDICT: TRUE**

SWT has an **undocumented assumption** that all platforms use **96 DPI as the logical baseline**:

| Platform | Native DPI | SWT Assumption | Mismatch? |
|----------|------------|----------------|-----------|
| Windows  | 96         | 96             | No ✓      |
| Linux    | 96         | 96             | No ✓      |
| **macOS** | **72**     | **96**         | **Yes ✗** |

**The Math:**
- Font size calculation: `size = height * dpi.y / screenDPI.y`
- macOS: `size = 72 * 72 / 72 = 72` (correct mathematically)
- Windows/Linux: `size = 72 * 96 / 96 = 72` (correct mathematically)
- **But:** 72 at 72 DPI ≠ 72 at 96 DPI in visual size!
- **Result:** macOS fonts are 72/96 = 0.75 = 75% of expected size (25% smaller)

---

## Why This Matters

### For Application Developers

Applications that need cross-platform consistency must manually compensate:

```java
// Current workaround (used by Archi, GMF, etc.)
int DPI = Display.getCurrent().getDPI().y;
if(DPI != 96) { // Mac will be 72
    FontData fd = new FontData(font);
    float factor = (float)96 / DPI;
    int newHeight = (int)(fd.getHeight() * factor);
    fd.setHeight(newHeight);
}
```

### For End Users

- Diagrams created on Windows look different on Mac
- Text doesn't fit in fixed-size boxes consistently
- Screenshots from different platforms don't match

### For SWT

- `getDPI()` is deprecated with no clear replacement
- No documented way to achieve cross-platform consistency
- Breaks the "write once, run anywhere" promise

---

## Recommended Solutions

### Solution 1: Quick Fix (Recommended for Next Release)

**Change macOS `getScreenDPI()` to return 96 DPI**

```java
// In cocoa/Device.java
Point getScreenDPI () {
    // Return normalized 96 DPI for cross-platform font consistency
    return new Point(96, 96);
}
```

**Pros:**
- ✅ One-line change
- ✅ Immediate fix
- ✅ No API changes

**Cons:**
- ⚠️ Semantically incorrect (72 is the real DPI)
- ⚠️ May affect printing

**Files:** `docs/font-size-inconsistency-mitigations.md` (Solution 1)

### Solution 2: Proper Fix (Recommended for Major Release)

**Add normalization layer in Font class**

Keep `getScreenDPI()` accurate (72 on macOS) but normalize in Font.init():

```java
// In cocoa/Font.java
private static final int NORMALIZED_DPI = 96;

void init(String name, float height, int style, String nsName) {
    Point screenDPI = device.getScreenDPI();
    int normalizedDPI = NORMALIZED_DPI;
    float size = height * normalizedDPI / screenDPI.y;
    // ... rest of font creation
}
```

**Pros:**
- ✅ Semantically correct
- ✅ Isolated to Font class
- ✅ Printing unaffected

**Cons:**
- ⚠️ More complex
- ⚠️ Still hardcodes 96 DPI

**Files:** `docs/font-size-inconsistency-mitigations.md` (Solution 2)

### Solution 3: Long-term Solution (Recommended for Future)

**Add configuration API**

```java
// New Device methods
public void setLogicalDPI(int dpi);
public int getLogicalDPI();
public Point getPhysicalDPI(); // renamed from getScreenDPI()

// New GC methods
public void setFontRenderingMode(int mode);
// Modes: GC.FONT_MODE_NATIVE, GC.FONT_MODE_NORMALIZED
```

**Pros:**
- ✅ Full control for applications
- ✅ Explicit and documented
- ✅ Future-proof

**Cons:**
- ⚠️ Larger API surface
- ⚠️ More implementation work

**Files:** `docs/font-size-inconsistency-mitigations.md` (Solution 3)

---

## Documentation Deliverables

### 1. Investigation Report
**File:** `docs/font-size-inconsistency-investigation.md` (827 lines)

Comprehensive analysis including:
- Detailed technical investigation
- Code analysis of all three platforms
- Mathematical proof of 25% size difference
- Historical context (why 96 vs 72 DPI)
- References to platform documentation

### 2. Mitigation Strategies
**File:** `docs/font-size-inconsistency-mitigations.md` (700+ lines)

Four proposed solutions with:
- Implementation details and code samples
- Pros/cons analysis
- Testing strategies
- Migration guides
- Timeline estimates

### 3. Test Snippet
**File:** `examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet_FontConsistencyTest.java`

Visual test application that:
- Displays fonts in fixed-size boxes with grid overlay
- Shows font metrics and platform info
- Provides pass/fail consistency check
- Can be used to validate fixes

---

## Implementation Roadmap

### Phase 1: Quick Fix (v3.x.1)
**Timeline:** 1-2 weeks

1. Implement Solution 1 (normalize macOS DPI to 96)
2. Run comprehensive tests
3. Document in release notes
4. Monitor community feedback

**Risk:** Low  
**Impact:** High (immediate relief for users)

### Phase 2: API Enhancement (v3.x+1.0)
**Timeline:** 1-2 months

1. Implement Solution 3 (Configuration API)
2. Provide replacement for deprecated `getDPI()`
3. Update Solution 1 to use new infrastructure
4. Migration guide for applications

**Risk:** Medium  
**Impact:** High (proper long-term solution)

### Phase 3: Refinement (v3.x+2.0)
**Timeline:** 2-4 weeks

1. Consider implementing Solution 2 (ultimate correctness)
2. Optimize performance if needed
3. Complete documentation
4. Community feedback integration

**Risk:** Low  
**Impact:** Medium (polish and optimization)

---

## Testing Strategy

### Unit Tests
```java
@Test
public void testFontSizeConsistency() {
    Font font = new Font(display, "Arial", 72, SWT.NORMAL);
    GC gc = new GC(display);
    gc.setFont(font);
    FontMetrics metrics = gc.getFontMetrics();
    
    // Height should be consistent across platforms
    int height = metrics.getHeight();
    assertTrue("Font height should be ~72 points", 
               Math.abs(height - 72) < 5);
}
```

### Visual Tests
1. Run `Snippet_FontConsistencyTest` on all platforms
2. Compare screenshots
3. Verify grid alignment
4. Check consistency ratio (~0.70 expected)

### Integration Tests
1. Eclipse IDE compatibility
2. Archi tool testing
3. GMF applications
4. Printing functionality
5. High DPI displays

---

## Migration Guide for Applications

### Current Workaround (Pre-Fix)
```java
int DPI = Display.getCurrent().getDPI().y;
float factor = (float)96 / DPI;
int newHeight = (int)(fontHeight * factor);
```

### After Solution 1 (Quick Fix)
```java
// No changes needed - workaround can be removed
// DPI will be 96 on all platforms
```

### After Solution 3 (Configuration API)
```java
// For cross-platform consistency (default)
int logicalDPI = Display.getCurrent().getLogicalDPI();
// Always returns 96

// For native platform behavior (if desired)
Display display = Display.getDefault();
display.setLogicalDPI(display.getPhysicalDPI().y);
```

---

## Affected Stakeholders

### Application Developers
- **Benefit:** Can remove manual DPI compensation code
- **Action:** Test applications with fix, remove workarounds
- **Timeline:** After Solution 1 release

### End Users
- **Benefit:** Consistent appearance across platforms
- **Action:** None (transparent change)
- **Timeline:** Immediate after update

### SWT Maintainers
- **Benefit:** Clearer DPI semantics, better API
- **Action:** Implement and test solutions
- **Timeline:** Per roadmap above

---

## Frequently Asked Questions

### Q: Why not just document the difference?
**A:** Documentation doesn't solve the problem. Users still need to manually compensate, which breaks SWT's cross-platform promise.

### Q: Won't changing macOS DPI break existing applications?
**A:** No. Applications that use fonts will see IMPROVED consistency. Applications that depend on the specific DPI value are already broken (macOS fonts appear smaller).

### Q: What about Retina displays?
**A:** This fix is orthogonal to HiDPI. The backing scale factor is separate from the logical DPI. Retina displays will continue to work correctly.

### Q: What about printing?
**A:** Solution 1 may affect printing if code depends on `getScreenDPI()` for physical measurements. Solution 2 avoids this by keeping `getScreenDPI()` accurate. Solution 3 provides separate APIs for logical vs physical DPI.

### Q: Why 96 DPI instead of 72 DPI?
**A:** 96 DPI is the de facto standard for desktop computing (Windows, Linux). Changing all platforms to 72 DPI would break more applications and doesn't align with industry standards.

### Q: Can applications opt into native DPI behavior?
**A:** With Solution 3 (Configuration API), yes. Applications can set logical DPI to match physical DPI for native behavior.

---

## References

1. **Main Issue:** https://github.com/eclipse-platform/eclipse.platform.swt/issues/2925
2. **getDPI Deprecation:** https://github.com/eclipse-platform/eclipse.platform.swt/pull/2872
3. **Investigation Document:** `docs/font-size-inconsistency-investigation.md`
4. **Mitigation Strategies:** `docs/font-size-inconsistency-mitigations.md`
5. **Test Snippet:** `examples/.../Snippet_FontConsistencyTest.java`

---

## Conclusion

The font size inconsistency is a **design issue** caused by SWT's implicit 96 DPI assumption not being applied consistently across platforms. The **recommended fix** is to normalize macOS to 96 DPI (Solution 1) for immediate relief, followed by proper API enhancements (Solution 3) for long-term flexibility.

**Key Takeaways:**
1. ✓ Root cause identified: DPI baseline mismatch
2. ✓ Solutions proposed: 4 options from quick fix to comprehensive API
3. ✓ Testing strategy defined: Unit, visual, and integration tests
4. ✓ Migration path clear: Minimal to no changes for applications
5. ✓ Timeline estimated: 1-2 weeks for quick fix, 1-2 months for complete solution

**Next Steps:**
1. Review findings with SWT team
2. Select preferred solution(s)
3. Implement and test
4. Release and monitor feedback

---

**Document Version:** 1.0  
**Last Updated:** January 6, 2026  
**Authors:** GitHub Copilot Investigation (Issue #2925)
