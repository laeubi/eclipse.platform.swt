// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEX4BOESPROC {

    void apply(byte x0, byte x1, byte x2, byte x3);
    static NativeSymbol allocate(PFNGLVERTEX4BOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEX4BOESPROC.class, fi, constants$414.PFNGLVERTEX4BOESPROC$FUNC, "(BBBB)V", scope);
    }
    static PFNGLVERTEX4BOESPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEX4BOESPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (byte x0, byte x1, byte x2, byte x3) -> {
            try {
                constants$414.PFNGLVERTEX4BOESPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


