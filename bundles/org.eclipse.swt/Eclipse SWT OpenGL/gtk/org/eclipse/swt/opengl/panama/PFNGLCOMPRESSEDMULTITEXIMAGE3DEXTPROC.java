// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, jdk.incubator.foreign.MemoryAddress x9);
    static MemoryAddress allocate(PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC.class, fi, constants$567.PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC$FUNC, "(IIIIIIIIILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC.class, fi, constants$567.PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC$FUNC, "(IIIIIIIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, jdk.incubator.foreign.MemoryAddress x9) -> {
            try {
                constants$567.PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4, x5, x6, x7, x8, x9);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


