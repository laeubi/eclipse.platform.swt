// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLUNIFORMUI64NVPROC {

    void apply(int x0, long x1);
    static NativeSymbol allocate(PFNGLUNIFORMUI64NVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORMUI64NVPROC.class, fi, constants$815.PFNGLUNIFORMUI64NVPROC$FUNC, "(IJ)V", scope);
    }
    static PFNGLUNIFORMUI64NVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLUNIFORMUI64NVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, long x1) -> {
            try {
                constants$815.PFNGLUNIFORMUI64NVPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


