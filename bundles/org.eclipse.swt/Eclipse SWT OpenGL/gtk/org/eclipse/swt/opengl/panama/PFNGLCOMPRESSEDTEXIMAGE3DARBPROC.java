// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOMPRESSEDTEXIMAGE3DARBPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, jdk.incubator.foreign.MemoryAddress x8);
    static NativeSymbol allocate(PFNGLCOMPRESSEDTEXIMAGE3DARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOMPRESSEDTEXIMAGE3DARBPROC.class, fi, constants$375.PFNGLCOMPRESSEDTEXIMAGE3DARBPROC$FUNC, "(IIIIIIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLCOMPRESSEDTEXIMAGE3DARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOMPRESSEDTEXIMAGE3DARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, jdk.incubator.foreign.MemoryAddress x8) -> {
            try {
                constants$375.PFNGLCOMPRESSEDTEXIMAGE3DARBPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, x6, x7, (jdk.incubator.foreign.Addressable)x8);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


