// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface PFNGLELEMENTPOINTERAPPLEPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static MemoryAddress allocate(PFNGLELEMENTPOINTERAPPLEPROC fi) {
        return RuntimeHelper.upcallStub(PFNGLELEMENTPOINTERAPPLEPROC.class, fi, constants$476.PFNGLELEMENTPOINTERAPPLEPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(PFNGLELEMENTPOINTERAPPLEPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLELEMENTPOINTERAPPLEPROC.class, fi, constants$476.PFNGLELEMENTPOINTERAPPLEPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLELEMENTPOINTERAPPLEPROC ofAddress(MemoryAddress addr) {
        return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$476.PFNGLELEMENTPOINTERAPPLEPROC$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


