// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLFRAMEBUFFERTEXTUREEXTPROC {

    void apply(int x0, int x1, int x2, int x3);
    static MemoryAddress allocate(PFNGLFRAMEBUFFERTEXTUREEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLFRAMEBUFFERTEXTUREEXTPROC.class, fi, constants$750.PFNGLFRAMEBUFFERTEXTUREEXTPROC$FUNC, "(IIII)V");
    }
    static MemoryAddress allocate(PFNGLFRAMEBUFFERTEXTUREEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLFRAMEBUFFERTEXTUREEXTPROC.class, fi, constants$750.PFNGLFRAMEBUFFERTEXTUREEXTPROC$FUNC, "(IIII)V", scope);
    }
    static PFNGLFRAMEBUFFERTEXTUREEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3) -> {
            try {
                constants$750.PFNGLFRAMEBUFFERTEXTUREEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


