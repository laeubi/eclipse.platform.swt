// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLISPROGRAMARBPROC {

    byte apply(int x0);
    static NativeSymbol allocate(PFNGLISPROGRAMARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLISPROGRAMARBPROC.class, fi, constants$330.PFNGLISPROGRAMARBPROC$FUNC, "(I)B", scope);
    }
    static PFNGLISPROGRAMARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLISPROGRAMARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                return (byte)constants$330.PFNGLISPROGRAMARBPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


