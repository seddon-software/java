////////////////////////////////////////////////////////////
//
//  Test Basic Classloader
//
////////////////////////////////////////////////////////////

package basic.tests;


import java.io.File;
import java.lang.reflect.Method;

import basic.MyClassLoader;
import basic.MyClassLoader1;
import basic.MyClassLoader2;



public class Test1 {

static public void main( String args[] ) throws Exception {

    // instantiate class loader
    String myStore = "store";
    MyClassLoader loaderA = new MyClassLoader1(myStore);
    MyClassLoader loaderB = new MyClassLoader2(myStore);
    
    // get the Class object for Class1 and Class2
    // these classes are not on the classpath
    // but our classloaders know where to look
    Class<?> c1A = loaderA.loadClass("myclasses.Class1");
    Class<?> c1B = loaderB.loadClass("myclasses.Class1");
    Class<?> c2A = loaderA.loadClass("myclasses.Class2");
    Class<?> c2B = loaderB.loadClass("myclasses.Class2");
        
    // invoke methods
    callIt(c1A, "A", 1);		// call: obj.f() and obj.f("A", 1)
    callIt(c1B, "A", 2);
    callIt(c2A, "B", 1);
    callIt(c2B, "B", 2);
    
    // create instances of Class1
    Object o1a = c1A.newInstance();
    Object o1b = c1B.newInstance();
    Object o2a = c1A.newInstance();
    Object o2b = c1B.newInstance();
    
    // report on which classes got loaded
    loaderA.listLoadedClasses();
    loaderB.listLoadedClasses();
    
    // Class1 and Class are cast compatible
    // so try to cast Class2 objects into Class1 
    //		loaded by the same classloader
    castIt(o1a, o2a);
    castIt(o1b, o2b);
    
    // now try casting Class1 objects 
    //		loaded by different classloaders 
    castIt(o1a, o1b); // same class !!!
  }
  
  public static void callIt(Class<?> c, String s, int i) {
    try {
      System.out.print(c.getClassLoader()); 
      Method method;

      method = c.getMethod("f");
      method.invoke(c.newInstance());
  
      method = c.getMethod("f", String.class, int.class);
      method.invoke(c.newInstance(), s, i);
    } catch(Exception e) {
      System.err.println(e);
    }  
    System.out.println(""); 
  }
  
  public static void castIt(Object o1, Object o2) {
    try {
      Class<?> c = o2.getClass();
      o2 = c.cast(o1);
      System.out.print("No exception: ");
    }catch(Exception e) {
      System.out.print(e + " : ");
    }
    String loader1 = o1.getClass().getClassLoader().getClass().getCanonicalName();
    String loader2 = o2.getClass().getClassLoader().getClass().getCanonicalName();
    String class1 = o1.getClass().getCanonicalName();
    String class2 = o2.getClass().getCanonicalName();
    System.out.println("casting from: ");
    System.out.println("\t" + class1 + "(" + loader1 + ")-> " + 
                              class2 + "(" + loader2 + ")");
  }
}
