
package ch07.q3;

class Polygon extends Shape {
  private int sides;

  public Polygon(int x0, int y0, int s) {
    super(x0, y0);
    sides = s;
  }

  String Details() {
    return super.Details() + ",sides=" + sides;
  }
}

