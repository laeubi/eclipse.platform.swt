// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPOLYGONOFFSETEXTPROC {

    void apply(float x0, float x1);
    static NativeSymbol allocate(PFNGLPOLYGONOFFSETEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPOLYGONOFFSETEXTPROC.class, fi, constants$654.PFNGLPOLYGONOFFSETEXTPROC$FUNC, "(FF)V", scope);
    }
    static PFNGLPOLYGONOFFSETEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPOLYGONOFFSETEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (float x0, float x1) -> {
            try {
                constants$654.PFNGLPOLYGONOFFSETEXTPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


