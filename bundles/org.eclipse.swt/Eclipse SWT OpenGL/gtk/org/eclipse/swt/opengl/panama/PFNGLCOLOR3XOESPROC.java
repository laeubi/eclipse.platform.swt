// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLCOLOR3XOESPROC {

    void apply(int x0, int x1, int x2);
    static MemoryAddress allocate(PFNGLCOLOR3XOESPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLCOLOR3XOESPROC.class, fi, constants$427.PFNGLCOLOR3XOESPROC$FUNC, "(III)V");
    }
    static MemoryAddress allocate(PFNGLCOLOR3XOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOLOR3XOESPROC.class, fi, constants$427.PFNGLCOLOR3XOESPROC$FUNC, "(III)V", scope);
    }
    static PFNGLCOLOR3XOESPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2) -> {
            try {
                constants$427.PFNGLCOLOR3XOESPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


