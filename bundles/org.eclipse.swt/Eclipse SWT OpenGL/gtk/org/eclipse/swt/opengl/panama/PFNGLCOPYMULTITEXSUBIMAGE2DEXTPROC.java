// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8);
    static NativeSymbol allocate(PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC.class, fi, constants$558.PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC$FUNC, "(IIIIIIIII)V", scope);
    }
    static PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8) -> {
            try {
                constants$558.PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, x6, x7, x8);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


