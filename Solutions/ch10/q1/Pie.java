
package ch10.q1;

public class Pie implements Shape {
    private double radius;
    private double angle;

    public Pie(double r, double a) {
        radius = r;
        angle  = a;
    }

    public double Area() {
        return PI * radius * radius * angle / 360.0;
    }
}

