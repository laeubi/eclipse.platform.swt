// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLWINDOWPOS4FMESAPROC {

    void apply(float x0, float x1, float x2, float x3);
    static NativeSymbol allocate(PFNGLWINDOWPOS4FMESAPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLWINDOWPOS4FMESAPROC.class, fi, constants$718.PFNGLWINDOWPOS4FMESAPROC$FUNC, "(FFFF)V", scope);
    }
    static PFNGLWINDOWPOS4FMESAPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLWINDOWPOS4FMESAPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (float x0, float x1, float x2, float x3) -> {
            try {
                constants$718.PFNGLWINDOWPOS4FMESAPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


