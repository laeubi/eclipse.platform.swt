// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$596 {

    static final FunctionDescriptor PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEEXTPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEEXTPROC$MH = RuntimeHelper.downcallHandle(
        "(IIIII)V",
        constants$596.PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEEXTPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLECOVERAGEEXTPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLECOVERAGEEXTPROC$MH = RuntimeHelper.downcallHandle(
        "(IIIIII)V",
        constants$596.PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLECOVERAGEEXTPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLCHECKNAMEDFRAMEBUFFERSTATUSEXTPROC$FUNC = FunctionDescriptor.of(C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLCHECKNAMEDFRAMEBUFFERSTATUSEXTPROC$MH = RuntimeHelper.downcallHandle(
        "(II)I",
        constants$596.PFNGLCHECKNAMEDFRAMEBUFFERSTATUSEXTPROC$FUNC, false
    );
}


