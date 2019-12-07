////////////////////////////////////////////////////////////
//
//    Member Classes
//
////////////////////////////////////////////////////////////

package nestedClasses.nonStatic;


public class NonStatic {

  public static void main(String[] args) {

    // Inner object cannot exist without an instance of outer class
    Outer o1 = new Outer(1);
    Outer o2 = new Outer(2);
    Outer.Inner i11 = o1.new Inner(11);
    Outer.Inner i12 = o1.new Inner(12);
    Outer.Inner i21 = o2.new Inner(21);
    Outer.Inner i22 = o2.new Inner(22);

    o1.Print();
    o2.Print();
    i11.Print();
    i12.Print();
    i21.Print();
    i22.Print();
  }
}


class Outer {

  private int x;

  public Outer(int x) {
    this.x = x;
  }

  public void Print() {
    System.out.println("Outer: x = " + x);
  }

  public class Inner {

    private int y;

    public Inner(int y) {
      this.y = y;
    }

    public void Print() {
      System.out.println("Inner: x = " + x + ", y = " + y);
    }
  }
}

