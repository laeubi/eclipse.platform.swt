// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLFOGCOORDDVEXTPROC {

    void apply(jdk.incubator.foreign.MemoryAddress x0);
    static NativeSymbol allocate(PFNGLFOGCOORDDVEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLFOGCOORDDVEXTPROC.class, fi, constants$625.PFNGLFOGCOORDDVEXTPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLFOGCOORDDVEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLFOGCOORDDVEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (jdk.incubator.foreign.MemoryAddress x0) -> {
            try {
                constants$625.PFNGLFOGCOORDDVEXTPROC$MH.invokeExact(symbol, (jdk.incubator.foreign.Addressable)x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


