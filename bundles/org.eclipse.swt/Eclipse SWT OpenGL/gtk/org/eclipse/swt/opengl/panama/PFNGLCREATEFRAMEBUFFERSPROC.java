// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLCREATEFRAMEBUFFERSPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static MemoryAddress allocate(PFNGLCREATEFRAMEBUFFERSPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLCREATEFRAMEBUFFERSPROC.class, fi, constants$278.PFNGLCREATEFRAMEBUFFERSPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLCREATEFRAMEBUFFERSPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCREATEFRAMEBUFFERSPROC.class, fi, constants$278.PFNGLCREATEFRAMEBUFFERSPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLCREATEFRAMEBUFFERSPROC ofAddress(MemoryAddress addr) {
        return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$278.PFNGLCREATEFRAMEBUFFERSPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


