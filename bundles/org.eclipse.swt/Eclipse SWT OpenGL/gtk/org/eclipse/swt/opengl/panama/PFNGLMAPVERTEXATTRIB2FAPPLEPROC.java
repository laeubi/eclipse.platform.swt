// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMAPVERTEXATTRIB2FAPPLEPROC {

    void apply(int x0, int x1, float x2, float x3, int x4, int x5, float x6, float x7, int x8, int x9, jdk.incubator.foreign.MemoryAddress x10);
    static NativeSymbol allocate(PFNGLMAPVERTEXATTRIB2FAPPLEPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMAPVERTEXATTRIB2FAPPLEPROC.class, fi, constants$487.PFNGLMAPVERTEXATTRIB2FAPPLEPROC$FUNC, "(IIFFIIFFIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLMAPVERTEXATTRIB2FAPPLEPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMAPVERTEXATTRIB2FAPPLEPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, float x2, float x3, int x4, int x5, float x6, float x7, int x8, int x9, jdk.incubator.foreign.MemoryAddress x10) -> {
            try {
                constants$487.PFNGLMAPVERTEXATTRIB2FAPPLEPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, (jdk.incubator.foreign.Addressable)x10);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


