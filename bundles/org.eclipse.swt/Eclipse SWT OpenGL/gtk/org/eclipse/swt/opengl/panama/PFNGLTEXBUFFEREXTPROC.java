// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLTEXBUFFEREXTPROC {

    void apply(int x0, int x1, int x2);
    static MemoryAddress allocate(PFNGLTEXBUFFEREXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLTEXBUFFEREXTPROC.class, fi, constants$669.PFNGLTEXBUFFEREXTPROC$FUNC, "(III)V");
    }
    static MemoryAddress allocate(PFNGLTEXBUFFEREXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLTEXBUFFEREXTPROC.class, fi, constants$669.PFNGLTEXBUFFEREXTPROC$FUNC, "(III)V", scope);
    }
    static PFNGLTEXBUFFEREXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2) -> {
            try {
                constants$669.PFNGLTEXBUFFEREXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


