// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPROGRAMUNIFORM3IPROC {

    void apply(int x0, int x1, int x2, int x3, int x4);
    static NativeSymbol allocate(PFNGLPROGRAMUNIFORM3IPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM3IPROC.class, fi, constants$231.PFNGLPROGRAMUNIFORM3IPROC$FUNC, "(IIIII)V", scope);
    }
    static PFNGLPROGRAMUNIFORM3IPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPROGRAMUNIFORM3IPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4) -> {
            try {
                constants$231.PFNGLPROGRAMUNIFORM3IPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


