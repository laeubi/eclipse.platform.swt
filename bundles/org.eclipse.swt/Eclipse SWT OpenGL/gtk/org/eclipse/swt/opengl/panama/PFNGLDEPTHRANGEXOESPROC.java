// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLDEPTHRANGEXOESPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLDEPTHRANGEXOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLDEPTHRANGEXOESPROC.class, fi, constants$416.PFNGLDEPTHRANGEXOESPROC$FUNC, "(II)V", scope);
    }
    static PFNGLDEPTHRANGEXOESPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLDEPTHRANGEXOESPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$416.PFNGLDEPTHRANGEXOESPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


