// Generated by jextract

package org.eclipse.swt.opengl.panama;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$319 {

    static final FunctionDescriptor PFNGLCREATESYNCFROMCLEVENTARBPROC$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER,
        C_POINTER,
        C_INT
    );
    static final MethodHandle PFNGLCREATESYNCFROMCLEVENTARBPROC$MH = RuntimeHelper.downcallHandle(
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
        constants$319.PFNGLCREATESYNCFROMCLEVENTARBPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLCLAMPCOLORARBPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLCLAMPCOLORARBPROC$MH = RuntimeHelper.downcallHandle(
        "(II)V",
        constants$319.PFNGLCLAMPCOLORARBPROC$FUNC, false
    );
    static final FunctionDescriptor PFNGLDISPATCHCOMPUTEGROUPSIZEARBPROC$FUNC = FunctionDescriptor.ofVoid(
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_INT,
        C_INT
    );
    static final MethodHandle PFNGLDISPATCHCOMPUTEGROUPSIZEARBPROC$MH = RuntimeHelper.downcallHandle(
        "(IIIIII)V",
        constants$319.PFNGLDISPATCHCOMPUTEGROUPSIZEARBPROC$FUNC, false
    );
}


