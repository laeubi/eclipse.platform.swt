// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5, int x6, jdk.incubator.foreign.MemoryAddress x7);
    static NativeSymbol allocate(PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC.class, fi, constants$568.PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC$FUNC, "(IIIIIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, int x5, int x6, jdk.incubator.foreign.MemoryAddress x7) -> {
            try {
                constants$568.PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, x6, (jdk.incubator.foreign.Addressable)x7);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


