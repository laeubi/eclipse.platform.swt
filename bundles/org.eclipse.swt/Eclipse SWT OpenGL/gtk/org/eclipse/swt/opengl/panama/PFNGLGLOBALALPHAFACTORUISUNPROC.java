// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLGLOBALALPHAFACTORUISUNPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLGLOBALALPHAFACTORUISUNPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLGLOBALALPHAFACTORUISUNPROC.class, fi, constants$902.PFNGLGLOBALALPHAFACTORUISUNPROC$FUNC, "(I)V", scope);
    }
    static PFNGLGLOBALALPHAFACTORUISUNPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLGLOBALALPHAFACTORUISUNPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$902.PFNGLGLOBALALPHAFACTORUISUNPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


