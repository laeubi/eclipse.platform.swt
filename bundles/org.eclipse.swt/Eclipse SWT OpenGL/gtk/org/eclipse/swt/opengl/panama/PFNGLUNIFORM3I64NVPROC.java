// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLUNIFORM3I64NVPROC {

    void apply(int x0, long x1, long x2, long x3);
    static NativeSymbol allocate(PFNGLUNIFORM3I64NVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORM3I64NVPROC.class, fi, constants$457.PFNGLUNIFORM3I64NVPROC$FUNC, "(IJJJ)V", scope);
    }
    static PFNGLUNIFORM3I64NVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLUNIFORM3I64NVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, long x1, long x2, long x3) -> {
            try {
                constants$457.PFNGLUNIFORM3I64NVPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


