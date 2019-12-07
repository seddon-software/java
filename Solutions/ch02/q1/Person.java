////////////////////////////////////////////////////////////
//
//	Person.java	
//
////////////////////////////////////////////////////////////

package ch02.q1;

public class Person {
  private String name;
  private int age;
  
  public Person(String n, int a) {
    name = n;
    age = a;
  }
  
  public void Display() {
    System.out.println("Person name: " + name);
    System.out.println("Person age:  " + age);
    System.out.println("");
  }
}



