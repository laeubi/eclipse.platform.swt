// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLLGPUINTERLOCKNVXPROC {

    void apply();
    static NativeSymbol allocate(PFNGLLGPUINTERLOCKNVXPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLLGPUINTERLOCKNVXPROC.class, fi, constants$721.PFNGLLGPUINTERLOCKNVXPROC$FUNC, "()V", scope);
    }
    static PFNGLLGPUINTERLOCKNVXPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLLGPUINTERLOCKNVXPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return () -> {
            try {
                constants$721.PFNGLLGPUINTERLOCKNVXPROC$MH.invokeExact(symbol);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


