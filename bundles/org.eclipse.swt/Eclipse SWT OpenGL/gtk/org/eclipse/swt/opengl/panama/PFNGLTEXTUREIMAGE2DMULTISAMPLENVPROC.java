// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5, byte x6);
    static NativeSymbol allocate(PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC.class, fi, constants$818.PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC$FUNC, "(IIIIIIB)V", scope);
    }
    static PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, int x5, byte x6) -> {
            try {
                constants$818.PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, x6);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


