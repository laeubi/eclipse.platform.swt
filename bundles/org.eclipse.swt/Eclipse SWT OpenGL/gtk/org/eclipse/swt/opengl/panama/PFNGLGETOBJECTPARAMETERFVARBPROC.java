// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLGETOBJECTPARAMETERFVARBPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(PFNGLGETOBJECTPARAMETERFVARBPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLGETOBJECTPARAMETERFVARBPROC.class, fi, constants$368.PFNGLGETOBJECTPARAMETERFVARBPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLGETOBJECTPARAMETERFVARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETOBJECTPARAMETERFVARBPROC.class, fi, constants$368.PFNGLGETOBJECTPARAMETERFVARBPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETOBJECTPARAMETERFVARBPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$368.PFNGLGETOBJECTPARAMETERFVARBPROC$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


