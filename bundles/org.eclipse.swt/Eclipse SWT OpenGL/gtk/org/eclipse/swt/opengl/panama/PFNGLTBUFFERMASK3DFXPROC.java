// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLTBUFFERMASK3DFXPROC {

    void apply(int x0);
    static NativeSymbol allocate(PFNGLTBUFFERMASK3DFXPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLTBUFFERMASK3DFXPROC.class, fi, constants$451.PFNGLTBUFFERMASK3DFXPROC$FUNC, "(I)V", scope);
    }
    static PFNGLTBUFFERMASK3DFXPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLTBUFFERMASK3DFXPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0) -> {
            try {
                constants$451.PFNGLTBUFFERMASK3DFXPROC$MH.invokeExact(symbol, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


