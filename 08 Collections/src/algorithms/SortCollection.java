package algorithms;
////////////////////////////////////////////////////////////
//
//    Read Only Collections
//
////////////////////////////////////////////////////////////



import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SortCollection {
	public static void main(String[] args) {
		String[] names = { "New York", "Tokyo", "London", "Paris", "Rome" };
		ArrayList<String> list = new ArrayList<String>();

		// initialize the collection
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}

		// sort the collection using a Collator comparator
		// Collator is an abstract base class
		// the Collator only works with Strings
		Collator myCollator = Collator.getInstance();
		Collections.sort(list, myCollator);
		Iterator<String> i = list.iterator();
		// print out the sorted collection
		for(String name: list) {
			System.out.printf("%s,", name);
		}
	}
}
