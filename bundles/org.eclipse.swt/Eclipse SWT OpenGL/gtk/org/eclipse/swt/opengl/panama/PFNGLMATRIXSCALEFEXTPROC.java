// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMATRIXSCALEFEXTPROC {

    void apply(int x0, float x1, float x2, float x3);
    static NativeSymbol allocate(PFNGLMATRIXSCALEFEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMATRIXSCALEFEXTPROC.class, fi, constants$539.PFNGLMATRIXSCALEFEXTPROC$FUNC, "(IFFF)V", scope);
    }
    static PFNGLMATRIXSCALEFEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMATRIXSCALEFEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, float x1, float x2, float x3) -> {
            try {
                constants$539.PFNGLMATRIXSCALEFEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


