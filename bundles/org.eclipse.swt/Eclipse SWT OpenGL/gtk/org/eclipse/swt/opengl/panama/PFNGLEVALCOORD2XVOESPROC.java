// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLEVALCOORD2XVOESPROC {

    void apply(jdk.incubator.foreign.MemoryAddress x0);
    static MemoryAddress allocate(PFNGLEVALCOORD2XVOESPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLEVALCOORD2XVOESPROC.class, fi, constants$430.PFNGLEVALCOORD2XVOESPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLEVALCOORD2XVOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLEVALCOORD2XVOESPROC.class, fi, constants$430.PFNGLEVALCOORD2XVOESPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLEVALCOORD2XVOESPROC ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0) -> {
            try {
                constants$430.PFNGLEVALCOORD2XVOESPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


