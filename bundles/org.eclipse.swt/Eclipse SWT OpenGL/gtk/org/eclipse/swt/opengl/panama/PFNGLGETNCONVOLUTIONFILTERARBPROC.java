// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLGETNCONVOLUTIONFILTERARBPROC {

    void apply(int x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4);
    static MemoryAddress allocate(PFNGLGETNCONVOLUTIONFILTERARBPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLGETNCONVOLUTIONFILTERARBPROC.class, fi, constants$356.PFNGLGETNCONVOLUTIONFILTERARBPROC$FUNC, "(IIIILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLGETNCONVOLUTIONFILTERARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETNCONVOLUTIONFILTERARBPROC.class, fi, constants$356.PFNGLGETNCONVOLUTIONFILTERARBPROC$FUNC, "(IIIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETNCONVOLUTIONFILTERARBPROC ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4) -> {
            try {
                constants$356.PFNGLGETNCONVOLUTIONFILTERARBPROC$MH.invokeExact((Addressable)addr, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


