// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGETARRAYOBJECTFVATIPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static NativeSymbol allocate(PFNGLGETARRAYOBJECTFVATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETARRAYOBJECTFVATIPROC.class, fi, constants$499.PFNGLGETARRAYOBJECTFVATIPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETARRAYOBJECTFVATIPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGETARRAYOBJECTFVATIPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$499.PFNGLGETARRAYOBJECTFVATIPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


