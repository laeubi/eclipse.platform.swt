// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLFOGCOORDFPROC {

    void apply(float x0);
    static NativeSymbol allocate(PFNGLFOGCOORDFPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLFOGCOORDFPROC.class, fi, constants$93.PFNGLFOGCOORDFPROC$FUNC, "(F)V", scope);
    }
    static PFNGLFOGCOORDFPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLFOGCOORDFPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (float x0) -> {
            try {
                constants$93.PFNGLFOGCOORDFPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


