// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMULTIDRAWELEMENTSEXTPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1, int x2, jdk.incubator.foreign.MemoryAddress x3, int x4);
    static NativeSymbol allocate(PFNGLMULTIDRAWELEMENTSEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTIDRAWELEMENTSEXTPROC.class, fi, constants$649.PFNGLMULTIDRAWELEMENTSEXTPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;I)V", scope);
    }
    static PFNGLMULTIDRAWELEMENTSEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMULTIDRAWELEMENTSEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, jdk.incubator.foreign.MemoryAddress x1, int x2, jdk.incubator.foreign.MemoryAddress x3, int x4) -> {
            try {
                constants$649.PFNGLMULTIDRAWELEMENTSEXTPROC$MH.invokeExact(symbol, x0, (jdk.incubator.foreign.Addressable)x1, x2, (jdk.incubator.foreign.Addressable)x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


