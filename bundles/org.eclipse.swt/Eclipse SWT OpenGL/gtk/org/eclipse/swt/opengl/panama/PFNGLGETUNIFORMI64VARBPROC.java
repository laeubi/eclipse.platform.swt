// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGETUNIFORMI64VARBPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static NativeSymbol allocate(PFNGLGETUNIFORMI64VARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETUNIFORMI64VARBPROC.class, fi, constants$337.PFNGLGETUNIFORMI64VARBPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETUNIFORMI64VARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGETUNIFORMI64VARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$337.PFNGLGETUNIFORMI64VARBPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


