// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOPYTEXTURESUBIMAGE3DPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8);
    static NativeSymbol allocate(PFNGLCOPYTEXTURESUBIMAGE3DPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOPYTEXTURESUBIMAGE3DPROC.class, fi, constants$291.PFNGLCOPYTEXTURESUBIMAGE3DPROC$FUNC, "(IIIIIIIII)V", scope);
    }
    static PFNGLCOPYTEXTURESUBIMAGE3DPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOPYTEXTURESUBIMAGE3DPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8) -> {
            try {
                constants$291.PFNGLCOPYTEXTURESUBIMAGE3DPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, x6, x7, x8);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


