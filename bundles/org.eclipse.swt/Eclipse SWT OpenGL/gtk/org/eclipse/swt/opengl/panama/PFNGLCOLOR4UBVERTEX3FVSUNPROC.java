// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLCOLOR4UBVERTEX3FVSUNPROC {

    void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);
    static NativeSymbol allocate(PFNGLCOLOR4UBVERTEX3FVSUNPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLCOLOR4UBVERTEX3FVSUNPROC.class, fi, constants$906.PFNGLCOLOR4UBVERTEX3FVSUNPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLCOLOR4UBVERTEX3FVSUNPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLCOLOR4UBVERTEX3FVSUNPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$906.PFNGLCOLOR4UBVERTEX3FVSUNPROC$MH.invokeExact(symbol, (jdk.incubator.foreign.Addressable)x0, (jdk.incubator.foreign.Addressable)x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


