// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLUNIFORM2I64NVPROC {

    void apply(int x0, long x1, long x2);
    static MemoryAddress allocate(PFNGLUNIFORM2I64NVPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORM2I64NVPROC.class, fi, constants$457.PFNGLUNIFORM2I64NVPROC$FUNC, "(IJJ)V");
    }
    static MemoryAddress allocate(PFNGLUNIFORM2I64NVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORM2I64NVPROC.class, fi, constants$457.PFNGLUNIFORM2I64NVPROC$FUNC, "(IJJ)V", scope);
    }
    static PFNGLUNIFORM2I64NVPROC ofAddress(MemoryAddress addr) {
        return (int x0, long x1, long x2) -> {
            try {
                constants$457.PFNGLUNIFORM2I64NVPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


