// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLDRAWTRANSFORMFEEDBACKPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLDRAWTRANSFORMFEEDBACKPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLDRAWTRANSFORMFEEDBACKPROC.class, fi, constants$218.PFNGLDRAWTRANSFORMFEEDBACKPROC$FUNC, "(II)V", scope);
    }
    static PFNGLDRAWTRANSFORMFEEDBACKPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLDRAWTRANSFORMFEEDBACKPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$218.PFNGLDRAWTRANSFORMFEEDBACKPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


