// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLMATRIXLOADIDENTITYEXTPROC {

    void apply(int x0);
    static MemoryAddress allocate(PFNGLMATRIXLOADIDENTITYEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLMATRIXLOADIDENTITYEXTPROC.class, fi, constants$538.PFNGLMATRIXLOADIDENTITYEXTPROC$FUNC, "(I)V");
    }
    static MemoryAddress allocate(PFNGLMATRIXLOADIDENTITYEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMATRIXLOADIDENTITYEXTPROC.class, fi, constants$538.PFNGLMATRIXLOADIDENTITYEXTPROC$FUNC, "(I)V", scope);
    }
    static PFNGLMATRIXLOADIDENTITYEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0) -> {
            try {
                constants$538.PFNGLMATRIXLOADIDENTITYEXTPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


