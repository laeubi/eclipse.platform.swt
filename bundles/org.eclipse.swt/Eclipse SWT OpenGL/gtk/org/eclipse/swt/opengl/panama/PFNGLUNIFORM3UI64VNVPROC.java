// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLUNIFORM3UI64VNVPROC {

    void apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static NativeSymbol allocate(PFNGLUNIFORM3UI64VNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORM3UI64VNVPROC.class, fi, constants$461.PFNGLUNIFORM3UI64VNVPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLUNIFORM3UI64VNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLUNIFORM3UI64VNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$461.PFNGLUNIFORM3UI64VNVPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


