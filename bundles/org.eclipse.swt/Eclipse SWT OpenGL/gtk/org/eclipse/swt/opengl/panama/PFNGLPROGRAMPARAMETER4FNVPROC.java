// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPROGRAMPARAMETER4FNVPROC {

    void apply(int x0, int x1, float x2, float x3, float x4, float x5);
    static NativeSymbol allocate(PFNGLPROGRAMPARAMETER4FNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMPARAMETER4FNVPROC.class, fi, constants$846.PFNGLPROGRAMPARAMETER4FNVPROC$FUNC, "(IIFFFF)V", scope);
    }
    static PFNGLPROGRAMPARAMETER4FNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPROGRAMPARAMETER4FNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, float x2, float x3, float x4, float x5) -> {
            try {
                constants$846.PFNGLPROGRAMPARAMETER4FNVPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


