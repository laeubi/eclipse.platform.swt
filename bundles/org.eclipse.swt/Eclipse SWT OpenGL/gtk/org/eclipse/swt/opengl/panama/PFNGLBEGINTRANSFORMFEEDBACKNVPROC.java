// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLBEGINTRANSFORMFEEDBACKNVPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLBEGINTRANSFORMFEEDBACKNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBEGINTRANSFORMFEEDBACKNVPROC.class, fi, constants$819.PFNGLBEGINTRANSFORMFEEDBACKNVPROC$FUNC, "(I)V", scope);
    }
    static PFNGLBEGINTRANSFORMFEEDBACKNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLBEGINTRANSFORMFEEDBACKNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$819.PFNGLBEGINTRANSFORMFEEDBACKNVPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


