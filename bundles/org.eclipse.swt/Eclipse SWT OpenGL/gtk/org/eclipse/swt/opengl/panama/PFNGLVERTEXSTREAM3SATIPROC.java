// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXSTREAM3SATIPROC {

    void apply(int x0, short x1, short x2, short x3);
    static NativeSymbol allocate(PFNGLVERTEXSTREAM3SATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXSTREAM3SATIPROC.class, fi, constants$507.PFNGLVERTEXSTREAM3SATIPROC$FUNC, "(ISSS)V", scope);
    }
    static PFNGLVERTEXSTREAM3SATIPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXSTREAM3SATIPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, short x1, short x2, short x3) -> {
            try {
                constants$507.PFNGLVERTEXSTREAM3SATIPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


