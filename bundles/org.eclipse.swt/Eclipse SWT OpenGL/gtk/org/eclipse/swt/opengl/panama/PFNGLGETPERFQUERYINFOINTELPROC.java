// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGETPERFQUERYINFOINTELPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2, jdk.incubator.foreign.MemoryAddress x3, jdk.incubator.foreign.MemoryAddress x4, jdk.incubator.foreign.MemoryAddress x5, jdk.incubator.foreign.MemoryAddress x6);
    static NativeSymbol allocate(PFNGLGETPERFQUERYINFOINTELPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETPERFQUERYINFOINTELPROC.class, fi, constants$711.PFNGLGETPERFQUERYINFOINTELPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLGETPERFQUERYINFOINTELPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGETPERFQUERYINFOINTELPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2, jdk.incubator.foreign.MemoryAddress x3, jdk.incubator.foreign.MemoryAddress x4, jdk.incubator.foreign.MemoryAddress x5, jdk.incubator.foreign.MemoryAddress x6) -> {
            try {
                constants$711.PFNGLGETPERFQUERYINFOINTELPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2, (jdk.incubator.foreign.Addressable)x3, (jdk.incubator.foreign.Addressable)x4, (jdk.incubator.foreign.Addressable)x5, (jdk.incubator.foreign.Addressable)x6);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


