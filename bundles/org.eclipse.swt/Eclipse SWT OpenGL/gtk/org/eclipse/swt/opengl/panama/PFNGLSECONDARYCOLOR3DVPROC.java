// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLSECONDARYCOLOR3DVPROC {

    void apply(jdk.incubator.foreign.MemoryAddress x0);
    static NativeSymbol allocate(PFNGLSECONDARYCOLOR3DVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSECONDARYCOLOR3DVPROC.class, fi, constants$96.PFNGLSECONDARYCOLOR3DVPROC$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLSECONDARYCOLOR3DVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLSECONDARYCOLOR3DVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (jdk.incubator.foreign.MemoryAddress x0) -> {
            try {
                constants$96.PFNGLSECONDARYCOLOR3DVPROC$MH.invokeExact(symbol, (jdk.incubator.foreign.Addressable)x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


