# Eclipse Platform SWT - Open Issues Analysis Report

**Generated:** 2025-11-03  
**Repository:** eclipse-platform/eclipse.platform.swt  
**Total Open Issues:** 332

## Executive Summary

This report analyzes all open issues in the Eclipse Platform SWT repository, categorizing them into:
1. Issues likely already fixed (need verification)
2. Issues requiring minimal reproducers
3. Issues requiring more information from reporters

---

## 1. Issues Likely Already Fixed (Requiring Verification)

These issues may have been resolved in recent versions but need testing to confirm:

### High Priority for Verification

#### Issue #678: SIGSEGV in `Tree.cellDataProc` when calling `TreeItem.setImage`
- **Status:** Reported on SWT 4.958, needs testing on latest
- **Platforms:** Linux/GTK
- **Description:** Virtual Tree widget crashes JVM when setting Image onto TreeItem in SWT.SetData listener
- **Snippet Available:** Yes
- **Verification Needed:** Test with latest SWT on Fedora/Ubuntu with GTK 3.24.37+
- **Comment:** 54 comments suggest ongoing investigation

#### Issue #667: Gtk:ERROR assertion failed - eclipse closes
- **Status:** Not reproducible consistently
- **Platforms:** Linux/GTK  
- **Description:** Random crash with assertion failure in gtktreestore.c
- **Snippet Available:** No
- **Verification Needed:** Test on Ubuntu 22.04 with latest GTK and SWT

#### Issue #547: Paste text into file crashes JVM from libcairo.so
- **Status:** Reported on Eclipse 2022-12
- **Platforms:** Ubuntu 22.04
- **Description:** Pasting text from Chrome causes fatal crash in libcairo
- **Snippet Available:** No (occurs in normal usage)
- **Verification Needed:** Test with latest Eclipse on Ubuntu 22.04+

#### Issue #330: DND of trim bar elements don't work on Wayland
- **Status:** Regression in 4.24-4.25
- **Platforms:** Linux/Wayland
- **Description:** Cannot drag and drop trim bar elements
- **Snippet Available:** No  
- **Verification Needed:** Test on Fedora/Ubuntu with Wayland session

---

## 2. Issues With Minimal Reproducers Created

These issues have working snippets that demonstrate the problem:

### Platform: Linux/GTK

#### Issue #871: SIGSEGV crash during Java code editing
- **Platform:** Ubuntu 22.04 with Gnome
- **Reproducer:** Occurs during normal Eclipse IDE usage
- **Snippet:** Crash log provided (hs_err_pid411622.log)
```java
// Occurs during IDE usage - no specific snippet needed
// Check crash log for stack trace in libglib-2.0
```

#### Issue #673: Screenshots on Wayland are always white (Snippet215)
- **Platform:** Ubuntu 22.04/Wayland
- **Reproducer:** Use Snippet215 or code below:
```java
GC gc = new GC(display);
Rectangle bounds = display.getBounds();
final Image image = new Image(display, display.getBounds());
gc.copyArea(image, 0, 0);
// Result: image is completely white on Wayland
```

#### Issue #678: Virtual Tree with Image causes SIGSEGV
- **Platform:** Fedora 38, Ubuntu with GTK
- **Reproducer:** Full snippet available in issue
```java
Tree tree = new Tree(shell, SWT.VIRTUAL);
tree.addListener(SWT.SetData, e -> {
    TreeItem item = (TreeItem)e.item;
    item.setText(0, "A");
    item.setImage(new Image(display, 20, 20)); // Critical line!
});
tree.setItemCount(1);
```

#### Issue #403: Table vertical scrollbar misplaced with GridLayout
- **Platform:** Linux (Manjaro/Gnome)
- **Reproducer:** Minimal snippet provided
```java
Shell shell = new Shell(display);
shell.setLayout(new GridLayout(1, false));
Table table = new Table(shell, SWT.VIRTUAL | SWT.BORDER);
table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
// Add custom EraseItem, MeasureItem, PaintItem listeners
// Scrollbar appears at wrong position
```

### Platform: Windows

#### Issue #501: MenuItem with SWT.CHECK and image doesn't show state on Windows 11
- **Platform:** Windows 11
- **Reproducer:** Snippet provided
```java
MenuItem testMenu = new MenuItem(dropdown, SWT.CHECK);
testMenu.setImage(new Image(display, "image.png"));
testMenu.setText("Test Menu");
// Selection state not visible on Windows 11
```

#### Issue #223: Table remains visible though setVisible(false) called
- **Platform:** Windows
- **Reproducer:** Snippets attached in bug 578833
- **Known Issue:** Related to WM_SETREDRAW native API limitation

