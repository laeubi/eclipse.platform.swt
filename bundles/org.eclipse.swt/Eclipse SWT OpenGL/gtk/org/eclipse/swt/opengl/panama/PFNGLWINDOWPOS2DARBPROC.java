// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLWINDOWPOS2DARBPROC {

    void apply(double x0, double x1);
    static NativeSymbol allocate(PFNGLWINDOWPOS2DARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLWINDOWPOS2DARBPROC.class, fi, constants$401.PFNGLWINDOWPOS2DARBPROC$FUNC, "(DD)V", scope);
    }
    static PFNGLWINDOWPOS2DARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLWINDOWPOS2DARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (double x0, double x1) -> {
            try {
                constants$401.PFNGLWINDOWPOS2DARBPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


