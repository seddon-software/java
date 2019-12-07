package reflection;


import java.lang.reflect.*;


public class InvokeMethods {
  public static void main(String[] args) {
    try {
      callMethod_f();
      callMethod_g(new AnotherClass());
      callMethod_main();
    } catch(ClassNotFoundException e) {
      System.err.println("ClassNotFoundException");      
    } catch(NoSuchMethodException e) {
      System.err.println("NoSuchMethodException");      
    } catch(InvocationTargetException e) {
      System.err.println("InvocationTargetException");            
    } catch(IllegalAccessException e) {
      System.err.println("IllegalAccessException");            
    }
  }

  ////////////////////////////////////////////////////////////

  static void callMethod_f() 
    throws ClassNotFoundException,
           NoSuchMethodException,
           InvocationTargetException,
           IllegalAccessException 
  {
    // get the Class object
      Class<?> theClass = Class.forName("reflection.AnotherClass");
  
    // define parameter signature for method (String, String)
      Class<?>[] parameterTypes = new Class[] {
          (new String()).getClass(),
          (new String()).getClass()
      };
    // get a Method object for f(String, String)
      Method theMethod = 
        theClass.getMethod("f", parameterTypes);
  
    // define parameters to pass: f("abc", "xyz")
      String s1 = "abc";
      String s2 = "xyz";
      Object[] params = new Object[] {s1, s2};
  
    // call f("abc", "xyz")
      theMethod.invoke(null, params);   // null => static method
  }

  ////////////////////////////////////////////////////////////

  static void callMethod_g(Object o) 
    throws ClassNotFoundException,
           NoSuchMethodException,
           InvocationTargetException,
           IllegalAccessException 
  {
    // get the Class object
      Class<?> theClass = o.getClass();

      // define parameter signature for method (int, int)
      Class[] parameterTypes = new Class[] {
                                        Integer.TYPE,
                                        Integer.TYPE
                                       };
    // get a Method object for g(int, int)
      Method theMethod = theClass.getMethod("g", parameterTypes);
  
    // define parameters to pass: g(99, 1)
      Object[] params = new Object[] {99, 1};
  
    // rv = g(99, 1)
      Integer rv = (Integer) theMethod.invoke(o, params);
      System.out.println(rv.intValue());
  }

  ////////////////////////////////////////////////////////////
  
  static void callMethod_main()
    throws ClassNotFoundException,
           NoSuchMethodException,
           InvocationTargetException,
           IllegalAccessException {
    // get the Class object
      Class<?> theClass = Class.forName("reflection.AnotherClass");
  
    // define parameter signature for method (String[])
      Class<?>[] parameterTypes = new Class[] {
                                        (new String[0]).getClass(),
                                       };
    // get a Method object for main(String[])
      Method theMethod = theClass.getMethod("main", parameterTypes);
  
    // define parameters to pass:
      String[] args = {"aaa", "bbb", "ccc" };
      Object[] params = new Object[] {args};
  
    // call main(args)
      theMethod.invoke(null, params);   // null => static method
  }
}


/////////////////////////////////////////////////////////////


class AnotherClass {
  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++)
      System.out.println(args[i]);
  }

  public static void f(String s1, String s2) {
    System.out.println("s1: " + s1); 
    System.out.println("s2: " + s2); 
  }

  public int g(int x, int y) {
    return x + y;
  }
}



