// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLNAMEDBUFFERSUBDATAEXTPROC {

    void apply(int x0, long x1, long x2, jdk.incubator.foreign.MemoryAddress x3);
    static NativeSymbol allocate(PFNGLNAMEDBUFFERSUBDATAEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLNAMEDBUFFERSUBDATAEXTPROC.class, fi, constants$571.PFNGLNAMEDBUFFERSUBDATAEXTPROC$FUNC, "(IJJLjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLNAMEDBUFFERSUBDATAEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLNAMEDBUFFERSUBDATAEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, long x1, long x2, jdk.incubator.foreign.MemoryAddress x3) -> {
            try {
                constants$571.PFNGLNAMEDBUFFERSUBDATAEXTPROC$MH.invokeExact(symbol, x0, x1, x2, (jdk.incubator.foreign.Addressable)x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


