// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLGETNPIXELMAPUSVPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(PFNGLGETNPIXELMAPUSVPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLGETNPIXELMAPUSVPROC.class, fi, constants$309.PFNGLGETNPIXELMAPUSVPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLGETNPIXELMAPUSVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETNPIXELMAPUSVPROC.class, fi, constants$309.PFNGLGETNPIXELMAPUSVPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETNPIXELMAPUSVPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$309.PFNGLGETNPIXELMAPUSVPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


