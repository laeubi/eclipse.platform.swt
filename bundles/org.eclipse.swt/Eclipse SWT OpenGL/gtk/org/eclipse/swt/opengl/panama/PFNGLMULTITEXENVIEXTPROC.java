// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMULTITEXENVIEXTPROC {

    void apply(int x0, int x1, int x2, int x3);
    static NativeSymbol allocate(PFNGLMULTITEXENVIEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXENVIEXTPROC.class, fi, constants$550.PFNGLMULTITEXENVIEXTPROC$FUNC, "(IIII)V", scope);
    }
    static PFNGLMULTITEXENVIEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMULTITEXENVIEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3) -> {
            try {
                constants$550.PFNGLMULTITEXENVIEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


