// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC {

    void apply(int x0, int x1, int x2, int x3, long x4, long x5, long x6);
    static MemoryAddress allocate(PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC.class, fi, constants$751.PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC$FUNC, "(IIIIJJJ)V");
    }
    static MemoryAddress allocate(PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC.class, fi, constants$751.PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC$FUNC, "(IIIIJJJ)V", scope);
    }
    static PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3, long x4, long x5, long x6) -> {
            try {
                constants$751.PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4, x5, x6);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


