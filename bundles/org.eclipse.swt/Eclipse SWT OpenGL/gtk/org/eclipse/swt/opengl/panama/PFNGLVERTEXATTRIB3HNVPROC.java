// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXATTRIB3HNVPROC {

    void apply(int x0, short x1, short x2, short x3);
    static NativeSymbol allocate(PFNGLVERTEXATTRIB3HNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIB3HNVPROC.class, fi, constants$773.PFNGLVERTEXATTRIB3HNVPROC$FUNC, "(ISSS)V", scope);
    }
    static PFNGLVERTEXATTRIB3HNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXATTRIB3HNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, short x1, short x2, short x3) -> {
            try {
                constants$773.PFNGLVERTEXATTRIB3HNVPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


