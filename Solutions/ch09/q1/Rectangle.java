package ch09.q1;


public class Rectangle implements Shape {
  private double x;
  private double y;

  public Rectangle(double x0, double y0) {
    x = x0;
    y = y0;
  }

  public double Area() {
    return x * y;
  }
}
