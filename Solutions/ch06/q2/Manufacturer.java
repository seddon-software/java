

//Manufacturer.java	



package ch06.q2;

public class Manufacturer {
  private String name;
  private Driver driver1;
  private Driver driver2;

  public Manufacturer(String n) {
    name = n;
  }

  public void Employ(Driver d) {
    if (driver1 == null)
      driver1 = d;
    else
      driver2 = d;
  }

  public void Release(Driver d) {
    if (driver1 == d)	driver1 = null;
    if (driver2 == d)	driver2 = null;
  }

  void WhatIsYourTeam() {
    System.out.println(name + "'s team is: " + driver1 +
        " and " + driver2);
  }
}

