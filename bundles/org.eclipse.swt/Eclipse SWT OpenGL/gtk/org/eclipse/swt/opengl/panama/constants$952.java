// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
class constants$952 {

    static final FunctionDescriptor glutGet$FUNC = FunctionDescriptor.of(Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle glutGet$MH = RuntimeHelper.downcallHandle(
        "glutGet",
        constants$952.glutGet$FUNC, false
    );
    static final FunctionDescriptor glutDeviceGet$FUNC = FunctionDescriptor.of(Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle glutDeviceGet$MH = RuntimeHelper.downcallHandle(
        "glutDeviceGet",
        constants$952.glutDeviceGet$FUNC, false
    );
    static final FunctionDescriptor glutGetModifiers$FUNC = FunctionDescriptor.of(Constants$root.C_INT$LAYOUT);
    static final MethodHandle glutGetModifiers$MH = RuntimeHelper.downcallHandle(
        "glutGetModifiers",
        constants$952.glutGetModifiers$FUNC, false
    );
    static final FunctionDescriptor glutLayerGet$FUNC = FunctionDescriptor.of(Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle glutLayerGet$MH = RuntimeHelper.downcallHandle(
        "glutLayerGet",
        constants$952.glutLayerGet$FUNC, false
    );
    static final FunctionDescriptor glutBitmapCharacter$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle glutBitmapCharacter$MH = RuntimeHelper.downcallHandle(
        "glutBitmapCharacter",
        constants$952.glutBitmapCharacter$FUNC, false
    );
    static final FunctionDescriptor glutBitmapWidth$FUNC = FunctionDescriptor.of(Constants$root.C_INT$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle glutBitmapWidth$MH = RuntimeHelper.downcallHandle(
        "glutBitmapWidth",
        constants$952.glutBitmapWidth$FUNC, false
    );
}


