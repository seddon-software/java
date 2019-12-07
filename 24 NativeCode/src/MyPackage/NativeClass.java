////////////////////////////////////////////////////////////
//
//    Native Methods
//
////////////////////////////////////////////////////////////

package MyPackage;

public class NativeClass {

	static {
		System.out.println("Working Directory = "
				+ System.getProperty("user.dir"));
		System.loadLibrary("MySharedLib");
	}

	int myVal = 100;

	public void normalMethod() {
		System.out.println("A normal method");
	}

	public native void nativeMethod();

	public native void UseEnv();

	public native int Square(int i);

	public native String getLine(String prompt);

	public native int sumArray(int arr[]);

	public native void accessObject();

	public native void makeCallback(int depth);

	private void callback(int depth) {
		System.out.println("Callback with depth = " + depth);
	}

	public native void checkForException(int x) throws IllegalArgumentException;
}
