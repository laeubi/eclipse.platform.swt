// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLVERTEXATTRIBL4I64NVPROC {

    void apply(int x0, long x1, long x2, long x3, long x4);
    static NativeSymbol allocate(PFNGLVERTEXATTRIBL4I64NVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLVERTEXATTRIBL4I64NVPROC.class, fi, constants$830.PFNGLVERTEXATTRIBL4I64NVPROC$FUNC, "(IJJJJ)V", scope);
    }
    static PFNGLVERTEXATTRIBL4I64NVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLVERTEXATTRIBL4I64NVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, long x1, long x2, long x3, long x4) -> {
            try {
                constants$830.PFNGLVERTEXATTRIBL4I64NVPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


