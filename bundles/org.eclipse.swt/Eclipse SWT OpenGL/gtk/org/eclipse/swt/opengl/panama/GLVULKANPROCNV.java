// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface GLVULKANPROCNV {

    void apply();
    static NativeSymbol allocate(GLVULKANPROCNV fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(GLVULKANPROCNV.class, fi, constants$738.GLVULKANPROCNV$FUNC, "()V", scope);
    }
    static GLVULKANPROCNV ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("GLVULKANPROCNV::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return () -> {
            try {
                constants$738.GLVULKANPROCNV$MH.invokeExact(symbol);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


