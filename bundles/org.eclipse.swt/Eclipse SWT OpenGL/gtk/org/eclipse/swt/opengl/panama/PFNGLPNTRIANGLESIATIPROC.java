// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPNTRIANGLESIATIPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLPNTRIANGLESIATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPNTRIANGLESIATIPROC.class, fi, constants$495.PFNGLPNTRIANGLESIATIPROC$FUNC, "(II)V", scope);
    }
    static PFNGLPNTRIANGLESIATIPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPNTRIANGLESIATIPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$495.PFNGLPNTRIANGLESIATIPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


