// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMULTIMODEDRAWARRAYSIBMPROC {

    void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2, int x3, int x4);
    static NativeSymbol allocate(PFNGLMULTIMODEDRAWARRAYSIBMPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTIMODEDRAWARRAYSIBMPROC.class, fi, constants$702.PFNGLMULTIMODEDRAWARRAYSIBMPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;II)V", scope);
    }
    static PFNGLMULTIMODEDRAWARRAYSIBMPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMULTIMODEDRAWARRAYSIBMPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2, int x3, int x4) -> {
            try {
                constants$702.PFNGLMULTIMODEDRAWARRAYSIBMPROC$MH.invokeExact(symbol, (jdk.incubator.foreign.Addressable)x0, (jdk.incubator.foreign.Addressable)x1, (jdk.incubator.foreign.Addressable)x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


