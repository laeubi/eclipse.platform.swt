// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLNORMALPOINTERLISTIBMPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2, int x3);
    static NativeSymbol allocate(PFNGLNORMALPOINTERLISTIBMPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLNORMALPOINTERLISTIBMPROC.class, fi, constants$704.PFNGLNORMALPOINTERLISTIBMPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;I)V", scope);
    }
    static PFNGLNORMALPOINTERLISTIBMPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLNORMALPOINTERLISTIBMPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2, int x3) -> {
            try {
                constants$704.PFNGLNORMALPOINTERLISTIBMPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


