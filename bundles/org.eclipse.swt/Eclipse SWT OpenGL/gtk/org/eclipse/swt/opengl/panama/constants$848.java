// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$848 {

    static final FunctionDescriptor PFNGLVERTEXATTRIBPOINTERNVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLVERTEXATTRIBPOINTERNVPROC$MH = RuntimeHelper.downcallHandle(
        "(IIIILjdk/incubator/foreign/MemoryAddress;)V",
        constants$848.PFNGLVERTEXATTRIBPOINTERNVPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLVERTEXATTRIB1DNVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_DOUBLE
    );
    static final MethodHandle PFNGLVERTEXATTRIB1DNVPROC$MH = RuntimeHelper.downcallHandle(
        "(ID)V",
        constants$848.PFNGLVERTEXATTRIB1DNVPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLVERTEXATTRIB1DVNVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLVERTEXATTRIB1DVNVPROC$MH = RuntimeHelper.downcallHandle(
        "(ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$848.PFNGLVERTEXATTRIB1DVNVPROC$FUNC, false
    );
}


