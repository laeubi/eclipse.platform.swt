// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface glutOverlayDisplayFunc$callback {

    void apply();
    static MemoryAddress allocate(glutOverlayDisplayFunc$callback fi) {
        return RuntimeHelper.upcallStub(glutOverlayDisplayFunc$callback.class, fi, constants$947.glutOverlayDisplayFunc$callback$FUNC, "()V");
    }
    static MemoryAddress allocate(glutOverlayDisplayFunc$callback fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(glutOverlayDisplayFunc$callback.class, fi, constants$947.glutOverlayDisplayFunc$callback$FUNC, "()V", scope);
    }
    static glutOverlayDisplayFunc$callback ofAddress(MemoryAddress addr) {
        return () -> {
            try {
                constants$947.glutOverlayDisplayFunc$callback$MH.invokeExact((Addressable)addr);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


