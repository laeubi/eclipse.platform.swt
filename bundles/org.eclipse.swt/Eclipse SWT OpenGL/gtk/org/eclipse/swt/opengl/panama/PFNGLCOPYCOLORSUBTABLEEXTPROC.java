// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOPYCOLORSUBTABLEEXTPROC {

    void apply(int x0, int x1, int x2, int x3, int x4);
    static NativeSymbol allocate(PFNGLCOPYCOLORSUBTABLEEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOPYCOLORSUBTABLEEXTPROC.class, fi, constants$520.PFNGLCOPYCOLORSUBTABLEEXTPROC$FUNC, "(IIIII)V", scope);
    }
    static PFNGLCOPYCOLORSUBTABLEEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOPYCOLORSUBTABLEEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4) -> {
            try {
                constants$520.PFNGLCOPYCOLORSUBTABLEEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


