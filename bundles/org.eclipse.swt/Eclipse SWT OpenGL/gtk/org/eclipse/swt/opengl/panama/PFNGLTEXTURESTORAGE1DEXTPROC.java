// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLTEXTURESTORAGE1DEXTPROC {

    void apply(int x0, int x1, int x2, int x3, int x4);
    static NativeSymbol allocate(PFNGLTEXTURESTORAGE1DEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLTEXTURESTORAGE1DEXTPROC.class, fi, constants$617.PFNGLTEXTURESTORAGE1DEXTPROC$FUNC, "(IIIII)V", scope);
    }
    static PFNGLTEXTURESTORAGE1DEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLTEXTURESTORAGE1DEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4) -> {
            try {
                constants$617.PFNGLTEXTURESTORAGE1DEXTPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


