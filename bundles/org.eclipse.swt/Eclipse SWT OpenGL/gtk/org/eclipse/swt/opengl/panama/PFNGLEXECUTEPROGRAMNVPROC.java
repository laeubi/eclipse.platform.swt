// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLEXECUTEPROGRAMNVPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static NativeSymbol allocate(PFNGLEXECUTEPROGRAMNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLEXECUTEPROGRAMNVPROC.class, fi, constants$841.PFNGLEXECUTEPROGRAMNVPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLEXECUTEPROGRAMNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLEXECUTEPROGRAMNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$841.PFNGLEXECUTEPROGRAMNVPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


