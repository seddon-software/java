
package ch07.q3;

class Shape {
  private int x;
  private int y;

  public Shape(int x0, int y0) {
    x = x0;
    y = y0;
  }

  String Details() {
    return "x=" + x + ",y=" + y;
  }
}

