// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLPROGRAMUNIFORM1FPROC {

    void apply(int x0, int x1, float x2);
    static NativeSymbol allocate(PFNGLPROGRAMUNIFORM1FPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLPROGRAMUNIFORM1FPROC.class, fi, constants$226.PFNGLPROGRAMUNIFORM1FPROC$FUNC, "(IIF)V", scope);
    }
    static PFNGLPROGRAMUNIFORM1FPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLPROGRAMUNIFORM1FPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, float x2) -> {
            try {
                constants$226.PFNGLPROGRAMUNIFORM1FPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


