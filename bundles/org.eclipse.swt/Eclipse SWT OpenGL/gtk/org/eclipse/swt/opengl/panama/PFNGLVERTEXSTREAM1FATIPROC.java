// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXSTREAM1FATIPROC {

    void apply(int x0, float x1);
    static NativeSymbol allocate(PFNGLVERTEXSTREAM1FATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXSTREAM1FATIPROC.class, fi, constants$503.PFNGLVERTEXSTREAM1FATIPROC$FUNC, "(IF)V", scope);
    }
    static PFNGLVERTEXSTREAM1FATIPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXSTREAM1FATIPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, float x1) -> {
            try {
                constants$503.PFNGLVERTEXSTREAM1FATIPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


