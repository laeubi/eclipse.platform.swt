// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLVERTEXATTRIB4NUBVARBPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static MemoryAddress allocate(PFNGLVERTEXATTRIB4NUBVARBPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIB4NUBVARBPROC.class, fi, constants$393.PFNGLVERTEXATTRIB4NUBVARBPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLVERTEXATTRIB4NUBVARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIB4NUBVARBPROC.class, fi, constants$393.PFNGLVERTEXATTRIB4NUBVARBPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLVERTEXATTRIB4NUBVARBPROC ofAddress(MemoryAddress addr) {
        return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$393.PFNGLVERTEXATTRIB4NUBVARBPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


