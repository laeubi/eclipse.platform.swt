// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLPROGRAMUNIFORM4DPROC {

    void apply(int x0, int x1, double x2, double x3, double x4, double x5);
    static MemoryAddress allocate(PFNGLPROGRAMUNIFORM4DPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM4DPROC.class, fi, constants$235.PFNGLPROGRAMUNIFORM4DPROC$FUNC, "(IIDDDD)V");
    }
    static MemoryAddress allocate(PFNGLPROGRAMUNIFORM4DPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM4DPROC.class, fi, constants$235.PFNGLPROGRAMUNIFORM4DPROC$FUNC, "(IIDDDD)V", scope);
    }
    static PFNGLPROGRAMUNIFORM4DPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, double x2, double x3, double x4, double x5) -> {
            try {
                constants$235.PFNGLPROGRAMUNIFORM4DPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4, x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


