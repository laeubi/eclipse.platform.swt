// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLISIMAGEHANDLERESIDENTNVPROC {

    byte apply(long x0);
    static NativeSymbol allocate(PFNGLISIMAGEHANDLERESIDENTNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLISIMAGEHANDLERESIDENTNVPROC.class, fi, constants$727.PFNGLISIMAGEHANDLERESIDENTNVPROC$FUNC, "(J)B", scope);
    }
    static PFNGLISIMAGEHANDLERESIDENTNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLISIMAGEHANDLERESIDENTNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (long x0) -> {
            try {
                return (byte)constants$727.PFNGLISIMAGEHANDLERESIDENTNVPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


