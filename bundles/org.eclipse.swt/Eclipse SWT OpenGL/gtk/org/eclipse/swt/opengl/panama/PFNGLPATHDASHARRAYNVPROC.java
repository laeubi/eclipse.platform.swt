// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPATHDASHARRAYNVPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static NativeSymbol allocate(PFNGLPATHDASHARRAYNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPATHDASHARRAYNVPROC.class, fi, constants$786.PFNGLPATHDASHARRAYNVPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLPATHDASHARRAYNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPATHDASHARRAYNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$786.PFNGLPATHDASHARRAYNVPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


