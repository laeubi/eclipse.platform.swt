// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public interface PFNGLLGPUCOPYIMAGESUBDATANVXPROC {

    void apply(int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9, int x10, int x11, int x12, int x13, int x14, int x15, int x16);
    static NativeSymbol allocate(PFNGLLGPUCOPYIMAGESUBDATANVXPROC fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(PFNGLLGPUCOPYIMAGESUBDATANVXPROC.class, fi, constants$721.PFNGLLGPUCOPYIMAGESUBDATANVXPROC$FUNC, "(IIIIIIIIIIIIIIIII)V", scope);
    }
    static PFNGLLGPUCOPYIMAGESUBDATANVXPROC ofAddress(MemoryAddress addr, ResourceScope scope) {
        NativeSymbol symbol = NativeSymbol.ofAddress("PFNGLLGPUCOPYIMAGESUBDATANVXPROC::" + Long.toHexString(addr.toRawLongValue()), addr, scope);
return (int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9, int x10, int x11, int x12, int x13, int x14, int x15, int x16) -> {
            try {
                constants$721.PFNGLLGPUCOPYIMAGESUBDATANVXPROC$MH.invokeExact(symbol, x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


