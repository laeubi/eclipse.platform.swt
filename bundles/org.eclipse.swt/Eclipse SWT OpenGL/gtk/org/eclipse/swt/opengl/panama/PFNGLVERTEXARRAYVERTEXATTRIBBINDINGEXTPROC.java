// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC {

    void apply(int x0, int x1, int x2);
    static NativeSymbol allocate(PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC.class, fi, constants$620.PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC$FUNC, "(III)V", scope);
    }
    static PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2) -> {
            try {
                constants$620.PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC$MH.invokeExact(symbol, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


