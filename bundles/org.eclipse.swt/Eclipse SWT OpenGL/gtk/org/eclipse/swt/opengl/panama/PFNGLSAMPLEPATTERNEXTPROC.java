// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLSAMPLEPATTERNEXTPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLSAMPLEPATTERNEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSAMPLEPATTERNEXTPROC.class, fi, constants$650.PFNGLSAMPLEPATTERNEXTPROC$FUNC, "(I)V", scope);
    }
    static PFNGLSAMPLEPATTERNEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLSAMPLEPATTERNEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$650.PFNGLSAMPLEPATTERNEXTPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


