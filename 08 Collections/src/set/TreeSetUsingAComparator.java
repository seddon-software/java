

//HashSet



package set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


//TreeSet implements a Set and maintains an order
//no duplicates allowed
//ordering is determined by the Comparator's compare method

public class TreeSetUsingAComparator {

	public static void main(String[] args) {
		Set<Worker> staff = new TreeSet<Worker>(new Comparator<Worker>() {
				public int compare(Worker w1, Worker w2) {
					return w1.getName().compareTo(w2.getName());
				}
			}
		);
		staff.add(new Worker("John"));
		staff.add(new Worker("Zoe"));
		staff.add(new Worker("Paul"));
		staff.add(new Worker("Abdul"));
		staff.add(new Worker("Zoe"));  // duplicates not allowed
		staff.add(new Worker("Zia"));

		// print out entire collection
		for(Worker w : staff) {
			System.out.printf("%s, ", w);
		}
		System.out.println();
	}
}

class Worker {
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

	public Worker(String name) {
		this.name = name;
	}
}
