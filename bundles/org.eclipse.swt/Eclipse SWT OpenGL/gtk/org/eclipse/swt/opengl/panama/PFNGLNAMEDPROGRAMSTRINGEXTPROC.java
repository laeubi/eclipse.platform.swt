// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLNAMEDPROGRAMSTRINGEXTPROC {

    void apply(int x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4);
    static MemoryAddress allocate(PFNGLNAMEDPROGRAMSTRINGEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLNAMEDPROGRAMSTRINGEXTPROC.class, fi, constants$592.PFNGLNAMEDPROGRAMSTRINGEXTPROC$FUNC, "(IIIILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLNAMEDPROGRAMSTRINGEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLNAMEDPROGRAMSTRINGEXTPROC.class, fi, constants$592.PFNGLNAMEDPROGRAMSTRINGEXTPROC$FUNC, "(IIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLNAMEDPROGRAMSTRINGEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4) -> {
            try {
                constants$592.PFNGLNAMEDPROGRAMSTRINGEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


