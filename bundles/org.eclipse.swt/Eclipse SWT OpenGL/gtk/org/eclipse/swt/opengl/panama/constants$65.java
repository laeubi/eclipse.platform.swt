// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$65 {

    static final FunctionDescriptor glGetCompressedTexImage$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_POINTER
    );
    static final MethodHandle glGetCompressedTexImage$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glGetCompressedTexImage",
        "(IILjdk/incubator/foreign/MemoryAddress;)V",
        constants$65.glGetCompressedTexImage$FUNC, false
    );
    static final FunctionDescriptor glMultiTexCoord1d$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_DOUBLE
    );
    static final MethodHandle glMultiTexCoord1d$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glMultiTexCoord1d",
        "(ID)V",
        constants$65.glMultiTexCoord1d$FUNC, false
    );
    static final FunctionDescriptor glMultiTexCoord1dv$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER
    );
    static final MethodHandle glMultiTexCoord1dv$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glMultiTexCoord1dv",
        "(ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$65.glMultiTexCoord1dv$FUNC, false
    );
    static final FunctionDescriptor glMultiTexCoord1f$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_FLOAT
    );
    static final MethodHandle glMultiTexCoord1f$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glMultiTexCoord1f",
        "(IF)V",
        constants$65.glMultiTexCoord1f$FUNC, false
    );
    static final FunctionDescriptor glMultiTexCoord1fv$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER
    );
    static final MethodHandle glMultiTexCoord1fv$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glMultiTexCoord1fv",
        "(ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$65.glMultiTexCoord1fv$FUNC, false
    );
    static final FunctionDescriptor glMultiTexCoord1i$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT
    );
    static final MethodHandle glMultiTexCoord1i$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glMultiTexCoord1i",
        "(II)V",
        constants$65.glMultiTexCoord1i$FUNC, false
    );
}


