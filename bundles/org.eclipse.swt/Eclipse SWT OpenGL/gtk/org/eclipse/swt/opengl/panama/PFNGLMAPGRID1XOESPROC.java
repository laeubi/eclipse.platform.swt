// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMAPGRID1XOESPROC {

    void apply(int x0, int x1, int x2);
    static NativeSymbol allocate(PFNGLMAPGRID1XOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMAPGRID1XOESPROC.class, fi, constants$435.PFNGLMAPGRID1XOESPROC$FUNC, "(III)V", scope);
    }
    static PFNGLMAPGRID1XOESPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMAPGRID1XOESPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2) -> {
            try {
                constants$435.PFNGLMAPGRID1XOESPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


