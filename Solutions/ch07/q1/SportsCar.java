

//SportsCar.java	



package ch07.q1;

public class SportsCar extends Car {
  private int maxSpeed;

  public SportsCar(String m, int c, int s) {
    super(m, c);
    maxSpeed = s;
  }

  public String Details() {
    return super.Details() + " " + maxSpeed + " tops";
  }
}
