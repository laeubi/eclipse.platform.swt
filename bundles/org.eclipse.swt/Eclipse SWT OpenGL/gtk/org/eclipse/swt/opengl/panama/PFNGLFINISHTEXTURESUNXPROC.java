// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLFINISHTEXTURESUNXPROC {

    void apply();
    static NativeSymbol allocate(PFNGLFINISHTEXTURESUNXPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLFINISHTEXTURESUNXPROC.class, fi, constants$900.PFNGLFINISHTEXTURESUNXPROC$FUNC, "()V", scope);
    }
    static PFNGLFINISHTEXTURESUNXPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLFINISHTEXTURESUNXPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return () -> {
            try {
                constants$900.PFNGLFINISHTEXTURESUNXPROC$MH.invokeExact(symbol);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


