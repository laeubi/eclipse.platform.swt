// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1, int x2);
    static NativeSymbol allocate(PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC.class, fi, constants$820.PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;I)V", scope);
    }
    static PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, jdk.incubator.foreign.MemoryAddress x1, int x2) -> {
            try {
                constants$820.PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC$MH.invokeExact(symbol, x0, (jdk.incubator.foreign.Addressable)x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


