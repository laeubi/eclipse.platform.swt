// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLMATRIXLOAD3X3FNVPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static MemoryAddress allocate(PFNGLMATRIXLOAD3X3FNVPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLMATRIXLOAD3X3FNVPROC.class, fi, constants$794.PFNGLMATRIXLOAD3X3FNVPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLMATRIXLOAD3X3FNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMATRIXLOAD3X3FNVPROC.class, fi, constants$794.PFNGLMATRIXLOAD3X3FNVPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLMATRIXLOAD3X3FNVPROC ofAddress(MemoryAddress addr) {
        return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$794.PFNGLMATRIXLOAD3X3FNVPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


