// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLEDGEFLAGPOINTEREXTPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(PFNGLEDGEFLAGPOINTEREXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLEDGEFLAGPOINTEREXTPROC.class, fi, constants$677.PFNGLEDGEFLAGPOINTEREXTPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLEDGEFLAGPOINTEREXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLEDGEFLAGPOINTEREXTPROC.class, fi, constants$677.PFNGLEDGEFLAGPOINTEREXTPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLEDGEFLAGPOINTEREXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$677.PFNGLEDGEFLAGPOINTEREXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


