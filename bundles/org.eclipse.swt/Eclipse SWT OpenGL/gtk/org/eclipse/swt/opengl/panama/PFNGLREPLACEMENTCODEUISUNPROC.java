// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLREPLACEMENTCODEUISUNPROC {

    void apply(int x0);
    static MemoryAddress allocate(PFNGLREPLACEMENTCODEUISUNPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLREPLACEMENTCODEUISUNPROC.class, fi, constants$903.PFNGLREPLACEMENTCODEUISUNPROC$FUNC, "(I)V");
    }
    static MemoryAddress allocate(PFNGLREPLACEMENTCODEUISUNPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLREPLACEMENTCODEUISUNPROC.class, fi, constants$903.PFNGLREPLACEMENTCODEUISUNPROC$FUNC, "(I)V", scope);
    }
    static PFNGLREPLACEMENTCODEUISUNPROC ofAddress(MemoryAddress addr) {
        return (int x0) -> {
            try {
                constants$903.PFNGLREPLACEMENTCODEUISUNPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


