// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLFRAGMENTCOLORMATERIALSGIXPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLFRAGMENTCOLORMATERIALSGIXPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLFRAGMENTCOLORMATERIALSGIXPROC.class, fi, constants$883.PFNGLFRAGMENTCOLORMATERIALSGIXPROC$FUNC, "(II)V", scope);
    }
    static PFNGLFRAGMENTCOLORMATERIALSGIXPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLFRAGMENTCOLORMATERIALSGIXPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$883.PFNGLFRAGMENTCOLORMATERIALSGIXPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


