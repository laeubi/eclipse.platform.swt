// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPROGRAMUNIFORM4FPROC {

    void apply(int x0, int x1, float x2, float x3, float x4, float x5);
    static NativeSymbol allocate(PFNGLPROGRAMUNIFORM4FPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM4FPROC.class, fi, constants$234.PFNGLPROGRAMUNIFORM4FPROC$FUNC, "(IIFFFF)V", scope);
    }
    static PFNGLPROGRAMUNIFORM4FPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPROGRAMUNIFORM4FPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, float x2, float x3, float x4, float x5) -> {
            try {
                constants$234.PFNGLPROGRAMUNIFORM4FPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


