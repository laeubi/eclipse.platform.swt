// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLVERTEXARRAYNORMALOFFSETEXTPROC {

    void apply(int x0, int x1, int x2, int x3, long x4);
    static MemoryAddress allocate(PFNGLVERTEXARRAYNORMALOFFSETEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXARRAYNORMALOFFSETEXTPROC.class, fi, constants$604.PFNGLVERTEXARRAYNORMALOFFSETEXTPROC$FUNC, "(IIIIJ)V");
    }
    static MemoryAddress allocate(PFNGLVERTEXARRAYNORMALOFFSETEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXARRAYNORMALOFFSETEXTPROC.class, fi, constants$604.PFNGLVERTEXARRAYNORMALOFFSETEXTPROC$FUNC, "(IIIIJ)V", scope);
    }
    static PFNGLVERTEXARRAYNORMALOFFSETEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3, long x4) -> {
            try {
                constants$604.PFNGLVERTEXARRAYNORMALOFFSETEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


