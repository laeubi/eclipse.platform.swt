// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLVERTEXATTRIBL4DEXTPROC {

    void apply(int x0, double x1, double x2, double x3, double x4);
    static MemoryAddress allocate(PFNGLVERTEXATTRIBL4DEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIBL4DEXTPROC.class, fi, constants$680.PFNGLVERTEXATTRIBL4DEXTPROC$FUNC, "(IDDDD)V");
    }
    static MemoryAddress allocate(PFNGLVERTEXATTRIBL4DEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIBL4DEXTPROC.class, fi, constants$680.PFNGLVERTEXATTRIBL4DEXTPROC$FUNC, "(IDDDD)V", scope);
    }
    static PFNGLVERTEXATTRIBL4DEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, double x1, double x2, double x3, double x4) -> {
            try {
                constants$680.PFNGLVERTEXATTRIBL4DEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


