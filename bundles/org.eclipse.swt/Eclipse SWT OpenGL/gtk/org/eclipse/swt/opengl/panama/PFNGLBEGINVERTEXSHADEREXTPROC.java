// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLBEGINVERTEXSHADEREXTPROC {

    void apply();
    static MemoryAddress allocate(PFNGLBEGINVERTEXSHADEREXTPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLBEGINVERTEXSHADEREXTPROC.class, fi, constants$683.PFNGLBEGINVERTEXSHADEREXTPROC$FUNC, "()V");
    }
    static MemoryAddress allocate(PFNGLBEGINVERTEXSHADEREXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBEGINVERTEXSHADEREXTPROC.class, fi, constants$683.PFNGLBEGINVERTEXSHADEREXTPROC$FUNC, "()V", scope);
    }
    static PFNGLBEGINVERTEXSHADEREXTPROC ofAddress(MemoryAddress addr) {
        return () -> {
            try {
                constants$683.PFNGLBEGINVERTEXSHADEREXTPROC$MH.invokeExact((Addressable)addr);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


