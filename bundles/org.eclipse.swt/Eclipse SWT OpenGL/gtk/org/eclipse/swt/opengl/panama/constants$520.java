// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$520 {

    static final FunctionDescriptor PFNGLCOPYCOLORSUBTABLEEXTPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLCOPYCOLORSUBTABLEEXTPROC$MH = RuntimeHelper.downcallHandle(
        "(IIIII)V",
        constants$520.PFNGLCOPYCOLORSUBTABLEEXTPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLLOCKARRAYSEXTPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLLOCKARRAYSEXTPROC$MH = RuntimeHelper.downcallHandle(
        "(II)V",
        constants$520.PFNGLLOCKARRAYSEXTPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLUNLOCKARRAYSEXTPROC$FUNC = FunctionDescriptor.ofVoid();
    static final MethodHandle PFNGLUNLOCKARRAYSEXTPROC$MH = RuntimeHelper.downcallHandle(
        "()V",
        constants$520.PFNGLUNLOCKARRAYSEXTPROC$FUNC, false
    );
}


