// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLTEXTUREMATERIALEXTPROC {

    void apply(int x0, int x1);
    static NativeSymbol allocate(PFNGLTEXTUREMATERIALEXTPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLTEXTUREMATERIALEXTPROC.class, fi, constants$641.PFNGLTEXTUREMATERIALEXTPROC$FUNC, "(II)V", scope);
    }
    static PFNGLTEXTUREMATERIALEXTPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLTEXTUREMATERIALEXTPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1) -> {
            try {
                constants$641.PFNGLTEXTUREMATERIALEXTPROC$MH.invokeExact(symbol, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


