package org.eclipse.swt.opengl.example;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.opengl.*;
import org.eclipse.swt.widgets.*;

import jdk.incubator.foreign.*;
// --add-modules jdk.incubator.foreign
//--enable-native-access=ALL-UNNAMED
//-Djava.library.path=.:/usr/lib/x86_64-linux-gnu/:/opt/eclipse/platform-sdk/git/eclipse.platform.swt.binaries/bundles/org.eclipse.swt.gtk.linux.x86_64
public class SWTTeapot {

	public static void main(String [] args) {
		System.loadLibrary("GL");
		System.loadLibrary("GLX");
		System.loadLibrary("GLU");
		System.loadLibrary("glut");
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		Composite comp = new Composite(shell, SWT.NONE);
		comp.setLayout(new FillLayout());
		GLData data = new GLData ();
		data.doubleBuffer = true;
		final GLCanvas canvas = new GLCanvas(comp, SWT.NONE, data);
		try (ResourceScope scope = ResourceScope.newConfinedScope()) {
 		   SegmentAllocator allocator = SegmentAllocator.newNativeArena(scope);
         var argc = allocator.allocate(ValueLayout.JAVA_INT, 0);
         canvas.addListener(SWT.Resize, event -> {
 			Rectangle bounds = canvas.getBounds();
 			float fAspect = (float) bounds.width / (float) bounds.height;
 			canvas.setCurrent();
 			org.eclipse.swt.opengl.GL.glViewport(0, 0, bounds.width, bounds.height);
 		});
         canvas.setCurrent();
         org.eclipse.swt.opengl.GL.glutInit(argc, argc);
         org.eclipse.swt.opengl.GL.glutInitDisplayMode(org.eclipse.swt.opengl.GL.GLUT_DOUBLE() | org.eclipse.swt.opengl.GL.GLUT_RGB() | org.eclipse.swt.opengl.GL.GLUT_DEPTH());
     	org.eclipse.swt.opengl.GL.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		org.eclipse.swt.opengl.GL.glColor3f(1.0f, 0.0f, 0.0f);
		org.eclipse.swt.opengl.GL.glHint(org.eclipse.swt.opengl.GL.GL_PERSPECTIVE_CORRECTION_HINT(), org.eclipse.swt.opengl.GL.GL_NICEST());
		org.eclipse.swt.opengl.GL.glClearDepth(1.0);
		org.eclipse.swt.opengl.GL.glLineWidth(2);
		org.eclipse.swt.opengl.GL.glEnable(org.eclipse.swt.opengl.GL.GL_DEPTH_TEST());
         Teapot teapot = new Teapot(allocator);
         final Runnable run = new Runnable() {
        	 @Override
        	 public void run() {
        		 if (!canvas.isDisposed()) {
        			 canvas.setCurrent();
        			 teapot.draw();
        			 teapot.doRotation();
        			 org.eclipse.swt.opengl.GL.glEnd();
        			 canvas.swapBuffers();
        			 display.asyncExec(this);
        		 }
        	 }
         };
         shell.setText("SWT/Panama Example");
         shell.setSize(640, 480);
         shell.open();
         canvas.addListener(SWT.Paint, event -> run.run());
         display.asyncExec(run);

         while (!shell.isDisposed()) {
        	 if (!display.readAndDispatch())
        		 display.sleep();
         }
         display.dispose();
     }
	}
}
