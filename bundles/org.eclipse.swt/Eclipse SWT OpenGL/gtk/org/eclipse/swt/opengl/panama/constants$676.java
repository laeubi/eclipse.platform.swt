// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$676 {

    static final FunctionDescriptor PFNGLTRANSFORMFEEDBACKVARYINGSEXTPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_POINTER,
        C_INT
    );
    static final MethodHandle PFNGLTRANSFORMFEEDBACKVARYINGSEXTPROC$MH = RuntimeHelper.downcallHandle(
        "(IILjdk/incubator/foreign/MemoryAddress;I)V",
        constants$676.PFNGLTRANSFORMFEEDBACKVARYINGSEXTPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLGETTRANSFORMFEEDBACKVARYINGEXTPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_POINTER,
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle PFNGLGETTRANSFORMFEEDBACKVARYINGEXTPROC$MH = RuntimeHelper.downcallHandle(
        "(IIILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$676.PFNGLGETTRANSFORMFEEDBACKVARYINGEXTPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLARRAYELEMENTEXTPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT
    );
    static final MethodHandle PFNGLARRAYELEMENTEXTPROC$MH = RuntimeHelper.downcallHandle(
        "(I)V",
        constants$676.PFNGLARRAYELEMENTEXTPROC$FUNC, false
    );
}


