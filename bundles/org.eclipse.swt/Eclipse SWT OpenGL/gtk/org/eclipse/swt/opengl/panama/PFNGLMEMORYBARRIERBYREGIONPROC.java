// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLMEMORYBARRIERBYREGIONPROC {

    void apply(int x0);
    static MemoryAddress allocate(PFNGLMEMORYBARRIERBYREGIONPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLMEMORYBARRIERBYREGIONPROC.class, fi, constants$304.PFNGLMEMORYBARRIERBYREGIONPROC$FUNC, "(I)V");
    }
    static MemoryAddress allocate(PFNGLMEMORYBARRIERBYREGIONPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMEMORYBARRIERBYREGIONPROC.class, fi, constants$304.PFNGLMEMORYBARRIERBYREGIONPROC$FUNC, "(I)V", scope);
    }
    static PFNGLMEMORYBARRIERBYREGIONPROC ofAddress(MemoryAddress addr) {
        return (int x0) -> {
            try {
                constants$304.PFNGLMEMORYBARRIERBYREGIONPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


