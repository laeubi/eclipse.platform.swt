// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLENABLEVERTEXATTRIBARRAYPROC {

    void apply(int x0);
    static MemoryAddress allocate(PFNGLENABLEVERTEXATTRIBARRAYPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLENABLEVERTEXATTRIBARRAYPROC.class, fi, constants$118.PFNGLENABLEVERTEXATTRIBARRAYPROC$FUNC, "(I)V");
    }
    static MemoryAddress allocate(PFNGLENABLEVERTEXATTRIBARRAYPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLENABLEVERTEXATTRIBARRAYPROC.class, fi, constants$118.PFNGLENABLEVERTEXATTRIBARRAYPROC$FUNC, "(I)V", scope);
    }
    static PFNGLENABLEVERTEXATTRIBARRAYPROC ofAddress(MemoryAddress addr) {
        return (int x0) -> {
            try {
                constants$118.PFNGLENABLEVERTEXATTRIBARRAYPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


