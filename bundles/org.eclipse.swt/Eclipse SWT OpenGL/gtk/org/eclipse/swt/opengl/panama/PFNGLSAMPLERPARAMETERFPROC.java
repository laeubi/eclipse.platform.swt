// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLSAMPLERPARAMETERFPROC {

    void apply(int x0, int x1, float x2);
    static NativeSymbol allocate(PFNGLSAMPLERPARAMETERFPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSAMPLERPARAMETERFPROC.class, fi, constants$188.PFNGLSAMPLERPARAMETERFPROC$FUNC, "(IIF)V", scope);
    }
    static PFNGLSAMPLERPARAMETERFPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLSAMPLERPARAMETERFPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, float x2) -> {
            try {
                constants$188.PFNGLSAMPLERPARAMETERFPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


