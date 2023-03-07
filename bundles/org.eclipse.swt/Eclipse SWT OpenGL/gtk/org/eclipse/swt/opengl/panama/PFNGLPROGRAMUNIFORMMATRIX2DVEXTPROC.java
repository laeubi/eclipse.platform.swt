// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC {

    void apply(int x0, int x1, int x2, byte x3, jdk.incubator.foreign.MemoryAddress x4);
    static MemoryAddress allocate(PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC.class, fi, constants$614.PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC$FUNC, "(IIIBLjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC.class, fi, constants$614.PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC$FUNC, "(IIIBLjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, byte x3, jdk.incubator.foreign.MemoryAddress x4) -> {
            try {
                constants$614.PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


