// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLUNIFORMBLOCKBINDINGPROC {

    void apply(int x0, int x1, int x2);
    static MemoryAddress allocate(PFNGLUNIFORMBLOCKBINDINGPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORMBLOCKBINDINGPROC.class, fi, constants$178.PFNGLUNIFORMBLOCKBINDINGPROC$FUNC, "(III)V");
    }
    static MemoryAddress allocate(PFNGLUNIFORMBLOCKBINDINGPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORMBLOCKBINDINGPROC.class, fi, constants$178.PFNGLUNIFORMBLOCKBINDINGPROC$FUNC, "(III)V", scope);
    }
    static PFNGLUNIFORMBLOCKBINDINGPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2) -> {
            try {
                constants$178.PFNGLUNIFORMBLOCKBINDINGPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


