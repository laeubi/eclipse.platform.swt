// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLBLENDEQUATIONSEPARATEPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLBLENDEQUATIONSEPARATEPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBLENDEQUATIONSEPARATEPROC.class, fi, constants$113.PFNGLBLENDEQUATIONSEPARATEPROC$FUNC, "(II)V", scope);
    }
    static PFNGLBLENDEQUATIONSEPARATEPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLBLENDEQUATIONSEPARATEPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$113.PFNGLBLENDEQUATIONSEPARATEPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


