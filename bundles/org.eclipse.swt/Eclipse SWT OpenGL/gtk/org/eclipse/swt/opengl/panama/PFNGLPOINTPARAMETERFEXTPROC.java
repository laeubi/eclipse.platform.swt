// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPOINTPARAMETERFEXTPROC {

    void apply(int x0, float x1);
    static NativeSymbol allocate(PFNGLPOINTPARAMETERFEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPOINTPARAMETERFEXTPROC.class, fi, constants$653.PFNGLPOINTPARAMETERFEXTPROC$FUNC, "(IF)V", scope);
    }
    static PFNGLPOINTPARAMETERFEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPOINTPARAMETERFEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, float x1) -> {
            try {
                constants$653.PFNGLPOINTPARAMETERFEXTPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


