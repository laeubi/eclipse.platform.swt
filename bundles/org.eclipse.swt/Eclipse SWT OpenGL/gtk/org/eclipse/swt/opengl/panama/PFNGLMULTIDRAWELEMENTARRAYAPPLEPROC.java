// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2, int x3);
    static NativeSymbol allocate(PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC.class, fi, constants$477.PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)V", scope);
    }
    static PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2, int x3) -> {
            try {
                constants$477.PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC$MH.invokeExact(symbol, x0, (jdk.incubator.foreign.Addressable)x1, (jdk.incubator.foreign.Addressable)x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


