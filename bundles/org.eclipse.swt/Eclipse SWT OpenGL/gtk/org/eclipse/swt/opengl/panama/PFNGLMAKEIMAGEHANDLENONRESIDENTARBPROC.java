// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC {

    void apply(long x0);
    static MemoryAddress allocate(PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC.class, fi, constants$315.PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC$FUNC, "(J)V");
    }
    static MemoryAddress allocate(PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC.class, fi, constants$315.PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC$FUNC, "(J)V", scope);
    }
    static PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC ofAddress(MemoryAddress addr) {
        return (long x0) -> {
            try {
                constants$315.PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


