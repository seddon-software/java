////////////////////////////////////////////////////////////
//
//    HashSet
//
////////////////////////////////////////////////////////////

package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


// HashSet implements a Set using a hash table
// no duplicates allowed
//  objects should override Object.hashCode()

public class HashSetLookup {

  public static void main(String[] args) {
    Set<Person> staff = new HashSet<Person>();
    staff.add(new Person("John"));
    staff.add(new Person("Zoe"));
    staff.add(new Person("Paul"));
    staff.add(new Person("Zoe"));	// duplicates overwrite
    staff.add(new Person("Abdul"));
    staff.add(new Person("Zia"));

    // print out entire collection
    for(Person p: staff) {
    	System.out.printf("%s, ", p);
    }

    // search for item
    Find(staff, new Person("Zoe"));
    Find(staff, new Person("Jo"));
  }

  public static void Find(Set<Person> set, Person key) {
    if(set.contains(key))
      System.out.println("\n" + key + ": item found");
    else
      System.out.println("\n" + key + ": item NOT found");
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

	public boolean equals(Object o) {
		Person p = (Person) o;
		return name.equals(p.name);
	}

	public int hashCode() {
		// must return a hash code that only depends on the name
		return name.charAt(0);            // poor choice, but simple
	}
}
