// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXATTRIB4DNVPROC {

    void apply(int x0, double x1, double x2, double x3, double x4);
    static NativeSymbol allocate(PFNGLVERTEXATTRIB4DNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIB4DNVPROC.class, fi, constants$854.PFNGLVERTEXATTRIB4DNVPROC$FUNC, "(IDDDD)V", scope);
    }
    static PFNGLVERTEXATTRIB4DNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXATTRIB4DNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, double x1, double x2, double x3, double x4) -> {
            try {
                constants$854.PFNGLVERTEXATTRIB4DNVPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


