package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CompareHashSetAndTreeSet {

	public static void main(String args[]) {
		Set<String> set = new HashSet<String>();
		set.add("Betty");
		set.add("Debbie");
		set.add("Elizabeth");
		set.add("Carol");
		set.add("Alice");
		System.out.println(set);
		Set<String> sortedSet = new TreeSet<String>(set);
		System.out.println(sortedSet);
	}
}
