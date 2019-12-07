

//RacingCar.java	



package ch07.q1;

public class RacingCar extends SportsCar {
  private String team;

  public RacingCar(String m, int c, int s, String t) {
    super(m, c, s);
    team = t;
  }

  public String Details() {
    return super.Details() + " " + team;
  }
}