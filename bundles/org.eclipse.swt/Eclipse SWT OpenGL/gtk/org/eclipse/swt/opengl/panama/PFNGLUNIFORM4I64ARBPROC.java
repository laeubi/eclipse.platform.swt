// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLUNIFORM4I64ARBPROC {

    void apply(int x0, long x1, long x2, long x3, long x4);
    static NativeSymbol allocate(PFNGLUNIFORM4I64ARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLUNIFORM4I64ARBPROC.class, fi, constants$333.PFNGLUNIFORM4I64ARBPROC$FUNC, "(IJJJJ)V", scope);
    }
    static PFNGLUNIFORM4I64ARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLUNIFORM4I64ARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, long x1, long x2, long x3, long x4) -> {
            try {
                constants$333.PFNGLUNIFORM4I64ARBPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


