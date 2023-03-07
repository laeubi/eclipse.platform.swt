// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$966 {

    static final FunctionDescriptor jrand48$FUNC = FunctionDescriptor.of(C_LONG,
        C_POINTER
    );
    static final MethodHandle jrand48$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "jrand48",
        "(Ljdk/incubator/foreign/MemoryAddress;)J",
        constants$966.jrand48$FUNC, false
    );
    static final FunctionDescriptor srand48$FUNC = FunctionDescriptor.ofVoid(
        C_LONG
    );
    static final MethodHandle srand48$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "srand48",
        "(J)V",
        constants$966.srand48$FUNC, false
    );
    static final FunctionDescriptor seed48$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER
    );
    static final MethodHandle seed48$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "seed48",
        "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$966.seed48$FUNC, false
    );
    static final FunctionDescriptor lcong48$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle lcong48$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "lcong48",
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$966.lcong48$FUNC, false
    );
    static final FunctionDescriptor drand48_r$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle drand48_r$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "drand48_r",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$966.drand48_r$FUNC, false
    );
    static final FunctionDescriptor erand48_r$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle erand48_r$MH = RuntimeHelper.downcallHandle(
        glut_h.LIBRARIES, "erand48_r",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$966.erand48_r$FUNC, false
    );
}


