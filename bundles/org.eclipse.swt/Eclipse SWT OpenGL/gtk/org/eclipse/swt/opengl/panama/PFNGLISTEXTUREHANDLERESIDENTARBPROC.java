// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLISTEXTUREHANDLERESIDENTARBPROC {

    byte apply(long x0);
    static NativeSymbol allocate(PFNGLISTEXTUREHANDLERESIDENTARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLISTEXTUREHANDLERESIDENTARBPROC.class, fi, constants$317.PFNGLISTEXTUREHANDLERESIDENTARBPROC$FUNC, "(J)B", scope);
    }
    static PFNGLISTEXTUREHANDLERESIDENTARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLISTEXTUREHANDLERESIDENTARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (long x0) -> {
            try {
                return (byte)constants$317.PFNGLISTEXTUREHANDLERESIDENTARBPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


