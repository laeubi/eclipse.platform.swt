// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLGETDETAILTEXFUNCSGISPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static MemoryAddress allocate(PFNGLGETDETAILTEXFUNCSGISPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLGETDETAILTEXFUNCSGISPROC.class, fi, constants$874.PFNGLGETDETAILTEXFUNCSGISPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLGETDETAILTEXFUNCSGISPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETDETAILTEXFUNCSGISPROC.class, fi, constants$874.PFNGLGETDETAILTEXFUNCSGISPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETDETAILTEXFUNCSGISPROC ofAddress(MemoryAddress addr) {
        return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$874.PFNGLGETDETAILTEXFUNCSGISPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


