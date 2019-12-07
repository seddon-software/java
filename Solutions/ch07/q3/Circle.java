

//Circle



package ch07.q3;

class Circle extends Shape {
  private int radius;

  public Circle(int x0, int y0, int r) {
    super(x0, y0);
    radius = r;
  }

  String Details() {
    return super.Details() + ",r=" + radius;
  }
}