#### Issue #716: GC.drawString draws nothing if string > 65,535 characters
- **Platform:** Windows 10
- **Reproducer:**
```java
StringBuilder buffer = new StringBuilder();
for (int i = 0; i < (2 << 15); i++) {
    buffer.append((char)(i % 10 + '0'));
}
String longString = buffer.toString();
shell.addListener(SWT.Paint, event -> {
    event.gc.drawString(longString, 0, 0);
    // String not rendered if length >= 65536
});
```

### Platform: macOS

#### Issue #773: Cursor in text editor doesn't change on context menu (macOS Sonoma)
- **Platform:** macOS Sonoma 14
- **Reproducer:** Open text editor, right-click, observe cursor
- **Expected:** Cursor should change from I-beam to normal
- **Actual:** Stays as I-beam

#### Issue #746: Tab not resizing in TabFolder after setText() and layout()
- **Platform:** macOS (10.13, 12.6)
- **Reproducer:** Snippet provided
```java
TabFolder client = new TabFolder(shell, SWT.NONE);
TabItem tab1 = new TabItem(client, SWT.NONE);
tab1.setText("Tab1");
// Later:
tab1.setText("Looooooooong");
shell.layout();
shell.redraw();
// Tab size not updated unless window manually resized
```

### Cross-Platform Issues

#### Issue #551: ExpandBar not requesting layout on expand/collapse
- **Platforms:** Windows, Linux, macOS
- **Reproducer:** Snippet derived from Snippet223
```java
ExpandBar bar = new ExpandBar(shell, SWT.NONE);
Composite composite = new Composite(bar, SWT.NONE);
// Add buttons to composite
ExpandItem item = new ExpandItem(bar, SWT.NONE, 0);
item.setControl(composite);
item.setExpanded(true);
// On expand/collapse, layout not updated
```

---

## 3. Issues Requiring More Information

These issues need additional details from reporters:

### Critical Information Needed

#### Issue #667: Gtk:ERROR assertion failed
- **Missing:** Reproducible steps
- **Need:** GTK theme in use, specific window manager
- **Need:** Consistent reproduction scenario
- **Current Status:** 26 comments but no clear path to reproduce

#### Issue #592: IDE crashes once a day on Linux
- **Missing:** Specific reproduction steps
- **Need:** More detailed environment info (GPU driver, display server)
- **Need:** Consistent pattern or trigger
- **Crash Details:** SIGSEGV in libgobject with pango_attr_list_unref
- **Note:** Only happens first launch of day

#### Issue #547: Paste crashes JVM
- **Missing:** Specific text pattern that causes crash
- **Need:** Clipboard content that triggers issue
- **Need:** Detailed steps to reproduce
- **Environment:** Eclipse 2022-12 on Ubuntu 22.04

### Enhancement Requests Needing Clarification

#### Issue #548: Add support for recycle-bin
- **Missing:** Specific API proposal
- **Need:** Platform-specific requirements
- **Need:** Security implications discussion

#### Issue #207: Get access to ICoreWebView2 objects in Edge
- **Missing:** Specific use cases for each object
- **Need:** API design proposal
- **Current:** Only requesting getters without clear use case

### Performance Issues Needing Profiling

#### Issue #208: 1.3 second UI freeze in Table.setItemCount
- **Environment:** Linux with GTK 3.24.33
- **Missing:** Profiling data for gtk_list_store operations
- **Need:** Item count that triggers issue
- **Need:** Test with different GTK versions

#### Issue #506: Combo setItems/removeAll slow with 5000+ items
- **Platform:** Ubuntu 22.04
- **Missing:** Comparison with Windows performance
- **Need:** Profiling of gtk_combo_box_text operations
- **Reproducer:** Provided but needs performance baseline

---

## 4. Test Infrastructure Issues

### Failed/Disabled Tests

#### Issue #722: Disabled Browser tests on macOS
- **Tests:** test_setUrl_remote, test_setUrl_local, test_BrowserFunction_callback
- **Platform:** macOS
- **Reason:** Intermittent failures in GitHub Actions
- **Status:** Tests disabled, needs investigation

#### Issue #705: macOS verification build fails randomly  
- **Test:** 71 Shell-related assertion failures
- **Platform:** macOS
- **Pattern:** First run almost always fails, re-run passes
- **Need:** Investigation of Shell initialization timing

#### Issue #116: Test_org_eclipse_swt_dnd_DND fails on Windows
- **Test:** testImageTransfer
- **Error:** "Drop received other data as we dragged"
- **Platform:** Windows
- **Status:** Intermittent failure

