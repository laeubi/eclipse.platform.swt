// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXSTREAM1DATIPROC {

    void apply(int x0, double x1);
    static NativeSymbol allocate(PFNGLVERTEXSTREAM1DATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXSTREAM1DATIPROC.class, fi, constants$503.PFNGLVERTEXSTREAM1DATIPROC$FUNC, "(ID)V", scope);
    }
    static PFNGLVERTEXSTREAM1DATIPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXSTREAM1DATIPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, double x1) -> {
            try {
                constants$503.PFNGLVERTEXSTREAM1DATIPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


