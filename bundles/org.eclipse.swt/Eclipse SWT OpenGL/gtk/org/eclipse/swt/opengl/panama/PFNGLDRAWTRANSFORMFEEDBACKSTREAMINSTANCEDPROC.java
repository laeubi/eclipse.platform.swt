// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC {

    void apply(int x0, int x1, int x2, int x3);
    static NativeSymbol allocate(PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC.class, fi, constants$253.PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC$FUNC, "(IIII)V", scope);
    }
    static PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3) -> {
            try {
                constants$253.PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


