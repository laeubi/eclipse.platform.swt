# Linux / GTK OpenGL bindings

## How to generate the bindings

1. Install the headers, e.g. `sudo apt-get install libglu1-mesa-dev freeglut3-dev mesa-common-dev`
2. get a suitable jextract from https://jdk.java.net/panama/ (Java 19) or https://jdk.java.net/panama/17/ (Java 17)
3. go into folder `<your swt checkout>/org.eclipse.swt/Eclipse SWT OpenGL/gtk`
4. `jextract --source -I /usr/include/GL -t org.eclipse.swt.opengl.panama /usr/include/GL/glut.h`

## Current Warnings (to be reported to panama project!

WARNING: Using incubator modules: jdk.incubator.foreign, jdk.incubator.jextract
WARNING: skipping .__clang_max_align_nonce2 because of unsupported type usage: long double
WARNING: skipping strtold because of unsupported type usage: long double
WARNING: skipping qecvt because of unsupported type usage: long double
WARNING: skipping qfcvt because of unsupported type usage: long double
WARNING: skipping qgcvt because of unsupported type usage: long double
WARNING: skipping qecvt_r because of unsupported type usage: long double
WARNING: skipping qfcvt_r because of unsupported type usage: long double

## what libs to include?!

-l opengl32 `
  "-l" glu32 `
  "-l" freeglut `