// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLDELETEFRAGMENTSHADERATIPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLDELETEFRAGMENTSHADERATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLDELETEFRAGMENTSHADERATIPROC.class, fi, constants$490.PFNGLDELETEFRAGMENTSHADERATIPROC$FUNC, "(I)V", scope);
    }
    static PFNGLDELETEFRAGMENTSHADERATIPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLDELETEFRAGMENTSHADERATIPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$490.PFNGLDELETEFRAGMENTSHADERATIPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


