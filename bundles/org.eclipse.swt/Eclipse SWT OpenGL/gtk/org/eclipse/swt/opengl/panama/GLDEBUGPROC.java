// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface GLDEBUGPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, jdk.incubator.foreign.MemoryAddress x5, jdk.incubator.foreign.MemoryAddress x6);
    static MemoryAddress allocate(GLDEBUGPROC fi) {
        return RuntimeHelper.upcallStub(GLDEBUGPROC.class, fi, constants$253.GLDEBUGPROC$FUNC, "(IIIIILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(GLDEBUGPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(GLDEBUGPROC.class, fi, constants$253.GLDEBUGPROC$FUNC, "(IIIIILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static GLDEBUGPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3, int x4, jdk.incubator.foreign.MemoryAddress x5, jdk.incubator.foreign.MemoryAddress x6) -> {
            try {
                constants$253.GLDEBUGPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4, x5, x6);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


