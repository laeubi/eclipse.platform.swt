// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$43 {

    static final FunctionDescriptor glDrawPixels$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_POINTER
    );
    static final MethodHandle glDrawPixels$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glDrawPixels",
        "(IIIILjdk/incubator/foreign/MemoryAddress;)V",
        constants$43.glDrawPixels$FUNC, false
    );
    static final FunctionDescriptor glCopyPixels$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle glCopyPixels$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glCopyPixels",
        "(IIIII)V",
        constants$43.glCopyPixels$FUNC, false
    );
    static final FunctionDescriptor glStencilFunc$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle glStencilFunc$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glStencilFunc",
        "(III)V",
        constants$43.glStencilFunc$FUNC, false
    );
    static final FunctionDescriptor glStencilMask$FUNC = FunctionDescriptor.ofVoid(
        C_INT
    );
    static final MethodHandle glStencilMask$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glStencilMask",
        "(I)V",
        constants$43.glStencilMask$FUNC, false
    );
    static final FunctionDescriptor glStencilOp$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle glStencilOp$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glStencilOp",
        "(III)V",
        constants$43.glStencilOp$FUNC, false
    );
    static final FunctionDescriptor glClearStencil$FUNC = FunctionDescriptor.ofVoid(
        C_INT
    );
    static final MethodHandle glClearStencil$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glClearStencil",
        "(I)V",
        constants$43.glClearStencil$FUNC, false
    );
}


