// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLSECONDARYCOLORPOINTERLISTIBMPROC {

    void apply(int x0, int x1, int x2, jdk.incubator.foreign.MemoryAddress x3, int x4);
    static MemoryAddress allocate(PFNGLSECONDARYCOLORPOINTERLISTIBMPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLSECONDARYCOLORPOINTERLISTIBMPROC.class, fi, constants$703.PFNGLSECONDARYCOLORPOINTERLISTIBMPROC$FUNC, "(IIILjdk/incubator/foreign/MemoryAddress;I)V");
    }
    static MemoryAddress allocate(PFNGLSECONDARYCOLORPOINTERLISTIBMPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSECONDARYCOLORPOINTERLISTIBMPROC.class, fi, constants$703.PFNGLSECONDARYCOLORPOINTERLISTIBMPROC$FUNC, "(IIILjdk/incubator/foreign/MemoryAddress;I)V", scope);
    }
    static PFNGLSECONDARYCOLORPOINTERLISTIBMPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, jdk.incubator.foreign.MemoryAddress x3, int x4) -> {
            try {
                constants$703.PFNGLSECONDARYCOLORPOINTERLISTIBMPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


