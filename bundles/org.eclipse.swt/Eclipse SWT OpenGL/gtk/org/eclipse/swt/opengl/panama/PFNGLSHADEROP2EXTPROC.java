// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLSHADEROP2EXTPROC {

    void apply(int x0, int x1, int x2, int x3);
    static MemoryAddress allocate(PFNGLSHADEROP2EXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLSHADEROP2EXTPROC.class, fi, constants$685.PFNGLSHADEROP2EXTPROC$FUNC, "(IIII)V");
    }
    static MemoryAddress allocate(PFNGLSHADEROP2EXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSHADEROP2EXTPROC.class, fi, constants$685.PFNGLSHADEROP2EXTPROC$FUNC, "(IIII)V", scope);
    }
    static PFNGLSHADEROP2EXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3) -> {
            try {
                constants$685.PFNGLSHADEROP2EXTPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


