// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$22 {

    static final FunctionDescriptor glColor4s$FUNC = FunctionDescriptor.ofVoid(
        C_SHORT,
        C_SHORT,
        C_SHORT,
        C_SHORT
    );
    static final MethodHandle glColor4s$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glColor4s",
        "(SSSS)V",
        constants$22.glColor4s$FUNC, false
    );
    static final FunctionDescriptor glColor4ub$FUNC = FunctionDescriptor.ofVoid(
        C_CHAR,
        C_CHAR,
        C_CHAR,
        C_CHAR
    );
    static final MethodHandle glColor4ub$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glColor4ub",
        "(BBBB)V",
        constants$22.glColor4ub$FUNC, false
    );
    static final FunctionDescriptor glColor4ui$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle glColor4ui$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glColor4ui",
        "(IIII)V",
        constants$22.glColor4ui$FUNC, false
    );
    static final FunctionDescriptor glColor4us$FUNC = FunctionDescriptor.ofVoid(
        C_SHORT,
        C_SHORT,
        C_SHORT,
        C_SHORT
    );
    static final MethodHandle glColor4us$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glColor4us",
        "(SSSS)V",
        constants$22.glColor4us$FUNC, false
    );
    static final FunctionDescriptor glColor3bv$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle glColor3bv$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glColor3bv",
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$22.glColor3bv$FUNC, false
    );
    static final FunctionDescriptor glColor3dv$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle glColor3dv$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glColor3dv",
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$22.glColor3dv$FUNC, false
    );
}


