// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$285 {

    static final FunctionDescriptor PFNGLNAMEDRENDERBUFFERSTORAGEPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLNAMEDRENDERBUFFERSTORAGEPROC$MH = RuntimeHelper.downcallHandle(
        "(IIII)V",
        constants$285.PFNGLNAMEDRENDERBUFFERSTORAGEPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEPROC$MH = RuntimeHelper.downcallHandle(
        "(IIIII)V",
        constants$285.PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLGETNAMEDRENDERBUFFERPARAMETERIVPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_POINTER
    );
    static final MethodHandle PFNGLGETNAMEDRENDERBUFFERPARAMETERIVPROC$MH = RuntimeHelper.downcallHandle(
        "(IILjdk/incubator/foreign/MemoryAddress;)V",
        constants$285.PFNGLGETNAMEDRENDERBUFFERPARAMETERIVPROC$FUNC, false
    );
}


