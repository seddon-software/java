////////////////////////////////////////////////////////////
//
//    ArrayList
//
////////////////////////////////////////////////////////////

package arrayList;

import java.util.*;


public class Create {

  public static void main(String[] args) {
    Collection<Person> staff = new ArrayList<Person>();
    staff.add(new Person("John"));
    staff.add(new Person("Zoe"));
    staff.add(new Person("Paul"));
    staff.add(new Person("Abdul"));
    staff.add(new Person("Zia"));
    System.out.println(staff);
    
	for(Person p: staff) {
		System.out.printf("%s,", p);
	}
  }
}


class Person {
  private String name;

	public Person(String name) {
	  this.name = name;
	}

	public String toString() {
	  return name;
	}
}
