// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXATTRIB4SNVPROC {

    void apply(int x0, short x1, short x2, short x3, short x4);
    static NativeSymbol allocate(PFNGLVERTEXATTRIB4SNVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIB4SNVPROC.class, fi, constants$855.PFNGLVERTEXATTRIB4SNVPROC$FUNC, "(ISSSS)V", scope);
    }
    static PFNGLVERTEXATTRIB4SNVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXATTRIB4SNVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, short x1, short x2, short x3, short x4) -> {
            try {
                constants$855.PFNGLVERTEXATTRIB4SNVPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


