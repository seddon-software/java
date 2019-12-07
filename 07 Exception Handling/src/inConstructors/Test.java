////////////////////////////////////////////////////////////
//
//    User Defined Exceptions
//
////////////////////////////////////////////////////////////

package inConstructors;



public class Test {
  public static void main(String[] args) {

    Point p1 = CreatePoint(  10,   30);
    Point p2 = CreatePoint(  10, 3000);
    Point p3 = CreatePoint(1050,   30);
    Point p4 = CreatePoint( -10,   30);
    PrintDetails(p1);
    PrintDetails(p2);
    PrintDetails(p3);
    PrintDetails(p4);
  }

  static Point CreatePoint(int x0, int y0) {

    Point p = null;
    try {
      p = new Point(x0, y0);
    } catch(TooBig e) {
      System.err.println("Coordinate is too big");
    } catch(TooSmall e) {
      System.err.println("Coordinate is too small");
    }

    return p;
  }


  static void PrintDetails(Point p) {

    try {
      p.Display();
    } catch(NullPointerException e) {
      System.err.println("Object reference is null");
    }
  }
}

////////////////////////////////////////////////////////////

class Point {
  private int x;
  private int y;

  public Point(int x0, int y0) throws TooBig, TooSmall {
    if (x0 > 1000) throw new TooBig();
    if (y0 > 1000) throw new TooBig();
    if (x0 < 0) throw new TooSmall();
    if (y0 < 0) throw new TooSmall();
    x = x0;
    y = y0;
  }

  public void Display() {
    System.out.println("Point is at: " + x + ", " + y);
  }
}


class TooBig extends Exception {}
class TooSmall extends Exception {}

