// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGETPROGRAMRESOURCEINDEXPROC {

    int apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);
    static NativeSymbol allocate(PFNGLGETPROGRAMRESOURCEINDEXPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETPROGRAMRESOURCEINDEXPROC.class, fi, constants$259.PFNGLGETPROGRAMRESOURCEINDEXPROC$FUNC, "(IILjdk/incubator/foreign/MemoryAddress;)I", scope);
    }
    static PFNGLGETPROGRAMRESOURCEINDEXPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGETPROGRAMRESOURCEINDEXPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                return (int)constants$259.PFNGLGETPROGRAMRESOURCEINDEXPROC$MH.invokeExact(symbol, x0, x1, (jdk.incubator.foreign.Addressable)x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


