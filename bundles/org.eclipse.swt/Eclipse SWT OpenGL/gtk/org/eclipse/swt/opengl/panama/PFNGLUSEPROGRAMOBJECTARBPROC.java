// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLUSEPROGRAMOBJECTARBPROC {

    void apply(int x0);
    static MemoryAddress allocate(PFNGLUSEPROGRAMOBJECTARBPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLUSEPROGRAMOBJECTARBPROC.class, fi, constants$361.PFNGLUSEPROGRAMOBJECTARBPROC$FUNC, "(I)V");
    }
    static MemoryAddress allocate(PFNGLUSEPROGRAMOBJECTARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUSEPROGRAMOBJECTARBPROC.class, fi, constants$361.PFNGLUSEPROGRAMOBJECTARBPROC$FUNC, "(I)V", scope);
    }
    static PFNGLUSEPROGRAMOBJECTARBPROC ofAddress(MemoryAddress addr) {
        return (int x0) -> {
            try {
                constants$361.PFNGLUSEPROGRAMOBJECTARBPROC$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


