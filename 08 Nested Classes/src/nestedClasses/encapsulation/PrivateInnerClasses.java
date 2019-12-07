////////////////////////////////////////////////////////////
//
//    Member Classes : Interfaces (Cheshire Cat)
//
////////////////////////////////////////////////////////////

package nestedClasses.encapsulation;



public class PrivateInnerClasses {

  public static void main(String[] args) {
    MyOuter o = new MyOuter(99);
    IInner i = o.GetInterfacePointer();
    i.Print();
  }
}


interface IInner {
  void Print();
}

class MyOuter {
  private MyInner pMyInner;

  public MyOuter(int x) {
    pMyInner = new MyInner(x);
  }

  private class MyInner implements IInner {
    private int x;

    private MyInner(int x) {
      this.x = x;
    }

    public void Print() {
      System.out.println("Hello from hidden implementation");
      System.out.println("x = " + x);
    }
  }

  IInner GetInterfacePointer() {
    return pMyInner;
  }
}

