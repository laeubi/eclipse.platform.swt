// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEX3HNVPROC {

    void apply(short x0, short x1, short x2);
    static NativeSymbol allocate(PFNGLVERTEX3HNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEX3HNVPROC.class, fi, constants$761.PFNGLVERTEX3HNVPROC$FUNC, "(SSS)V", scope);
    }
    static PFNGLVERTEX3HNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEX3HNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (short x0, short x1, short x2) -> {
            try {
                constants$761.PFNGLVERTEX3HNVPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


