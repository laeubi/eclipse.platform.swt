// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLBINDATTRIBLOCATIONARBPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(PFNGLBINDATTRIBLOCATIONARBPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLBINDATTRIBLOCATIONARBPROC.class, fi, constants$400.PFNGLBINDATTRIBLOCATIONARBPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLBINDATTRIBLOCATIONARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBINDATTRIBLOCATIONARBPROC.class, fi, constants$400.PFNGLBINDATTRIBLOCATIONARBPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLBINDATTRIBLOCATIONARBPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$400.PFNGLBINDATTRIBLOCATIONARBPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


