// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$4 {

    static final FunctionDescriptor glEnable$FUNC = FunctionDescriptor.ofVoid(
        C_INT
    );
    static final MethodHandle glEnable$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glEnable",
        "(I)V",
        constants$4.glEnable$FUNC, false
    );
    static final FunctionDescriptor glDisable$FUNC = FunctionDescriptor.ofVoid(
        C_INT
    );
    static final MethodHandle glDisable$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glDisable",
        "(I)V",
        constants$4.glDisable$FUNC, false
    );
    static final FunctionDescriptor glIsEnabled$FUNC = FunctionDescriptor.of(C_CHAR,
        C_INT
    );
    static final MethodHandle glIsEnabled$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glIsEnabled",
        "(I)B",
        constants$4.glIsEnabled$FUNC, false
    );
    static final FunctionDescriptor glEnableClientState$FUNC = FunctionDescriptor.ofVoid(
        C_INT
    );
    static final MethodHandle glEnableClientState$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glEnableClientState",
        "(I)V",
        constants$4.glEnableClientState$FUNC, false
    );
    static final FunctionDescriptor glDisableClientState$FUNC = FunctionDescriptor.ofVoid(
        C_INT
    );
    static final MethodHandle glDisableClientState$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glDisableClientState",
        "(I)V",
        constants$4.glDisableClientState$FUNC, false
    );
    static final FunctionDescriptor glGetBooleanv$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER
    );
    static final MethodHandle glGetBooleanv$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "glGetBooleanv",
        "(ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$4.glGetBooleanv$FUNC, false
    );
}


