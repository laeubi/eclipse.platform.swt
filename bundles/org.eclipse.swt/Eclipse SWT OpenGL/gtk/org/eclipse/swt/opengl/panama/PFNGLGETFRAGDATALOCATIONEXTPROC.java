// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLGETFRAGDATALOCATIONEXTPROC {

    int apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static MemoryAddress allocate(PFNGLGETFRAGDATALOCATIONEXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLGETFRAGDATALOCATIONEXTPROC.class, fi, constants$633.PFNGLGETFRAGDATALOCATIONEXTPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)I");
    }
    static MemoryAddress allocate(PFNGLGETFRAGDATALOCATIONEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETFRAGDATALOCATIONEXTPROC.class, fi, constants$633.PFNGLGETFRAGDATALOCATIONEXTPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)I", scope);
    }
    static PFNGLGETFRAGDATALOCATIONEXTPROC ofAddress(MemoryAddress addr) {
        return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                return (int)constants$633.PFNGLGETFRAGDATALOCATIONEXTPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


