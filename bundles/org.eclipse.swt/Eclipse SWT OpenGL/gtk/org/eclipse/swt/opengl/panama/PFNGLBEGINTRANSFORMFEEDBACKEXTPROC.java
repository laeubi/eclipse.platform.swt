// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLBEGINTRANSFORMFEEDBACKEXTPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLBEGINTRANSFORMFEEDBACKEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBEGINTRANSFORMFEEDBACKEXTPROC.class, fi, constants$674.PFNGLBEGINTRANSFORMFEEDBACKEXTPROC$FUNC, "(I)V", scope);
    }
    static PFNGLBEGINTRANSFORMFEEDBACKEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLBEGINTRANSFORMFEEDBACKEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$674.PFNGLBEGINTRANSFORMFEEDBACKEXTPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


