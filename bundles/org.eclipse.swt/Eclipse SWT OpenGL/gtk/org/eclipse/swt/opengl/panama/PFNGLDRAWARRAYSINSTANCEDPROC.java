// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLDRAWARRAYSINSTANCEDPROC {

    void apply(int x0, int x1, int x2, int x3);
    static NativeSymbol allocate(PFNGLDRAWARRAYSINSTANCEDPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLDRAWARRAYSINSTANCEDPROC.class, fi, constants$174.PFNGLDRAWARRAYSINSTANCEDPROC$FUNC, "(IIII)V", scope);
    }
    static PFNGLDRAWARRAYSINSTANCEDPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLDRAWARRAYSINSTANCEDPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3) -> {
            try {
                constants$174.PFNGLDRAWARRAYSINSTANCEDPROC$MH.invokeExact(symbol, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


