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

public class RandomizeCollection {
	public static void main(String[] args) {
		String[] names = { "New York", "Tokyo", "London", "Paris", "Rome" };
		ArrayList<String> list = new ArrayList<String>();

		// initialize the collection
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}

		// randomize the collection
		Collections.shuffle(list);
		for(String name: list) {
			System.out.printf("%s,", name);
		}
	}
}