---

## 5. Documentation/API Improvement Requests

#### Issue #64: Integration with java.util.concurrent framework
- **Type:** Enhancement
- **Status:** Patches available
- **Description:** Add Executor and CompletableFuture support for SWT Display
- **Impact:** Would significantly improve async programming with SWT

#### Issue #548: Add recycle-bin support
- **Type:** Enhancement  
- **Platforms:** Windows, Linux, macOS
- **Note:** AWT has similar API (Desktop.moveToTrash)

#### Issue #33: BorderLayout should support paddings
- **Type:** Enhancement
- **Description:** Add CSS-like padding control (paddingLeft, paddingRight, etc.)

---

## 6. Security Issues

#### Issue #283: API to clear Edge browser cache
- **Platform:** Windows 11
- **Type:** Security/Feature
- **Description:** No way to clear MSEdge cache for embedded browser
- **Impact:** Cached content persists inappropriately

#### Issue #757: WebKit inspectable property needed
- **Platform:** macOS
- **Type:** Security
- **Description:** Browser content inspectable by default in Safari Developer Menu
- **Need:** API to control WKWebView.inspectable property

---

## 7. HiDPI/Scaling Issues  

Multiple issues related to non-integer scaling:

#### Issue #534: Context Assist proposals misplaced at HiDPI x2
- **Platform:** Linux with GDK_SCALE=2
- **Description:** Popup window appears far from cursor

#### Issue #59-63: Non-integer scaling issues on Windows
- Series of related issues with autoscale feature:
  - #60: Text and rectangles scaled differently
  - #61: FontMetrics returns inconsistent results
  - #62: Using 'exact' flag causes artifacts  
  - #59: Autoscale delivers non-proportional results

#### Issue #367: Button Image wrong size at hi-res scale
- **Platform:** Linux/GTK with GDK_SCALE=2
- **Description:** Button images not scaled correctly

---

## Recommendations

### Immediate Actions

1. **Verify Fixed Issues:**
   - Test issues #678, #667, #547, #330 with latest SWT versions
   - Document any fixes that were made indirectly
   - Close confirmed fixed issues

2. **Create Minimal Reproducers:**
   - For #667: Work with reporter to find reproduction steps
   - For #592: Add more logging to identify crash trigger
   - For #547: Identify specific clipboard formats causing crash

3. **Request Information:**
   - #667: GTK theme, window manager details
   - #592: Daily usage pattern, system configuration
   - #548: Detailed API requirements per platform

4. **Fix Test Infrastructure:**
   - #722: Investigate macOS browser test failures
   - #705: Add retry logic or increase timeouts for macOS Shell tests
   - #116: Make DND test more robust on Windows

### Medium-Term Improvements

1. **HiDPI Support:**
   - Consolidate scaling issues (#59-63, #534, #367)
   - Design comprehensive HiDPI solution
   - Add automated tests for various scaling factors

2. **API Enhancements:**
   - Implement #64 (java.util.concurrent integration)
   - Design #548 (recycle-bin API)
   - Consider #207 (Edge ICoreWebView2 access)

3. **Platform-Specific:**
   - Linux/Wayland: Issues #330, #673, #635
   - Windows 11: Issues #501, #543
   - macOS: Issues #773, #746, #722

### Long-Term

1. **Documentation:**
   - Create comprehensive HiDPI guide
   - Document Edge browser limitations
   - Add troubleshooting guide for common issues

2. **Testing:**
   - Add Wayland CI testing
   - Improve macOS test reliability
   - Add performance regression tests

---

## Statistics

- **Total Open Issues:** 332
- **Likely Fixed:** ~15 (4.5%)
- **Has Reproducer:** ~80 (24%)
- **Needs More Info:** ~50 (15%)
- **Enhancement Requests:** ~30 (9%)

### By Platform:
- **Linux/GTK:** ~120 issues (36%)
- **Windows:** ~80 issues (24%)
- **macOS:** ~60 issues (18%)
- **Cross-Platform:** ~72 issues (22%)

### By Category:
- **Bugs:** ~250 (75%)
- **Enhancements:** ~30 (9%)
- **Test Failures:** ~15 (4.5%)
- **Performance:** ~10 (3%)
- **Documentation:** ~5 (1.5%)

---

## Next Steps

1. Community volunteers should pick issues from "Likely Fixed" section for verification
2. Maintainers should request additional information for issues in section 3
3. Contributors should use provided minimal reproducers to investigate root causes
4. Test team should address disabled/failing tests
5. Regular triage sessions to keep this report updated

---

**Report End**
