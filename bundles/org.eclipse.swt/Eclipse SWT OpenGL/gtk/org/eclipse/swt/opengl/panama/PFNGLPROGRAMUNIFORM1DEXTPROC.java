// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPROGRAMUNIFORM1DEXTPROC {

    void apply(int x0, int x1, double x2);
    static NativeSymbol allocate(PFNGLPROGRAMUNIFORM1DEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM1DEXTPROC.class, fi, constants$611.PFNGLPROGRAMUNIFORM1DEXTPROC$FUNC, "(IID)V", scope);
    }
    static PFNGLPROGRAMUNIFORM1DEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPROGRAMUNIFORM1DEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, double x2) -> {
            try {
                constants$611.PFNGLPROGRAMUNIFORM1DEXTPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


