// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOLOR4HNVPROC {

    void apply(short x0, short x1, short x2, short x3);
    static NativeSymbol allocate(PFNGLCOLOR4HNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOLOR4HNVPROC.class, fi, constants$764.PFNGLCOLOR4HNVPROC$FUNC, "(SSSS)V", scope);
    }
    static PFNGLCOLOR4HNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOLOR4HNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (short x0, short x1, short x2, short x3) -> {
            try {
                constants$764.PFNGLCOLOR4HNVPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


