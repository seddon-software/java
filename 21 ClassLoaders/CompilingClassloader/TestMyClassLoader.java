package CompilingClassloader;

import java.lang.reflect.Method;

public class TestMyClassLoader {

  static public void main( String args[] ) throws Exception {

	// instantiate class loader
    MyClassLoader loader = new MyClassLoader();
    
    // get the Class object
    Class<?> theClass = loader.loadClass("CompilingClassloader.MyClassA");
    
    // define parameter signature for method (String, String)
    Class<?>[] parameterTypes = new Class<?>[] {
                                          (new String()).getClass(),
                                          (new String()).getClass()
                                         };
    // get a Method object for f(String, String)
    Method theMethod = theClass.getMethod("f", parameterTypes);
    
    // define parameters to pass: f("Hello ", "World")
    String s1 = "Hello ";
    String s2 = "World";
    Object[] params = new Object[] {s1, s2};
    
    // call f("Hello ", "World")
    theMethod.invoke(null, params);   // null => static method
  }
}