// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLIMAGETRANSFORMPARAMETERFVHPPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(PFNGLIMAGETRANSFORMPARAMETERFVHPPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLIMAGETRANSFORMPARAMETERFVHPPROC.class, fi, constants$701.PFNGLIMAGETRANSFORMPARAMETERFVHPPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLIMAGETRANSFORMPARAMETERFVHPPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLIMAGETRANSFORMPARAMETERFVHPPROC.class, fi, constants$701.PFNGLIMAGETRANSFORMPARAMETERFVHPPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLIMAGETRANSFORMPARAMETERFVHPPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$701.PFNGLIMAGETRANSFORMPARAMETERFVHPPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


