// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLMULTITEXCOORD4XOESPROC {

    void apply(int x0, int x1, int x2, int x3, int x4);
    static MemoryAddress allocate(PFNGLMULTITEXCOORD4XOESPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXCOORD4XOESPROC.class, fi, constants$422.PFNGLMULTITEXCOORD4XOESPROC$FUNC, "(IIIII)V");
    }
    static MemoryAddress allocate(PFNGLMULTITEXCOORD4XOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXCOORD4XOESPROC.class, fi, constants$422.PFNGLMULTITEXCOORD4XOESPROC$FUNC, "(IIIII)V", scope);
    }
    static PFNGLMULTITEXCOORD4XOESPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3, int x4) -> {
            try {
                constants$422.PFNGLMULTITEXCOORD4XOESPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


