

// Test



package ch07.q1;

public class Test {
  public static void main(String[] args) {
    Car black = new Car("Ford", 1500);
    Car green = new SportsCar("Morgan", 2000, 120);
    Car red = new RacingCar("Ferrari", 6500, 220, "Champions");

    System.out.println(black.Details());
    System.out.println(green.Details());
    System.out.println(red.Details());
  }
}
