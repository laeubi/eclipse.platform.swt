// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2, int x3, int x4, int x5, int x6, int x7, jdk.incubator.foreign.MemoryAddress x8);
    static NativeSymbol allocate(PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC.class, fi, constants$796.PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;IIIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2, int x3, int x4, int x5, int x6, int x7, jdk.incubator.foreign.MemoryAddress x8) -> {
            try {
                constants$796.PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2, x3, x4, x5, x6, x7, (jdk.incubator.foreign.Addressable)x8);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


