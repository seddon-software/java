////////////////////////////////////////////////////////////
//
//	ResurrectingWeaklyReachableObjects.java	
//
////////////////////////////////////////////////////////////

package WeakReferences;

import java.lang.ref.WeakReference;

public class ResurrectingWeaklyReachableObjects {

  public static void main(String[] args) {
    MyObject weak   = new MyObject("Weak");
    WeakReference<MyObject> weakRef = new WeakReference<MyObject>(weak);
    weak = null;

    // MyObject is weakly reachable
    // resurrection should work
    weak = (MyObject) weakRef.get();
    try { weak.Hello(); } catch(NullPointerException ignore) {}
    weak = null;
    
    // MyObject is weakly reachable so will not survive gc
    // resurrection will fail
    System.gc();
    weak = (MyObject) weakRef.get();
    try { weak.Hello(); } catch(NullPointerException ignore) {}
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

