// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGETGRAPHICSRESETSTATUSARBPROC {

    int apply();
    static NativeSymbol allocate(PFNGLGETGRAPHICSRESETSTATUSARBPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGETGRAPHICSRESETSTATUSARBPROC.class, fi, constants$350.PFNGLGETGRAPHICSRESETSTATUSARBPROC$FUNC, "()I", scope);
    }
    static PFNGLGETGRAPHICSRESETSTATUSARBPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGETGRAPHICSRESETSTATUSARBPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return () -> {
            try {
                return (int)constants$350.PFNGLGETGRAPHICSRESETSTATUSARBPROC$MH.invokeExact(symbol);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


