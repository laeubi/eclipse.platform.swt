// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLVERTEXSTREAM2SATIPROC {

    void apply(int x0, short x1, short x2);
    static MemoryAddress allocate(PFNGLVERTEXSTREAM2SATIPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXSTREAM2SATIPROC.class, fi, constants$504.PFNGLVERTEXSTREAM2SATIPROC$FUNC, "(ISS)V");
    }
    static MemoryAddress allocate(PFNGLVERTEXSTREAM2SATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXSTREAM2SATIPROC.class, fi, constants$504.PFNGLVERTEXSTREAM2SATIPROC$FUNC, "(ISS)V", scope);
    }
    static PFNGLVERTEXSTREAM2SATIPROC ofAddress(MemoryAddress addr) {
        return (int x0, short x1, short x2) -> {
            try {
                constants$504.PFNGLVERTEXSTREAM2SATIPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


