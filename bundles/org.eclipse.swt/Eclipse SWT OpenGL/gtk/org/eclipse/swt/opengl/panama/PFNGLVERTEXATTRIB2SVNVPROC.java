// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXATTRIB2SVNVPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static NativeSymbol allocate(PFNGLVERTEXATTRIB2SVNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIB2SVNVPROC.class, fi, constants$852.PFNGLVERTEXATTRIB2SVNVPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLVERTEXATTRIB2SVNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXATTRIB2SVNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$852.PFNGLVERTEXATTRIB2SVNVPROC$MH.invokeExact(symbol, x0, (jdk.incubator.foreign.Addressable)x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


