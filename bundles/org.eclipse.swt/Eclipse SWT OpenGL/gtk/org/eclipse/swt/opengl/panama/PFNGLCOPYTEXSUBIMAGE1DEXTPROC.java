// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOPYTEXSUBIMAGE1DEXTPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5);
    static NativeSymbol allocate(PFNGLCOPYTEXSUBIMAGE1DEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOPYTEXSUBIMAGE1DEXTPROC.class, fi, constants$533.PFNGLCOPYTEXSUBIMAGE1DEXTPROC$FUNC, "(IIIIII)V", scope);
    }
    static PFNGLCOPYTEXSUBIMAGE1DEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOPYTEXSUBIMAGE1DEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, int x5) -> {
            try {
                constants$533.PFNGLCOPYTEXSUBIMAGE1DEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


