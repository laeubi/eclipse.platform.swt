// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMULTITEXENVFEXTPROC {

    void apply(int x0, int x1, int x2, float x3);
    static NativeSymbol allocate(PFNGLMULTITEXENVFEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXENVFEXTPROC.class, fi, constants$550.PFNGLMULTITEXENVFEXTPROC$FUNC, "(IIIF)V", scope);
    }
    static PFNGLMULTITEXENVFEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMULTITEXENVFEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, float x3) -> {
            try {
                constants$550.PFNGLMULTITEXENVFEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


