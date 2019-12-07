package CompilingClassloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class MyClassLoader extends ClassLoader {

	private byte[] getBytes(String filename) throws IOException {
		File file = new File(filename);
		long len = file.length();

		byte raw[] = new byte[(int) len];

		FileInputStream fin = new FileInputStream(file);
		int r = fin.read(raw);
		try {
			if (r != len)
				throw new IOException("Can't read all, " + r + " != " + len);
		} finally {
			fin.close();
		}

		return raw;
	}

	private boolean compileSource(String javaFile) throws IOException {
		System.out.println("Compiling " + javaFile + " ...");

		java.util.Properties props = System.getProperties();
		String javaCompiler = (String) props.get("java.home");
		if (javaCompiler == null) {
			System.out.println("Can't determine where to find javac");
			System.exit(1);
		}
		javaCompiler += "/../bin/javac";
		String currentDirectory = new File(".").getCanonicalPath();
		javaFile = currentDirectory + "/" + javaFile;
		ProcessBuilder pb = new ProcessBuilder(javaCompiler, javaFile);
		Map<String, String> env = pb.environment();
		// put "." on the classpath
		String theCLASSPATH = new File(".").getCanonicalPath();
		env.put("CLASSPATH", theCLASSPATH);
		Process p = pb.start();

		try {
			p.waitFor();
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}

		int ret = p.exitValue();
		return ret == 0;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class loadClass(String name, boolean resolve) throws ClassNotFoundException {

		System.out.println("*** Attempting to load class: " + name);

		// check if the class has already been loaded
		Class theClass = findLoadedClass(name);
		if (theClass != null) return theClass;

		// class still needs to be loaded

		// determine source and compiled filenames
		String fileStub = name.replace('.', '/');
		String javaFilename = fileStub + ".java";
		String classFilename = fileStub + ".class";

		File javaFile = new File(javaFilename);
		File classFile = new File(classFilename);

		boolean mustCompile = false;
		// 1. Source exists, compiled file doesn't exist
		if (javaFile.exists() && !classFile.exists()) {
			System.out.println("+++ No '.class' file - must compile");
			mustCompile = true;
		}
		// 2. Source timestamp is later than compiled file's timestamp
		else if (javaFile.lastModified() > classFile.lastModified()) {
			System.out.println("+++ Source has been edited - must recomplile");
			mustCompile = true;
		}

		if(mustCompile) compile(javaFilename, classFile);

		try {
			// read bytes from compiled file and determine class
			byte raw[] = getBytes(classFilename);
			// convert raw bytes to class
			theClass = defineClass(name, raw, 0, raw.length);
			System.out.println("*** read byte code for: " + name + " ***");
		} catch (IOException ie) {
			// ignore failures (parent classloader will be called
		}

		if (theClass == null) {
			// we have failed to load the class, so try parent class loader
			System.out.println("\tdelegating to system classloader");
			theClass = findSystemClass(name);
		}

		// resolve class (load referenced classes)
		if (resolve && theClass != null) resolveClass(theClass);

		// return class if found
		if (theClass == null) throw new ClassNotFoundException(name);

		System.out.println("\tclass loaded: " + name);
		return theClass;
	}

	private void compile(String javaFilename, File classFile)
			throws ClassNotFoundException {
		try {
			// try to compile source
			if (!compileSource(javaFilename) || !classFile.exists()) {
				throw new ClassNotFoundException("Compile failed: "
						+ javaFilename);
			}
		} catch (IOException e) {
			throw new ClassNotFoundException(e.toString());
		}
	}
}
