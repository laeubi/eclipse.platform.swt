// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLVERTEXATTRIBDIVISORARBPROC {

    void apply(int x0, int x1);
    static MemoryAddress allocate(PFNGLVERTEXATTRIBDIVISORARBPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIBDIVISORARBPROC.class, fi, constants$344.PFNGLVERTEXATTRIBDIVISORARBPROC$FUNC, "(II)V");
    }
    static MemoryAddress allocate(PFNGLVERTEXATTRIBDIVISORARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIBDIVISORARBPROC.class, fi, constants$344.PFNGLVERTEXATTRIBDIVISORARBPROC$FUNC, "(II)V", scope);
    }
    static PFNGLVERTEXATTRIBDIVISORARBPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1) -> {
            try {
                constants$344.PFNGLVERTEXATTRIBDIVISORARBPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


