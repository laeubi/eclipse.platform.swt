// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMULTICASTGETQUERYOBJECTIVNVPROC {

    void apply(int x0, int x1, int x2, jdk.incubator.foreign.MemoryAddress x3);
    static NativeSymbol allocate(PFNGLMULTICASTGETQUERYOBJECTIVNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTICASTGETQUERYOBJECTIVNVPROC.class, fi, constants$753.PFNGLMULTICASTGETQUERYOBJECTIVNVPROC$FUNC, "(IIILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLMULTICASTGETQUERYOBJECTIVNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMULTICASTGETQUERYOBJECTIVNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, jdk.incubator.foreign.MemoryAddress x3) -> {
            try {
                constants$753.PFNGLMULTICASTGETQUERYOBJECTIVNVPROC$MH.invokeExact(symbol, x0, x1, x2, (jdk.incubator.foreign.Addressable)x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


