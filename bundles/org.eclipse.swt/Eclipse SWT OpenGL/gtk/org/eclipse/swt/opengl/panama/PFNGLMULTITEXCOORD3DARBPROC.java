// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMULTITEXCOORD3DARBPROC {

    void apply(int x0, double x1, double x2, double x3);
    static NativeSymbol allocate(PFNGLMULTITEXCOORD3DARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTITEXCOORD3DARBPROC.class, fi, constants$86.PFNGLMULTITEXCOORD3DARBPROC$FUNC, "(IDDD)V", scope);
    }
    static PFNGLMULTITEXCOORD3DARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMULTITEXCOORD3DARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, double x1, double x2, double x3) -> {
            try {
                constants$86.PFNGLMULTITEXCOORD3DARBPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


