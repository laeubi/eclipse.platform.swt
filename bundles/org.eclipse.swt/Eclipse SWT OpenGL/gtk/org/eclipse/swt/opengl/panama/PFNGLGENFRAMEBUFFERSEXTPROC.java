// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGENFRAMEBUFFERSEXTPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static NativeSymbol allocate(PFNGLGENFRAMEBUFFERSEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGENFRAMEBUFFERSEXTPROC.class, fi, constants$629.PFNGLGENFRAMEBUFFERSEXTPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGENFRAMEBUFFERSEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGENFRAMEBUFFERSEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$629.PFNGLGENFRAMEBUFFERSEXTPROC$MH.invokeExact(symbol, x0, (jdk.incubator.foreign.Addressable)x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


