// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLISQUERYARBPROC {

    byte apply(int x0);
    static NativeSymbol allocate(PFNGLISQUERYARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLISQUERYARBPROC.class, fi, constants$347.PFNGLISQUERYARBPROC$FUNC, "(I)B", scope);
    }
    static PFNGLISQUERYARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLISQUERYARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                return (byte)constants$347.PFNGLISQUERYARBPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


