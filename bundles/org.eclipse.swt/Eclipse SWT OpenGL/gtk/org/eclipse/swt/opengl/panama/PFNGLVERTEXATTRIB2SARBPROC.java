// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXATTRIB2SARBPROC {

    void apply(int x0, short x1, short x2);
    static NativeSymbol allocate(PFNGLVERTEXATTRIB2SARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIB2SARBPROC.class, fi, constants$389.PFNGLVERTEXATTRIB2SARBPROC$FUNC, "(ISS)V", scope);
    }
    static PFNGLVERTEXATTRIB2SARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXATTRIB2SARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, short x1, short x2) -> {
            try {
                constants$389.PFNGLVERTEXATTRIB2SARBPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


