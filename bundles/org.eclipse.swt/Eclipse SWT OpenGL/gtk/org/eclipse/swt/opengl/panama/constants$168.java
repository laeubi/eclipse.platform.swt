// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$168 {

    static final FunctionDescriptor PFNGLBINDFRAMEBUFFERPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLBINDFRAMEBUFFERPROC$MH = RuntimeHelper.downcallHandle(
        "(II)V",
        constants$168.PFNGLBINDFRAMEBUFFERPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLDELETEFRAMEBUFFERSPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLDELETEFRAMEBUFFERSPROC$MH = RuntimeHelper.downcallHandle(
        "(ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$168.PFNGLDELETEFRAMEBUFFERSPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLGENFRAMEBUFFERSPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLGENFRAMEBUFFERSPROC$MH = RuntimeHelper.downcallHandle(
        "(ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$168.PFNGLGENFRAMEBUFFERSPROC$FUNC, false
    );
}


