// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLUNLOCKARRAYSEXTPROC {

    void apply();
    static NativeSymbol allocate(PFNGLUNLOCKARRAYSEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNLOCKARRAYSEXTPROC.class, fi, constants$520.PFNGLUNLOCKARRAYSEXTPROC$FUNC, "()V", scope);
    }
    static PFNGLUNLOCKARRAYSEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLUNLOCKARRAYSEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return () -> {
            try {
                constants$520.PFNGLUNLOCKARRAYSEXTPROC$MH.invokeExact(symbol);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


