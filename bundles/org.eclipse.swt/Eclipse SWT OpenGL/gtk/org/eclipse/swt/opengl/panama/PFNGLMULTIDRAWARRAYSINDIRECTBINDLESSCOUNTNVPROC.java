// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1, int x2, int x3, int x4, int x5);
    static NativeSymbol allocate(PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC.class, fi, constants$723.PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;IIII)V", scope);
    }
    static PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, jdk.incubator.foreign.MemoryAddress x1, int x2, int x3, int x4, int x5) -> {
            try {
                constants$723.PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC$MH.invokeExact(symbol, x0, (jdk.incubator.foreign.Addressable)x1, x2, x3, x4, x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


