// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLBLENDFUNCIPROC {

    void apply(int x0, int x1, int x2);
    static MemoryAddress allocate(PFNGLBLENDFUNCIPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLBLENDFUNCIPROC.class, fi, constants$206.PFNGLBLENDFUNCIPROC$FUNC, "(III)V");
    }
    static MemoryAddress allocate(PFNGLBLENDFUNCIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBLENDFUNCIPROC.class, fi, constants$206.PFNGLBLENDFUNCIPROC$FUNC, "(III)V", scope);
    }
    static PFNGLBLENDFUNCIPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2) -> {
            try {
                constants$206.PFNGLBLENDFUNCIPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


