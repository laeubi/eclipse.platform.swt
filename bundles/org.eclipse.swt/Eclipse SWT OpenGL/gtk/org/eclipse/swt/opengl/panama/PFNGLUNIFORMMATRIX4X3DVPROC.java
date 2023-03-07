// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLUNIFORMMATRIX4X3DVPROC {

    void apply(int x0, int x1, byte x2, jdk.incubator.foreign.MemoryAddress x3);
    static NativeSymbol allocate(PFNGLUNIFORMMATRIX4X3DVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORMMATRIX4X3DVPROC.class, fi, constants$212.PFNGLUNIFORMMATRIX4X3DVPROC$FUNC, "(IIBLjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLUNIFORMMATRIX4X3DVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLUNIFORMMATRIX4X3DVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, byte x2, jdk.incubator.foreign.MemoryAddress x3) -> {
            try {
                constants$212.PFNGLUNIFORMMATRIX4X3DVPROC$MH.invokeExact(symbol, x0, x1, x2, (jdk.incubator.foreign.Addressable)x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


