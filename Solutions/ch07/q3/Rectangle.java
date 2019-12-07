
package ch07.q3;

class Rectangle extends Shape {
  private int height;
  private int width;

  public Rectangle(int x0, int y0, int h, int w) {
    super(x0, y0);
    height = h;
    width = w;
  }

  String Details() {
    return super.Details() + ",h=" + height + ",w=" + width;
  }
}

