// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLBLENDFUNCSEPARATEIARBPROC {

    void apply(int x0, int x1, int x2, int x3, int x4);
    static NativeSymbol allocate(PFNGLBLENDFUNCSEPARATEIARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBLENDFUNCSEPARATEIARBPROC.class, fi, constants$323.PFNGLBLENDFUNCSEPARATEIARBPROC$FUNC, "(IIIII)V", scope);
    }
    static PFNGLBLENDFUNCSEPARATEIARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLBLENDFUNCSEPARATEIARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4) -> {
            try {
                constants$323.PFNGLBLENDFUNCSEPARATEIARBPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


