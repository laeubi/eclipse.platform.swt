// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$846 {

    static final FunctionDescriptor PFNGLPROGRAMPARAMETER4FNVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_FLOAT,
        C_FLOAT,
        C_FLOAT,
        C_FLOAT
    );
    static final MethodHandle PFNGLPROGRAMPARAMETER4FNVPROC$MH = RuntimeHelper.downcallHandle(
        "(IIFFFF)V",
        constants$846.PFNGLPROGRAMPARAMETER4FNVPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLPROGRAMPARAMETER4FVNVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLPROGRAMPARAMETER4FVNVPROC$MH = RuntimeHelper.downcallHandle(
        "(IILjdk/incubator/foreign/MemoryAddress;)V",
        constants$846.PFNGLPROGRAMPARAMETER4FVNVPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLPROGRAMPARAMETERS4DVNVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLPROGRAMPARAMETERS4DVNVPROC$MH = RuntimeHelper.downcallHandle(
        "(IIILjdk/incubator/foreign/MemoryAddress;)V",
        constants$846.PFNGLPROGRAMPARAMETERS4DVNVPROC$FUNC, false
    );
}


