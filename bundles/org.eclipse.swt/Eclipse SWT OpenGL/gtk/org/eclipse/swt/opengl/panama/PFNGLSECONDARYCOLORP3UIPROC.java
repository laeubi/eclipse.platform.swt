// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLSECONDARYCOLORP3UIPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLSECONDARYCOLORP3UIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLSECONDARYCOLORP3UIPROC.class, fi, constants$204.PFNGLSECONDARYCOLORP3UIPROC$FUNC, "(II)V", scope);
    }
    static PFNGLSECONDARYCOLORP3UIPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLSECONDARYCOLORP3UIPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$204.PFNGLSECONDARYCOLORP3UIPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


