////////////////////////////////////////////////////////////
//
//	Test.java
//
////////////////////////////////////////////////////////////

package Metadata;

import java.lang.reflect.*;
import java.lang.annotation.*;

public class Test {
  public static void main (String args[]) {
    SomeClass myRecursion = new SomeClass();

    // make normal method calls
    myRecursion.f();
    myRecursion.g();

    // use reflection to determine annotations
    Class c = myRecursion.getClass();
    Method methods[] = c.getDeclaredMethods();

    // pickup annotations
    Annotation annotations[] = null;
    for (Method m : methods) {
      annotations = m.getAnnotations();
      
      for (Annotation a : annotations) {
        System.out.print("Method " + m.getName());
        System.out.println(" has annotation: " + a);
      }
    }
  }
}


