// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLBINDFRAGMENTSHADERATIPROC {

    void apply(int x0);
    static MemoryAddress allocate(PFNGLBINDFRAGMENTSHADERATIPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLBINDFRAGMENTSHADERATIPROC.class, fi, constants$490.PFNGLBINDFRAGMENTSHADERATIPROC$FUNC, "(I)V");
    }
    static MemoryAddress allocate(PFNGLBINDFRAGMENTSHADERATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBINDFRAGMENTSHADERATIPROC.class, fi, constants$490.PFNGLBINDFRAGMENTSHADERATIPROC$FUNC, "(I)V", scope);
    }
    static PFNGLBINDFRAGMENTSHADERATIPROC ofAddress(MemoryAddress addr) {
        return (int x0) -> {
            try {
                constants$490.PFNGLBINDFRAGMENTSHADERATIPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


