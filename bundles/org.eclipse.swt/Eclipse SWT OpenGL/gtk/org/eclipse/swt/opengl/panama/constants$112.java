// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$112 {

    static final FunctionDescriptor PFNGLMAPBUFFERPROC$FUNC = FunctionDescriptor.of(C_POINTER,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLMAPBUFFERPROC$MH = RuntimeHelper.downcallHandle(
        "(II)Ljdk/incubator/foreign/MemoryAddress;",
        constants$112.PFNGLMAPBUFFERPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLUNMAPBUFFERPROC$FUNC = FunctionDescriptor.of(C_CHAR,
        C_INT
    );
    static final MethodHandle PFNGLUNMAPBUFFERPROC$MH = RuntimeHelper.downcallHandle(
        "(I)B",
        constants$112.PFNGLUNMAPBUFFERPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLGETBUFFERPARAMETERIVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLGETBUFFERPARAMETERIVPROC$MH = RuntimeHelper.downcallHandle(
        "(IILjdk/incubator/foreign/MemoryAddress;)V",
        constants$112.PFNGLGETBUFFERPARAMETERIVPROC$FUNC, false
    );
}


