// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGENERATEMIPMAPPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLGENERATEMIPMAPPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGENERATEMIPMAPPROC.class, fi, constants$171.PFNGLGENERATEMIPMAPPROC$FUNC, "(I)V", scope);
    }
    static PFNGLGENERATEMIPMAPPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGENERATEMIPMAPPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$171.PFNGLGENERATEMIPMAPPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


