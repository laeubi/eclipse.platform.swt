// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC {

    void apply(int x0, int x1, int x2);
    static NativeSymbol allocate(PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC.class, fi, constants$610.PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC$FUNC, "(III)V", scope);
    }
    static PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2) -> {
            try {
                constants$610.PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


