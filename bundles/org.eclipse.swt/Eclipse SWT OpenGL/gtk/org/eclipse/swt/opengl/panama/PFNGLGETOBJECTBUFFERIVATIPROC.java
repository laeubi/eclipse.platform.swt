// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLGETOBJECTBUFFERIVATIPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(PFNGLGETOBJECTBUFFERIVATIPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLGETOBJECTBUFFERIVATIPROC.class, fi, constants$498.PFNGLGETOBJECTBUFFERIVATIPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLGETOBJECTBUFFERIVATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETOBJECTBUFFERIVATIPROC.class, fi, constants$498.PFNGLGETOBJECTBUFFERIVATIPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETOBJECTBUFFERIVATIPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$498.PFNGLGETOBJECTBUFFERIVATIPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


