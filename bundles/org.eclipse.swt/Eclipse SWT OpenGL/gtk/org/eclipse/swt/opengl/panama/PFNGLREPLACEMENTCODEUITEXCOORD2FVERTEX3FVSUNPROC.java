// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC {

    void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2);
    static NativeSymbol allocate(PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC.class, fi, constants$917.PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$917.PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC$MH.invokeExact(symbol, (jdk.incubator.foreign.Addressable)x0, (jdk.incubator.foreign.Addressable)x1, (jdk.incubator.foreign.Addressable)x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


