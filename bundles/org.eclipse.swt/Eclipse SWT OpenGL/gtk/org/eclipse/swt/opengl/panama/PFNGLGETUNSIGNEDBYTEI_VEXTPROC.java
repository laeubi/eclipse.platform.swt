// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLGETUNSIGNEDBYTEI_VEXTPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(PFNGLGETUNSIGNEDBYTEI_VEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLGETUNSIGNEDBYTEI_VEXTPROC.class, fi, constants$642.PFNGLGETUNSIGNEDBYTEI_VEXTPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLGETUNSIGNEDBYTEI_VEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETUNSIGNEDBYTEI_VEXTPROC.class, fi, constants$642.PFNGLGETUNSIGNEDBYTEI_VEXTPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETUNSIGNEDBYTEI_VEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$642.PFNGLGETUNSIGNEDBYTEI_VEXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


