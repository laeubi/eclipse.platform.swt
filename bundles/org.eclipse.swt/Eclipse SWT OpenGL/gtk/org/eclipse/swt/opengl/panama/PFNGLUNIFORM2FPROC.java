// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLUNIFORM2FPROC {

    void apply(int x0, float x1, float x2);
    static NativeSymbol allocate(PFNGLUNIFORM2FPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORM2FPROC.class, fi, constants$125.PFNGLUNIFORM2FPROC$FUNC, "(IFF)V", scope);
    }
    static PFNGLUNIFORM2FPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLUNIFORM2FPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, float x1, float x2) -> {
            try {
                constants$125.PFNGLUNIFORM2FPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


