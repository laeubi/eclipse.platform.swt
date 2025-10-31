/*******************************************************************************
 * Copyright (c) 2025 Eclipse Contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Initial implementation for CLI support
 *******************************************************************************/
package org.eclipse.swt.tools.internal;

/**
 * Command-line wrapper for JNIGeneratorApp that properly handles arguments.
 * This class provides a more robust CLI interface than the original main method.
 */
public class JNIGeneratorCLI {

	public static void main(String[] args) {
		if (args.length > 0 && (args[0].equals("-h") || args[0].equals("--help") || args[0].equals("help"))) {
			printUsage();
			return;
		}

		JNIGeneratorApp gen = new JNIGeneratorApp();
		
		// Handle "all" or "*" to generate for all platforms
		if (args.length == 1 && (args[0].equals("*") || args[0].equals("all"))) {
			gen.generateAll();
			return;
		}

		// Parse command line arguments
		String mainClassName = null;
		String outputDir = null;
		String classesDir = null;

		if (args.length > 0) {
			mainClassName = args[0];
		}
		if (args.length > 1) {
			outputDir = args[1];
		}
		if (args.length > 2) {
			classesDir = args[2];
		}

		// Validate required arguments
		if (mainClassName == null || outputDir == null) {
			System.err.println("Error: mainClassName and outputDir are required.");
			System.err.println();
			printUsage();
			System.exit(1);
		}

		// Set up the generator with proper argument order
		// Important: set output dir and classes dir BEFORE main class name
		gen.setOutputDir(outputDir);
		if (classesDir != null) {
			gen.setClassesDir(classesDir);
		}
		
		// Now set the main class name - this will work because outputDir is already set
		gen.setMainClassName(mainClassName, outputDir, classesDir);

		// Generate the JNI code
		gen.generate();
	}

	private static void printUsage() {
		System.out.println("JNI Generator - Generates C/JNI code from annotated Java classes");
		System.out.println();
		System.out.println("Usage:");
		System.out.println("  java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar <mainClassName> <outputDir> [classesDir]");
		System.out.println("  java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar all");
		System.out.println("  java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar --help");
		System.out.println();
		System.out.println("Arguments:");
		System.out.println("  mainClassName  - Fully qualified name of the main OS class");
		System.out.println("                   (e.g., org.eclipse.swt.internal.gtk.OS)");
		System.out.println("  outputDir      - Directory where generated C files will be written");
		System.out.println("                   (must end with / or \\)");
		System.out.println("  classesDir     - Optional: Directory containing Java source files");
		System.out.println("                   (defaults to parent of outputDir)");
		System.out.println("  all | *        - Generate for all platforms defined in metadata");
		System.out.println();
		System.out.println("Examples:");
		System.out.println("  # Generate GTK bindings to /path/to/library/");
		System.out.println("  java -jar swt-tools.jar org.eclipse.swt.internal.gtk.OS /path/to/library/");
		System.out.println();
		System.out.println("  # Generate with explicit source directory");
		System.out.println("  java -jar swt-tools.jar org.eclipse.swt.internal.gtk.OS \\");
		System.out.println("       /path/to/library/ /path/to/sources/");
		System.out.println();
		System.out.println("  # Generate for all configured platforms");
		System.out.println("  java -jar swt-tools.jar all");
	}
}
