// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLTEXCOORD1XOESPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLTEXCOORD1XOESPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLTEXCOORD1XOESPROC.class, fi, constants$443.PFNGLTEXCOORD1XOESPROC$FUNC, "(I)V", scope);
    }
    static PFNGLTEXCOORD1XOESPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLTEXCOORD1XOESPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$443.PFNGLTEXCOORD1XOESPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


