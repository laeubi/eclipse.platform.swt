// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLRENDERGPUMASKNVPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLRENDERGPUMASKNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLRENDERGPUMASKNVPROC.class, fi, constants$751.PFNGLRENDERGPUMASKNVPROC$FUNC, "(I)V", scope);
    }
    static PFNGLRENDERGPUMASKNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLRENDERGPUMASKNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$751.PFNGLRENDERGPUMASKNVPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


