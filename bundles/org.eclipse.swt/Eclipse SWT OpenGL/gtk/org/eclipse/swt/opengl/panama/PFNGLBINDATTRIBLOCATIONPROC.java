// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLBINDATTRIBLOCATIONPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(PFNGLBINDATTRIBLOCATIONPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLBINDATTRIBLOCATIONPROC.class, fi, constants$115.PFNGLBINDATTRIBLOCATIONPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLBINDATTRIBLOCATIONPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBINDATTRIBLOCATIONPROC.class, fi, constants$115.PFNGLBINDATTRIBLOCATIONPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLBINDATTRIBLOCATIONPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$115.PFNGLBINDATTRIBLOCATIONPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


