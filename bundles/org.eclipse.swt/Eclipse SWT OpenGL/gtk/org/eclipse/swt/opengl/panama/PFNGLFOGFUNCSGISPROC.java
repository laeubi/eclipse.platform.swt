// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLFOGFUNCSGISPROC {

    void apply(int x0, jdk.incubator.foreign.MemoryAddress x1);
    static NativeSymbol allocate(PFNGLFOGFUNCSGISPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLFOGFUNCSGISPROC.class, fi, constants$874.PFNGLFOGFUNCSGISPROC$FUNC, "(ILjdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static PFNGLFOGFUNCSGISPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLFOGFUNCSGISPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$874.PFNGLFOGFUNCSGISPROC$MH.invokeExact(symbol, x0, (jdk.incubator.foreign.Addressable)x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


