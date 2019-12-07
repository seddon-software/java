////////////////////////////////////////////////////////////
//
//    HashSet
//
////////////////////////////////////////////////////////////

package hashSet;

import java.util.*;

// HashSet implements a Set using a hash table
// searching, insert and delete give good performance

public class Searching {

	public static void Find(Collection<Person> collection, Person person) {
		if (collection.contains(person))
			System.out.println(person + ": item found");
		else
			System.out.println(person + ": item NOT found");
	}

	public static void main(String[] args) {
		Collection<Person> staff = new HashSet<Person>();
		staff.add(new Person("John"));
		staff.add(new Person("Zoe"));
		staff.add(new Person("Paul"));
		staff.add(new Person("Abdul"));
		staff.add(new Person("Zia"));

		// print out entire collection
		for (Person staffMember : staff) {
			System.out.printf("%s, ", staffMember);
		}
		System.out.println();

		// search for item
		Find(staff, new Person("Zoe"));
		Find(staff, new Person("Jo"));
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
		return name.charAt(0); // poor choice, but simple
	}
}
