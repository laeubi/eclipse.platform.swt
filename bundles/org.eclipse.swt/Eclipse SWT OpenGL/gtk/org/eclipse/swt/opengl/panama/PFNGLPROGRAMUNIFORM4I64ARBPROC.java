// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPROGRAMUNIFORM4I64ARBPROC {

    void apply(int x0, int x1, long x2, long x3, long x4, long x5);
    static NativeSymbol allocate(PFNGLPROGRAMUNIFORM4I64ARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM4I64ARBPROC.class, fi, constants$339.PFNGLPROGRAMUNIFORM4I64ARBPROC$FUNC, "(IIJJJJ)V", scope);
    }
    static PFNGLPROGRAMUNIFORM4I64ARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPROGRAMUNIFORM4I64ARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, long x2, long x3, long x4, long x5) -> {
            try {
                constants$339.PFNGLPROGRAMUNIFORM4I64ARBPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


