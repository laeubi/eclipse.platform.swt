// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLISTRANSFORMFEEDBACKNVPROC {

    byte apply(int x0);
    static NativeSymbol allocate(PFNGLISTRANSFORMFEEDBACKNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLISTRANSFORMFEEDBACKNVPROC.class, fi, constants$824.PFNGLISTRANSFORMFEEDBACKNVPROC$FUNC, "(I)B", scope);
    }
    static PFNGLISTRANSFORMFEEDBACKNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLISTRANSFORMFEEDBACKNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                return (byte)constants$824.PFNGLISTRANSFORMFEEDBACKNVPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


