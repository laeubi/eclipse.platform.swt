// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLPROGRAMUNIFORM2UIEXTPROC {

    void apply(int x0, int x1, int x2, int x3);
    static MemoryAddress allocate(PFNGLPROGRAMUNIFORM2UIEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM2UIEXTPROC.class, fi, constants$585.PFNGLPROGRAMUNIFORM2UIEXTPROC$FUNC, "(IIII)V");
    }
    static MemoryAddress allocate(PFNGLPROGRAMUNIFORM2UIEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM2UIEXTPROC.class, fi, constants$585.PFNGLPROGRAMUNIFORM2UIEXTPROC$FUNC, "(IIII)V", scope);
    }
    static PFNGLPROGRAMUNIFORM2UIEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3) -> {
            try {
                constants$585.PFNGLPROGRAMUNIFORM2UIEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


