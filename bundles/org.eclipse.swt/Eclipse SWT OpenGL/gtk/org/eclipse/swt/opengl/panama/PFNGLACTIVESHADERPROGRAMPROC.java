// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLACTIVESHADERPROGRAMPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLACTIVESHADERPROGRAMPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLACTIVESHADERPROGRAMPROC.class, fi, constants$223.PFNGLACTIVESHADERPROGRAMPROC$FUNC, "(II)V", scope);
    }
    static PFNGLACTIVESHADERPROGRAMPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLACTIVESHADERPROGRAMPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$223.PFNGLACTIVESHADERPROGRAMPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


