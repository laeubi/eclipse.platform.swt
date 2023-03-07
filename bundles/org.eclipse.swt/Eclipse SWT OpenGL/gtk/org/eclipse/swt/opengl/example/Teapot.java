package org.eclipse.swt.opengl.example;
/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import jdk.incubator.foreign.*;
// --add-modules jdk.incubator.foreign -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/ --enable-native-access=ALL-UNNAMED
public class Teapot {
    private float rot = 0;

    public Teapot(SegmentAllocator allocator) {
        // Reset Background
    	org.eclipse.swt.opengl.GL.glClearColor(0f, 0f, 0f, 0f);
        // Setup Lighting
    	org.eclipse.swt.opengl.GL.glShadeModel(org.eclipse.swt.opengl.GL.GL_SMOOTH());
        var pos = allocator.allocateArray(org.eclipse.swt.opengl.GL.C_FLOAT, new float[] {0.0f, 15.0f, -15.0f, 0});
        org.eclipse.swt.opengl.GL.glLightfv(org.eclipse.swt.opengl.GL.GL_LIGHT0(), org.eclipse.swt.opengl.GL.GL_POSITION(), pos);
        var spec = allocator.allocateArray(org.eclipse.swt.opengl.GL.C_FLOAT, new float[] {1, 1, 1, 0});
        org.eclipse.swt.opengl.GL.glLightfv(org.eclipse.swt.opengl.GL.GL_LIGHT0(), org.eclipse.swt.opengl.GL.GL_AMBIENT(), spec);
        org.eclipse.swt.opengl.GL.glLightfv(org.eclipse.swt.opengl.GL.GL_LIGHT0(), org.eclipse.swt.opengl.GL.GL_DIFFUSE(), spec);
        org.eclipse.swt.opengl.GL.glLightfv(org.eclipse.swt.opengl.GL.GL_LIGHT0(), org.eclipse.swt.opengl.GL.GL_SPECULAR(), spec);
        var shini = allocator.allocate(org.eclipse.swt.opengl.GL.C_FLOAT, 113);
        org.eclipse.swt.opengl.GL.glMaterialfv(org.eclipse.swt.opengl.GL.GL_FRONT(), org.eclipse.swt.opengl.GL.GL_SHININESS(), shini);
        org.eclipse.swt.opengl.GL.glEnable(org.eclipse.swt.opengl.GL.GL_LIGHTING());
        org.eclipse.swt.opengl.GL.glEnable(org.eclipse.swt.opengl.GL.GL_LIGHT0());
        org.eclipse.swt.opengl.GL.glEnable(org.eclipse.swt.opengl.GL.GL_DEPTH_TEST());
    }

    public void display() {
    	org.eclipse.swt.opengl.GL.glClear(org.eclipse.swt.opengl.GL.GL_COLOR_BUFFER_BIT() | org.eclipse.swt.opengl.GL.GL_DEPTH_BUFFER_BIT());
        org.eclipse.swt.opengl.GL.glPushMatrix();
        org.eclipse.swt.opengl.GL.glRotatef(-20f, 1f, 1f, 0f);
        org.eclipse.swt.opengl.GL.glRotatef(rot, 0f, 1f, 0f);
        org.eclipse.swt.opengl.GL.glutSolidTeapot(0.5d);
        org.eclipse.swt.opengl.GL.glPopMatrix();
        org.eclipse.swt.opengl.GL.glutSwapBuffers();
    }

    public void onIdle() {
        rot += 0.1;
        org.eclipse.swt.opengl.GL.glutPostRedisplay();
    }

    public static void main(String[] args) {
    	//TODO should be args for jextract: -l glut -l GLU -l GL
    	 System.loadLibrary("GL");
    	 System.loadLibrary("GLX");
    	 System.loadLibrary("GLU");
    	 System.loadLibrary("glut");
//        try (var scope = MemorySession.openConfined()) {
//            var allocator = SegmentAllocator.newNativeArena(scope);
    	try (ResourceScope scope = ResourceScope.newConfinedScope()) {
    		   SegmentAllocator allocator = SegmentAllocator.newNativeArena(scope);
            var argc = allocator.allocate(ValueLayout.JAVA_INT, 0);
            org.eclipse.swt.opengl.GL.glutInit(argc, argc);
            org.eclipse.swt.opengl.GL.glutInitDisplayMode(org.eclipse.swt.opengl.GL.GLUT_DOUBLE() | org.eclipse.swt.opengl.GL.GLUT_RGB() | org.eclipse.swt.opengl.GL.GLUT_DEPTH());
            org.eclipse.swt.opengl.GL.glutInitWindowSize(500, 500);
            org.eclipse.swt.opengl.GL.glutCreateWindow(allocator.allocateUtf8String("Hello Panama!"));
            var teapot = new Teapot(allocator);
            NativeSymbol displayStub = org.eclipse.swt.opengl.panama.glutDisplayFunc$callback.allocate(teapot::display, scope);
            NativeSymbol idleStub = org.eclipse.swt.opengl.panama.glutIdleFunc$callback.allocate(teapot::onIdle, scope);
//            var displayStub = org.eclipse.swt.opengl.GL.glutDisplayFunc$func.allocate(teapot::display, scope);
//            var idleStub = org.eclipse.swt.opengl.GL.glutIdleFunc$func.allocate(teapot::onIdle, scope);

            org.eclipse.swt.opengl.GL.glutDisplayFunc(displayStub);
            org.eclipse.swt.opengl.GL.glutIdleFunc(idleStub);
            org.eclipse.swt.opengl.GL.glutMainLoop();
        }
    }
}
