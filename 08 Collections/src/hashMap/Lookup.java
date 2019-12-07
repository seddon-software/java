////////////////////////////////////////////////////////////
//
//    Hash Tables
//
////////////////////////////////////////////////////////////

package hashMap;

import java.util.*;


public class Lookup {

  public static void main(String[] args) {
    HashMap<String, Car> map = new HashMap<String, Car>();

    map.put("Steve",  new Car("H493UWP", 15000.00));
    map.put("John",   new Car("S242RSD", 20000.00));
    map.put("Mary",   new Car("R766GRY", 17000.00));
    map.put("Sue",    new Car("S409HUP", 15500.00));
    map.put("George", new Car("H120GEW", 23000.00));

    // print the map
    System.out.println(map);
    
    // retrieve Sue's car
    Car suesCar = map.get("Sue");
    System.out.println("Sues car: " + suesCar);
  }
}


class Car {
  private String registration;
  private double cost;

  public Car(String registration, double cost) {
    this.registration = registration;
    this.cost = cost;
  }

  public String toString() {
    return (registration + ":" + cost);
  }

  public int hashCode() {
    int x = registration.charAt(0);
    int y = registration.charAt(3);
    return (x * y) % 100 ;
  }

  public boolean equals(Object obj) {
    Car car = (Car) obj;

    if(registration.equals(car.registration))
      return true;
    else
      return false;
  }
}