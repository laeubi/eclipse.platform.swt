// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$827 {

    static final FunctionDescriptor PFNGLVDPAUISSURFACENVPROC$FUNC = FunctionDescriptor.of(C_CHAR,
        C_LONG
    );
    static final MethodHandle PFNGLVDPAUISSURFACENVPROC$MH = RuntimeHelper.downcallHandle(
        "(J)B",
        constants$827.PFNGLVDPAUISSURFACENVPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLVDPAUUNREGISTERSURFACENVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_LONG
    );
    static final MethodHandle PFNGLVDPAUUNREGISTERSURFACENVPROC$MH = RuntimeHelper.downcallHandle(
        "(J)V",
        constants$827.PFNGLVDPAUUNREGISTERSURFACENVPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLVDPAUGETSURFACEIVNVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_LONG,
        C_INT,
        C_INT,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle PFNGLVDPAUGETSURFACEIVNVPROC$MH = RuntimeHelper.downcallHandle(
        "(JIILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$827.PFNGLVDPAUGETSURFACEIVNVPROC$FUNC, false
    );
}


