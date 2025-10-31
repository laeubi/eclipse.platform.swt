# SWT Tools

This bundle provides various development tools for Eclipse SWT (Standard Widget Toolkit).

## Available Tools

### JNI Generator

The JNI Generator is the primary tool in this bundle. It automatically generates native C/JNI code from annotated Java classes, significantly reducing the manual effort required to maintain JNI bindings.

#### What it does

The JNI Generator:
- Scans Java source files for native methods and annotated classes
- Generates corresponding C header files (`*.h`)
- Generates C implementation files (`*.c`) with JNI wrapper code
- Generates structs header and implementation files for data structures
- Generates statistics tracking code for native method calls
- Updates metadata files used for code generation

#### Location

The JNI Generator source code is located in:
```
bundles/org.eclipse.swt.tools/JNI Generation/org/eclipse/swt/tools/internal/
```

Key classes:
- `JNIGeneratorApp.java` - Main entry point with CLI support
- `JNIGenerator.java` - Base generator class
- `NativesGenerator.java` - Generates native method wrappers
- `StructsGenerator.java` - Generates struct accessors
- `MetaDataGenerator.java` - Generates metadata files
- `StatsGenerator.java` - Generates statistics tracking code

#### Usage in Eclipse IDE

The JNI Generator is integrated into Eclipse as a builder:
1. Configure the builder in your Eclipse project
2. The generator runs automatically when Java source files change
3. It regenerates the native code based on annotations in the Java code

#### Command Line Usage

You can run the JNI Generator from the command line using the provided fat jar:

```bash
# Generate for default platform (current OS)
java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar

# Generate for specific main class
java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar <mainClassName>

# Generate with custom output directory
java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar <mainClassName> <outputDir>

# Generate with custom classpath
java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar <mainClassName> <outputDir> <classpath>

# Generate all configured platforms
java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar all
```

**Parameters:**
- `mainClassName` - Fully qualified name of the main OS class (e.g., `org.eclipse.swt.internal.gtk.OS`)
- `outputDir` - Directory where generated files will be written
- `classpath` - Custom classpath for finding source files (optional, uses system classpath by default)
- `all` or `*` - Generate for all platforms defined in metadata

**Example:**
```bash
# Generate GTK bindings
java -jar org.eclipse.swt.tools-<version>-jar-with-dependencies.jar \
  org.eclipse.swt.internal.gtk.OS \
  /path/to/swt/gtk/library/
```

#### Building the Fat Jar

To build the standalone JAR with all dependencies:

```bash
cd bundles/org.eclipse.swt.tools
mvn clean package
```

The fat jar will be created at:
```
target/org.eclipse.swt.tools-<version>-jar-with-dependencies.jar
```

#### How it Works

1. **Source Scanning**: The generator reads Java source files using the Eclipse JDT Abstract Syntax Tree (AST) parser
2. **Metadata Processing**: It reads metadata from `.properties` files that contain generation directives and custom mappings
3. **Code Generation**: Based on annotations and metadata, it generates:
   - Native method signatures in C
   - JNI function implementations
   - Structure field accessors
   - Type conversions between Java and C
4. **File Output**: Generated files are written to the specified output directory, typically the platform-specific `library/` folder

#### Annotations and Metadata

The generator uses special annotations in Java source files:
- Method flags (e.g., `@flags=no_gen` to skip generation)
- Parameter mappings (e.g., array types, buffer types)
- Custom C code snippets
- Structure field mappings

Metadata is stored in `.properties` files in the same package as the Java sources.

### Other Tools

- **Mac Generator**: Tools for generating macOS-specific bindings (located in `Mac Generation/`)
- **Icon Exe**: Windows icon embedding tools (located in `Icon Exe/`)
- **JavadocBasher**: Javadoc processing utilities (located in `JavadocBasher/`)

## Dependencies

The JNI Generator requires:
- Java 17 or later
- Eclipse JDT Core (for AST parsing)
- SWT library (for platform detection)

## Development

This is an Eclipse plugin bundle and can be developed using:
- Eclipse IDE with Plugin Development Environment (PDE)
- Maven with Tycho for command-line builds

## License

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0 which accompanies this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/

SPDX-License-Identifier: EPL-2.0
