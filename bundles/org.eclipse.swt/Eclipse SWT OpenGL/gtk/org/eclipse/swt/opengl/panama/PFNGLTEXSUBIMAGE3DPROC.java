// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLTEXSUBIMAGE3DPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9, jdk.incubator.foreign.MemoryAddress x10);
    static NativeSymbol allocate(PFNGLTEXSUBIMAGE3DPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLTEXSUBIMAGE3DPROC.class, fi, constants$57.PFNGLTEXSUBIMAGE3DPROC$FUNC, "(IIIIIIIIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLTEXSUBIMAGE3DPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLTEXSUBIMAGE3DPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9, jdk.incubator.foreign.MemoryAddress x10) -> {
            try {
                constants$57.PFNGLTEXSUBIMAGE3DPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, (jdk.incubator.foreign.Addressable)x10);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


