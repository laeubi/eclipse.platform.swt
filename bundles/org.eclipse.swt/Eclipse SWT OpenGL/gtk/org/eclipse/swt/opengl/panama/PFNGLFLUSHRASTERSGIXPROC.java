// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLFLUSHRASTERSGIXPROC {

    void apply();
    static NativeSymbol allocate(PFNGLFLUSHRASTERSGIXPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLFLUSHRASTERSGIXPROC.class, fi, constants$883.PFNGLFLUSHRASTERSGIXPROC$FUNC, "()V", scope);
    }
    static PFNGLFLUSHRASTERSGIXPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLFLUSHRASTERSGIXPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return () -> {
            try {
                constants$883.PFNGLFLUSHRASTERSGIXPROC$MH.invokeExact(symbol);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


