// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXATTRIB3DNVPROC {

    void apply(int x0, double x1, double x2, double x3);
    static NativeSymbol allocate(PFNGLVERTEXATTRIB3DNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIB3DNVPROC.class, fi, constants$852.PFNGLVERTEXATTRIB3DNVPROC$FUNC, "(IDDD)V", scope);
    }
    static PFNGLVERTEXATTRIB3DNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXATTRIB3DNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, double x1, double x2, double x3) -> {
            try {
                constants$852.PFNGLVERTEXATTRIB3DNVPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


