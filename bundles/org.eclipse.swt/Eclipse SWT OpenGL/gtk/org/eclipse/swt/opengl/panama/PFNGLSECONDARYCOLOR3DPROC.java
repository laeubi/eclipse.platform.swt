// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLSECONDARYCOLOR3DPROC {

    void apply(double x0, double x1, double x2);
    static MemoryAddress allocate(PFNGLSECONDARYCOLOR3DPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLSECONDARYCOLOR3DPROC.class, fi, constants$96.PFNGLSECONDARYCOLOR3DPROC$FUNC, "(DDD)V");
    }
    static MemoryAddress allocate(PFNGLSECONDARYCOLOR3DPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSECONDARYCOLOR3DPROC.class, fi, constants$96.PFNGLSECONDARYCOLOR3DPROC$FUNC, "(DDD)V", scope);
    }
    static PFNGLSECONDARYCOLOR3DPROC ofAddress(MemoryAddress addr) {
        return (double x0, double x1, double x2) -> {
            try {
                constants$96.PFNGLSECONDARYCOLOR3DPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


