// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMAPNAMEDBUFFERRANGEPROC {

    jdk.incubator.foreign.Addressable apply(int x0, long x1, long x2, int x3);
    static NativeSymbol allocate(PFNGLMAPNAMEDBUFFERRANGEPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMAPNAMEDBUFFERRANGEPROC.class, fi, constants$276.PFNGLMAPNAMEDBUFFERRANGEPROC$FUNC, "(IJJI)Ljdk/incubator/foreign/Addressable;", scope);
    }
    static PFNGLMAPNAMEDBUFFERRANGEPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMAPNAMEDBUFFERRANGEPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, long x1, long x2, int x3) -> {
            try {
                return (jdk.incubator.foreign.Addressable)(jdk.incubator.foreign.MemoryAddress)constants$276.PFNGLMAPNAMEDBUFFERRANGEPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


