// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXWEIGHTFVEXTPROC {

    void apply(jdk.incubator.foreign.MemoryAddress x0);
    static NativeSymbol allocate(PFNGLVERTEXWEIGHTFVEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXWEIGHTFVEXTPROC.class, fi, constants$697.PFNGLVERTEXWEIGHTFVEXTPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLVERTEXWEIGHTFVEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXWEIGHTFVEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (jdk.incubator.foreign.MemoryAddress x0) -> {
            try {
                constants$697.PFNGLVERTEXWEIGHTFVEXTPROC$MH.invokeExact(symbol, (jdk.incubator.foreign.Addressable)x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


