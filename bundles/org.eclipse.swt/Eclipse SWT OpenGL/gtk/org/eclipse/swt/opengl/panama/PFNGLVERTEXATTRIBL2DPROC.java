// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXATTRIBL2DPROC {

    void apply(int x0, double x1, double x2);
    static NativeSymbol allocate(PFNGLVERTEXATTRIBL2DPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIBL2DPROC.class, fi, constants$243.PFNGLVERTEXATTRIBL2DPROC$FUNC, "(IDD)V", scope);
    }
    static PFNGLVERTEXATTRIBL2DPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXATTRIBL2DPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, double x1, double x2) -> {
            try {
                constants$243.PFNGLVERTEXATTRIBL2DPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


