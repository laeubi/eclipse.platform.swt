// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
class constants$966 {

    static final FunctionDescriptor jrand48$FUNC = FunctionDescriptor.of(Constants$root.C_LONG_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle jrand48$MH = RuntimeHelper.downcallHandle(
        "jrand48",
        constants$966.jrand48$FUNC, false
    );
    static final FunctionDescriptor srand48$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_LONG_LONG$LAYOUT
    );
    static final MethodHandle srand48$MH = RuntimeHelper.downcallHandle(
        "srand48",
        constants$966.srand48$FUNC, false
    );
    static final FunctionDescriptor seed48$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle seed48$MH = RuntimeHelper.downcallHandle(
        "seed48",
        constants$966.seed48$FUNC, false
    );
    static final FunctionDescriptor lcong48$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle lcong48$MH = RuntimeHelper.downcallHandle(
        "lcong48",
        constants$966.lcong48$FUNC, false
    );
    static final FunctionDescriptor drand48_r$FUNC = FunctionDescriptor.of(Constants$root.C_INT$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle drand48_r$MH = RuntimeHelper.downcallHandle(
        "drand48_r",
        constants$966.drand48_r$FUNC, false
    );
    static final FunctionDescriptor erand48_r$FUNC = FunctionDescriptor.of(Constants$root.C_INT$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle erand48_r$MH = RuntimeHelper.downcallHandle(
        "erand48_r",
        constants$966.erand48_r$FUNC, false
    );
}


