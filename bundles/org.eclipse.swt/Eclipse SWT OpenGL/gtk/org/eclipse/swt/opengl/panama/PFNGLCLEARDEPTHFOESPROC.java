// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCLEARDEPTHFOESPROC {

    void apply(float x0);
    static NativeSymbol allocate(PFNGLCLEARDEPTHFOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCLEARDEPTHFOESPROC.class, fi, constants$449.PFNGLCLEARDEPTHFOESPROC$FUNC, "(F)V", scope);
    }
    static PFNGLCLEARDEPTHFOESPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCLEARDEPTHFOESPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (float x0) -> {
            try {
                constants$449.PFNGLCLEARDEPTHFOESPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


