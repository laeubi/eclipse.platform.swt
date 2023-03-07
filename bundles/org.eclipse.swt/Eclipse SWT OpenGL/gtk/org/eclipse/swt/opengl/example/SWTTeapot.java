package org.eclipse.swt.opengl.example;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.opengl.*;
import org.eclipse.swt.widgets.*;

import jdk.incubator.foreign.*;

public class SWTTeapot {

	public static void main(String [] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		Composite comp = new Composite(shell, SWT.NONE);
		comp.setLayout(new FillLayout());
		GLData data = new GLData ();
		data.doubleBuffer = true;
		final GLCanvas canvas = new GLCanvas(comp, SWT.NONE, data);

		canvas.setCurrent();
		shell.setText("SWT/Panama Example");
		shell.setSize(640, 480);
		shell.open();
		try (ResourceScope scope = ResourceScope.newConfinedScope()) {
 		   SegmentAllocator allocator = SegmentAllocator.newNativeArena(scope);
         var argc = allocator.allocate(ValueLayout.JAVA_INT, 0);
         org.eclipse.swt.opengl.GL.glutInit(argc, argc);
         org.eclipse.swt.opengl.GL.glutInitDisplayMode(org.eclipse.swt.opengl.GL.GLUT_DOUBLE() | org.eclipse.swt.opengl.GL.GLUT_RGB() | org.eclipse.swt.opengl.GL.GLUT_DEPTH());
         Teapot teapot = new Teapot(allocator);
         final Runnable run = new Runnable() {
        	 @Override
        	 public void run() {
        		 if (!canvas.isDisposed()) {
        			 canvas.setCurrent();
        			 teapot.doRotation();
        			 canvas.swapBuffers();
        			 display.asyncExec(this);
        		 }
        	 }
         };
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
