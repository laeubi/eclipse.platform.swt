// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
class constants$922 {

    static final FunctionDescriptor gluBuild3DMipmaps$FUNC = FunctionDescriptor.of(Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle gluBuild3DMipmaps$MH = RuntimeHelper.downcallHandle(
        "gluBuild3DMipmaps",
        constants$922.gluBuild3DMipmaps$FUNC, false
    );
    static final FunctionDescriptor gluCheckExtension$FUNC = FunctionDescriptor.of(Constants$root.C_CHAR$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle gluCheckExtension$MH = RuntimeHelper.downcallHandle(
        "gluCheckExtension",
        constants$922.gluCheckExtension$FUNC, false
    );
    static final FunctionDescriptor gluCylinder$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_DOUBLE$LAYOUT,
        Constants$root.C_DOUBLE$LAYOUT,
        Constants$root.C_DOUBLE$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle gluCylinder$MH = RuntimeHelper.downcallHandle(
        "gluCylinder",
        constants$922.gluCylinder$FUNC, false
    );
    static final FunctionDescriptor gluDeleteNurbsRenderer$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle gluDeleteNurbsRenderer$MH = RuntimeHelper.downcallHandle(
        "gluDeleteNurbsRenderer",
        constants$922.gluDeleteNurbsRenderer$FUNC, false
    );
    static final FunctionDescriptor gluDeleteQuadric$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle gluDeleteQuadric$MH = RuntimeHelper.downcallHandle(
        "gluDeleteQuadric",
        constants$922.gluDeleteQuadric$FUNC, false
    );
    static final FunctionDescriptor gluDeleteTess$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle gluDeleteTess$MH = RuntimeHelper.downcallHandle(
        "gluDeleteTess",
        constants$922.gluDeleteTess$FUNC, false
    );
}


