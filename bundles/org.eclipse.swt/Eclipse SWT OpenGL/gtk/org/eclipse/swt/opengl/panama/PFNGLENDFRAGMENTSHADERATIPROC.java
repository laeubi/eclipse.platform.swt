// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLENDFRAGMENTSHADERATIPROC {

    void apply();
    static NativeSymbol allocate(PFNGLENDFRAGMENTSHADERATIPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLENDFRAGMENTSHADERATIPROC.class, fi, constants$491.PFNGLENDFRAGMENTSHADERATIPROC$FUNC, "()V", scope);
    }
    static PFNGLENDFRAGMENTSHADERATIPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLENDFRAGMENTSHADERATIPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return () -> {
            try {
                constants$491.PFNGLENDFRAGMENTSHADERATIPROC$MH.invokeExact(symbol);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


