// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLBINORMAL3SEXTPROC {

    void apply(short x0, short x1, short x2);
    static NativeSymbol allocate(PFNGLBINORMAL3SEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBINORMAL3SEXTPROC.class, fi, constants$531.PFNGLBINORMAL3SEXTPROC$FUNC, "(SSS)V", scope);
    }
    static PFNGLBINORMAL3SEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLBINORMAL3SEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (short x0, short x1, short x2) -> {
            try {
                constants$531.PFNGLBINORMAL3SEXTPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


