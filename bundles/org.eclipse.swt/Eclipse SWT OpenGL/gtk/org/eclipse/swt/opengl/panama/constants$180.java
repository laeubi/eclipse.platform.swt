// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$180 {

    static final FunctionDescriptor PFNGLDRAWELEMENTSINSTANCEDBASEVERTEXPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_POINTER,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLDRAWELEMENTSINSTANCEDBASEVERTEXPROC$MH = RuntimeHelper.downcallHandle(
        "(IIILjdk/incubator/foreign/MemoryAddress;II)V",
        constants$180.PFNGLDRAWELEMENTSINSTANCEDBASEVERTEXPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLMULTIDRAWELEMENTSBASEVERTEXPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER,
        C_INT,
        C_POINTER,
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLMULTIDRAWELEMENTSBASEVERTEXPROC$MH = RuntimeHelper.downcallHandle(
        "(ILjdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$180.PFNGLMULTIDRAWELEMENTSBASEVERTEXPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLPROVOKINGVERTEXPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT
    );
    static final MethodHandle PFNGLPROVOKINGVERTEXPROC$MH = RuntimeHelper.downcallHandle(
        "(I)V",
        constants$180.PFNGLPROVOKINGVERTEXPROC$FUNC, false
    );
}


