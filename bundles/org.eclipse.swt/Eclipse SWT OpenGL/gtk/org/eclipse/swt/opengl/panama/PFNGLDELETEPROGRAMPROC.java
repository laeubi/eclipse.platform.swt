// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLDELETEPROGRAMPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLDELETEPROGRAMPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLDELETEPROGRAMPROC.class, fi, constants$116.PFNGLDELETEPROGRAMPROC$FUNC, "(I)V", scope);
    }
    static PFNGLDELETEPROGRAMPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLDELETEPROGRAMPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$116.PFNGLDELETEPROGRAMPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


