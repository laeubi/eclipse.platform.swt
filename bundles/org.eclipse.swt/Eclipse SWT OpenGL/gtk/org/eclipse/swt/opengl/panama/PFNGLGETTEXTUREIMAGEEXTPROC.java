// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGETTEXTUREIMAGEEXTPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, jdk.incubator.foreign.MemoryAddress x5);
    static NativeSymbol allocate(PFNGLGETTEXTUREIMAGEEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETTEXTUREIMAGEEXTPROC.class, fi, constants$546.PFNGLGETTEXTUREIMAGEEXTPROC$FUNC, "(IIIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETTEXTUREIMAGEEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGETTEXTUREIMAGEEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, jdk.incubator.foreign.MemoryAddress x5) -> {
            try {
                constants$546.PFNGLGETTEXTUREIMAGEEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, (jdk.incubator.foreign.Addressable)x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


