// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
class constants$124 {

    static final FunctionDescriptor PFNGLISSHADERPROC$FUNC = FunctionDescriptor.of(Constants$root.C_CHAR$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle PFNGLISSHADERPROC$MH = RuntimeHelper.downcallHandle(
        constants$124.PFNGLISSHADERPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLLINKPROGRAMPROC$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle PFNGLLINKPROGRAMPROC$MH = RuntimeHelper.downcallHandle(
        constants$124.PFNGLLINKPROGRAMPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLSHADERSOURCEPROC$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle PFNGLSHADERSOURCEPROC$MH = RuntimeHelper.downcallHandle(
        constants$124.PFNGLSHADERSOURCEPROC$FUNC, false
    );
}


