// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLBINDTEXTUREUNITPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLBINDTEXTUREUNITPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLBINDTEXTUREUNITPROC.class, fi, constants$294.PFNGLBINDTEXTUREUNITPROC$FUNC, "(II)V", scope);
    }
    static PFNGLBINDTEXTUREUNITPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLBINDTEXTUREUNITPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$294.PFNGLBINDTEXTUREUNITPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


