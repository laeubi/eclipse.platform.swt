// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLBEGINPERFQUERYINTELPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLBEGINPERFQUERYINTELPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBEGINPERFQUERYINTELPROC.class, fi, constants$708.PFNGLBEGINPERFQUERYINTELPROC$FUNC, "(I)V", scope);
    }
    static PFNGLBEGINPERFQUERYINTELPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLBEGINPERFQUERYINTELPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$708.PFNGLBEGINPERFQUERYINTELPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


