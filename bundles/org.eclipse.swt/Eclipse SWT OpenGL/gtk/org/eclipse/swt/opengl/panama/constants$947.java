// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
class constants$947 {

    static final FunctionDescriptor glutMenuStatusFunc$callback$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle glutMenuStatusFunc$callback$MH = RuntimeHelper.downcallHandle(
        constants$947.glutMenuStatusFunc$callback$FUNC, false
    );
    static final FunctionDescriptor glutMenuStatusFunc$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle glutMenuStatusFunc$MH = RuntimeHelper.downcallHandle(
        "glutMenuStatusFunc",
        constants$947.glutMenuStatusFunc$FUNC, false
    );
    static final FunctionDescriptor glutOverlayDisplayFunc$callback$FUNC = FunctionDescriptor.ofVoid();
    static final MethodHandle glutOverlayDisplayFunc$callback$MH = RuntimeHelper.downcallHandle(
        constants$947.glutOverlayDisplayFunc$callback$FUNC, false
    );
    static final FunctionDescriptor glutOverlayDisplayFunc$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle glutOverlayDisplayFunc$MH = RuntimeHelper.downcallHandle(
        "glutOverlayDisplayFunc",
        constants$947.glutOverlayDisplayFunc$FUNC, false
    );
}


