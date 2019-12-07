////////////////////////////////////////////////////////////
//
//	LowMemoryConditions.java	
//
////////////////////////////////////////////////////////////

package SoftReferences;

import java.lang.ref.SoftReference;

public class LowMemoryConditions {
  public static void main(String[] args) {
    MyObject soft   = new MyObject("Soft");
    SoftReference<MyObject> softRef = new SoftReference<MyObject>(soft);
    soft = null;
    
    // MyObject should survive gc because of SoftReference
    System.gc();
    
    // resurrect MyObject
    soft = (MyObject) softRef.get();
    try { soft.Hello(); } catch(NullPointerException ignore) {}
    soft = null;

    // now simulate low memory condition
    // SoftReference will not save MyObject
    int size = 512;
    Object memory = null;
    try {
      while(true) {
        memory = new byte[size];
        size = size * 4;
      }
    } catch(Throwable e) {
      memory = null;
      System.gc();
    }
  }
}

class MyObject {
  private String id;
  
  public MyObject(String id) {
    this.id = id;
  }
  public String toString() {
    return "id=" + id;  
  }  
  
  public void Hello() {
    System.out.println("Hello from id=" + id);
  }
  
  protected void finalize() {    
    System.out.println("MyObject finalized: " + this);  
  }
}

