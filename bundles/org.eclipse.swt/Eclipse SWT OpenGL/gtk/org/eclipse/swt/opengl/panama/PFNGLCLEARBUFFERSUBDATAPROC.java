// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCLEARBUFFERSUBDATAPROC {

    void apply(int x0, int x1, long x2, long x3, int x4, int x5, jdk.incubator.foreign.MemoryAddress x6);
    static NativeSymbol allocate(PFNGLCLEARBUFFERSUBDATAPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCLEARBUFFERSUBDATAPROC.class, fi, constants$254.PFNGLCLEARBUFFERSUBDATAPROC$FUNC, "(IIJJIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLCLEARBUFFERSUBDATAPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCLEARBUFFERSUBDATAPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, long x2, long x3, int x4, int x5, jdk.incubator.foreign.MemoryAddress x6) -> {
            try {
                constants$254.PFNGLCLEARBUFFERSUBDATAPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, (jdk.incubator.foreign.Addressable)x6);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


