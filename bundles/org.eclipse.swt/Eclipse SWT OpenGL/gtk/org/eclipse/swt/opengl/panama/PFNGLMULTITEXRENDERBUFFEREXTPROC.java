// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLMULTITEXRENDERBUFFEREXTPROC {

    void apply(int x0, int x1, int x2);
    static MemoryAddress allocate(PFNGLMULTITEXRENDERBUFFEREXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXRENDERBUFFEREXTPROC.class, fi, constants$602.PFNGLMULTITEXRENDERBUFFEREXTPROC$FUNC, "(III)V");
    }
    static MemoryAddress allocate(PFNGLMULTITEXRENDERBUFFEREXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXRENDERBUFFEREXTPROC.class, fi, constants$602.PFNGLMULTITEXRENDERBUFFEREXTPROC$FUNC, "(III)V", scope);
    }
    static PFNGLMULTITEXRENDERBUFFEREXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2) -> {
            try {
                constants$602.PFNGLMULTITEXRENDERBUFFEREXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


