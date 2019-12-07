
package ch10.q1;

public class Circle implements Shape {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double Area() {
        return PI * radius * radius;
    }
}

