package ch07.q2;


public class Test {
  public static void main(String[] args) {
    Car black = new Car("Ford", 1500);
    Car green = new SportsCar("Morgan", 2000, 120);
    Car red = new RacingCar("Ferrari", 6500, 220, "Champions");

    Print(black);
    Print(green);
    Print(red);
  }

  public static void Print(Car c) {
    System.out.println(c.Details());
  }
}
