// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$477 {

    static final FunctionDescriptor PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER,
        C_POINTER,
        C_INT
    );
    static final MethodHandle PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC$MH = RuntimeHelper.downcallHandle(
        "(ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$477.PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLMULTIDRAWRANGEELEMENTARRAYAPPLEPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_POINTER,
        C_POINTER,
        C_INT
    );
    static final MethodHandle PFNGLMULTIDRAWRANGEELEMENTARRAYAPPLEPROC$MH = RuntimeHelper.downcallHandle(
        "(IIILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$477.PFNGLMULTIDRAWRANGEELEMENTARRAYAPPLEPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLGENFENCESAPPLEPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLGENFENCESAPPLEPROC$MH = RuntimeHelper.downcallHandle(
        "(ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$477.PFNGLGENFENCESAPPLEPROC$FUNC, false
    );
}


