// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC {

    void apply(int x0, int x1, int x2, byte x3, jdk.incubator.foreign.MemoryAddress x4);
    static NativeSymbol allocate(PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC.class, fi, constants$241.PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC$FUNC, "(IIIBLjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, byte x3, jdk.incubator.foreign.MemoryAddress x4) -> {
            try {
                constants$241.PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC$MH.invokeExact(symbol, x0, x1, x2, x3, (jdk.incubator.foreign.Addressable)x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


