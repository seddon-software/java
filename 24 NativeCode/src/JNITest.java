////////////////////////////////////////////////////////////
//
//    Native Methods
//
////////////////////////////////////////////////////////////

import MyPackage.NativeClass;

public class JNITest {

  
  public static void main(String[] args) {
    String libraryPath = System.getProperty("java.library.path","."); 
    System.out.println ("library path = " + libraryPath);
    // on Windows:	MySharedLib.dll
    // on Linux:		libMySharedLib.so
    // on MacOS:		libMySharedLib.jnilib
    System.loadLibrary("MySharedLib"); 
   
    NativeClass jni = new NativeClass();

// normal call
    jni.normalMethod();

// calling a native method
    jni.nativeMethod();

// accessing the JNIEnv
    System.out.print("JNIEnv Version: ");
    jni.UseEnv();

// passing parameters
    System.out.println("Square: " + jni.Square(7));

// passing Java strings
    String s = jni.getLine("Enter string: ");
    System.out.println("\tYou entered " + s);

// working with Java arrays
    int primes[] = new int[5];
    primes[0] = 2;
    primes[1] = 3;
    primes[2] = 5;
    primes[3] = 7;
    primes[4] = 11;
    int total = jni.sumArray(primes);
    System.out.println("Sum of primes = " + total);

// accessing instance variables from C++
    jni.accessObject();

// calling Java methods from inside a native method
    jni.makeCallback(6);

// throwing exceptions from C++
    jni.checkForException(-10);
    jni.checkForException(10);
  }
}
