// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLBINDPROGRAMPIPELINEPROC {

    void apply(int x0);
    static MemoryAddress allocate(PFNGLBINDPROGRAMPIPELINEPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLBINDPROGRAMPIPELINEPROC.class, fi, constants$224.PFNGLBINDPROGRAMPIPELINEPROC$FUNC, "(I)V");
    }
    static MemoryAddress allocate(PFNGLBINDPROGRAMPIPELINEPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBINDPROGRAMPIPELINEPROC.class, fi, constants$224.PFNGLBINDPROGRAMPIPELINEPROC$FUNC, "(I)V", scope);
    }
    static PFNGLBINDPROGRAMPIPELINEPROC ofAddress(MemoryAddress addr) {
        return (int x0) -> {
            try {
                constants$224.PFNGLBINDPROGRAMPIPELINEPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


