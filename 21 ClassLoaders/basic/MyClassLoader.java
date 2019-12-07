package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class MyClassLoader extends ClassLoader {

	// this classloader looks for files in the store
	String theStore;

	// public MyClassLoader(String myClasspath, String myStore) {
	public MyClassLoader(String theStore) {
		super(ClassLoader.class.getClassLoader());
		this.theStore = theStore;
	}

	public Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = null;
		String filename = null;
		try {
			String clsFile = name.replace('.', '/') + ".class";
			filename = theStore + "/" + clsFile;
			byte data[] = getBytes(filename);
			c = defineClass(name, data, 0, data.length);
			if (c == null)
				throw new ClassNotFoundException(name);
		} catch (IOException e) {
			throw new ClassNotFoundException("Error reading file: " + filename);
		}
		return c;
	}

	private byte[] getBytes(String filename) throws IOException {
		File file = new File(filename);
		long length = file.length();

		byte rawBytes[] = new byte[(int) length];

		FileInputStream fin = new FileInputStream(file);
		int bytesRead = fin.read(rawBytes);
		if (bytesRead != length)
			throw new IOException("Problem reading " + filename);
		fin.close();

		return rawBytes;
	}

	protected synchronized Class<?> loadClass(String className, boolean resolve)
			throws ClassNotFoundException {

		// check if class is already loaded
		Class<?> cls = findLoadedClass(className);
		if (cls != null) {
			return cls;
		}
		// delegate to parent
		try {
			cls = super.loadClass(className, resolve);
			if (cls != null) {
				return cls;
			}
		} catch (ClassNotFoundException e) {
			// ignore, must be in store
		}
		// look in the store
		try {
			cls = findClass(className);
			if (resolve) {
				resolveClass(cls);
			}
		} catch (Exception e) {
			cls = super.loadClass(className, resolve);
		}
		return cls;
	}

	public void listLoadedClasses() {
		Class<?> thisClass = this.getClass();
		System.out.println("Classloader: " + thisClass.getCanonicalName());
		while (thisClass != java.lang.ClassLoader.class) {
			thisClass = thisClass.getSuperclass();
		}
		try {
			java.lang.reflect.Field fldClasses = thisClass.getDeclaredField("classes");
			fldClasses.setAccessible(true);
			Vector<?> classes = (Vector<?>) fldClasses.get(this);
			for (Iterator<?> iter = classes.iterator(); iter.hasNext();) {
				System.out.println("   Loaded " + iter.next());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
