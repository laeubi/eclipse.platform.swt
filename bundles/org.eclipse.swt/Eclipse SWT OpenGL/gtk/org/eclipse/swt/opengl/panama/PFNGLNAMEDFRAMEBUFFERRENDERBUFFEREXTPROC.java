// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC {

    void apply(int x0, int x1, int x2, int x3);
    static NativeSymbol allocate(PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC.class, fi, constants$598.PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC$FUNC, "(IIII)V", scope);
    }
    static PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3) -> {
            try {
                constants$598.PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


