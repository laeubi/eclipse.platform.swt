// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLFOGXOESPROC {

    void apply(int x0, int x1);
    static MemoryAddress allocate(PFNGLFOGXOESPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLFOGXOESPROC.class, fi, constants$416.PFNGLFOGXOESPROC$FUNC, "(II)V");
    }
    static MemoryAddress allocate(PFNGLFOGXOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLFOGXOESPROC.class, fi, constants$416.PFNGLFOGXOESPROC$FUNC, "(II)V", scope);
    }
    static PFNGLFOGXOESPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1) -> {
            try {
                constants$416.PFNGLFOGXOESPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


