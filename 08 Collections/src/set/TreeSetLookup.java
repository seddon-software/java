////////////////////////////////////////////////////////////
//
//    HashSet
//
////////////////////////////////////////////////////////////

package set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


// TreeSet implements a Set and maintains an order
//  no duplicates allowed
//  all elements inserted must implement the Comparable interface

public class TreeSetLookup {

  public static void main(String[] args) {
    Set<Employee> staff = new TreeSet<Employee>();
    staff.add(new Employee("John"));
    staff.add(new Employee("Zoe"));
    staff.add(new Employee("Paul"));
    staff.add(new Employee("Abdul"));
    staff.add(new Employee("Zoe"));  // duplicates not allowed
    staff.add(new Employee("Zia"));

    // print out entire collection
    for(Employee e: staff) {
    	System.out.printf("%s, ", e);
    }
    System.out.println();

    // search for item
    Find(staff, new Employee("Zoe"));
    Find(staff, new Employee("Jo"));
  }

  public static void Find(Set<Employee> set, Employee key) {
    if(set.contains(key))
      System.out.println(key.getName() + ": item found");
    else
      System.out.println(key.getName() + ": item NOT found");
  }
}

class Employee implements Comparable<Employee> {
	private String name;
	
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(String name) {
		this.name = name;
	}
	
	public int compareTo(Employee e) {
		return this.name.compareTo(e.name);
	}
}
