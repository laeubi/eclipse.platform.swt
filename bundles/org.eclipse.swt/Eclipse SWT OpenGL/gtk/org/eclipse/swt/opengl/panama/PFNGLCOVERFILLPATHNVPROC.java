// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOVERFILLPATHNVPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLCOVERFILLPATHNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOVERFILLPATHNVPROC.class, fi, constants$788.PFNGLCOVERFILLPATHNVPROC$FUNC, "(II)V", scope);
    }
    static PFNGLCOVERFILLPATHNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOVERFILLPATHNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$788.PFNGLCOVERFILLPATHNVPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


