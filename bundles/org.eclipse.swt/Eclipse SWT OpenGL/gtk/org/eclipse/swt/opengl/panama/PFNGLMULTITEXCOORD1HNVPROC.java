// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLMULTITEXCOORD1HNVPROC {

    void apply(int x0, short x1);
    static MemoryAddress allocate(PFNGLMULTITEXCOORD1HNVPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXCOORD1HNVPROC.class, fi, constants$767.PFNGLMULTITEXCOORD1HNVPROC$FUNC, "(IS)V");
    }
    static MemoryAddress allocate(PFNGLMULTITEXCOORD1HNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXCOORD1HNVPROC.class, fi, constants$767.PFNGLMULTITEXCOORD1HNVPROC$FUNC, "(IS)V", scope);
    }
    static PFNGLMULTITEXCOORD1HNVPROC ofAddress(MemoryAddress addr) {
        return (int x0, short x1) -> {
            try {
                constants$767.PFNGLMULTITEXCOORD1HNVPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


