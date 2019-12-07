package ch07.q2;

public class Car {

  private String make;
  private int capacity;

  public Car(String m, int c) {
    make = m;
    capacity = c;
  }

  public String Details() {
    return make + " " + capacity + "cc";
  }
}

