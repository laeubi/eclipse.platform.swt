// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface glutTabletButtonFunc$callback {

    void apply(int x0, int x1, int x2, int x3);
    static MemoryAddress allocate(glutTabletButtonFunc$callback fi) {
        return RuntimeHelper.upcallStub(glutTabletButtonFunc$callback.class, fi, constants$951.glutTabletButtonFunc$callback$FUNC, "(IIII)V");
    }
    static MemoryAddress allocate(glutTabletButtonFunc$callback fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(glutTabletButtonFunc$callback.class, fi, constants$951.glutTabletButtonFunc$callback$FUNC, "(IIII)V", scope);
    }
    static glutTabletButtonFunc$callback ofAddress(MemoryAddress addr) {
        return (int x0, int x1, int x2, int x3) -> {
            try {
                constants$951.glutTabletButtonFunc$callback$MH.invokeExact((Addressable)addr, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


