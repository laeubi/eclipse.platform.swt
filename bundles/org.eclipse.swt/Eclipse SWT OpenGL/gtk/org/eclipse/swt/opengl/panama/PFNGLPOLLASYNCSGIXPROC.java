// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPOLLASYNCSGIXPROC {

    int apply(jdk.incubator.foreign.MemoryAddress x0);
    static NativeSymbol allocate(PFNGLPOLLASYNCSGIXPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPOLLASYNCSGIXPROC.class, fi, constants$881.PFNGLPOLLASYNCSGIXPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)I", scope);
    }
    static PFNGLPOLLASYNCSGIXPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPOLLASYNCSGIXPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (jdk.incubator.foreign.MemoryAddress x0) -> {
            try {
                return (int)constants$881.PFNGLPOLLASYNCSGIXPROC$MH.invokeExact(symbol, (jdk.incubator.foreign.Addressable)x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


