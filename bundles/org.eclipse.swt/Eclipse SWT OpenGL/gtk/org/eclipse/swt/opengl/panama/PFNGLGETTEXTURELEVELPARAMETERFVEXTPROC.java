// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC {

    void apply(int x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4);
    static MemoryAddress allocate(PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC.class, fi, constants$547.PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC$FUNC, "(IIIILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC.class, fi, constants$547.PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC$FUNC, "(IIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4) -> {
            try {
                constants$547.PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


