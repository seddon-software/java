////////////////////////////////////////////////////////////
//
//    Nested Classes
//
////////////////////////////////////////////////////////////

package nestedClasses.statics;



public class Static {

  public static void main(String[] args) {

    // Inner object can exist without an instance of outer class
    Outer.Inner i1 = new Outer.Inner("1");
    Outer.Inner i2 = new Outer.Inner("2");
    i1.Print();
    i2.Print();

    Outer o = new Outer();
    o.CreateInnerObject("3");
    o.PrintInner();
  }
}


class Outer {
  private Inner ptr;

  public void CreateInnerObject(String s) {
    ptr = new Inner(s);
  }

  public void PrintInner() {
    ptr.Print();
  }


  public static class Inner {

    private String s;

    public Inner(String s) {
      this.s = s;
    }

    public void Print() {
      System.out.println("Hello from the inner class: " + s);
    }
  }
}

