// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLSECONDARYCOLORFORMATNVPROC {

    void apply(int x0, int x1, int x2);
    static NativeSymbol allocate(PFNGLSECONDARYCOLORFORMATNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSECONDARYCOLORFORMATNVPROC.class, fi, constants$838.PFNGLSECONDARYCOLORFORMATNVPROC$FUNC, "(III)V", scope);
    }
    static PFNGLSECONDARYCOLORFORMATNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLSECONDARYCOLORFORMATNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2) -> {
            try {
                constants$838.PFNGLSECONDARYCOLORFORMATNVPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


