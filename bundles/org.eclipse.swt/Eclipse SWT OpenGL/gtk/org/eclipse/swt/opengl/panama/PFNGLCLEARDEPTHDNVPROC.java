// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLCLEARDEPTHDNVPROC {

    void apply(double x0);
    static MemoryAddress allocate(PFNGLCLEARDEPTHDNVPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLCLEARDEPTHDNVPROC.class, fi, constants$737.PFNGLCLEARDEPTHDNVPROC$FUNC, "(D)V");
    }
    static MemoryAddress allocate(PFNGLCLEARDEPTHDNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCLEARDEPTHDNVPROC.class, fi, constants$737.PFNGLCLEARDEPTHDNVPROC$FUNC, "(D)V", scope);
    }
    static PFNGLCLEARDEPTHDNVPROC ofAddress(MemoryAddress addr) {
        return (double x0) -> {
            try {
                constants$737.PFNGLCLEARDEPTHDNVPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


