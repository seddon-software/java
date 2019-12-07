package algorithms;
////////////////////////////////////////////////////////////
//
//    Read Only Collections
//
////////////////////////////////////////////////////////////



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ReadOnlyCollections {
	public static void main(String[] args) {
		String[] names = { "New York", "Tokyo", "London", "Paris", "Rome" };
		ArrayList<String> list = new ArrayList<String>();

		// initialize the collection
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}

		// form a read only version
		Collection<String> readOnlyList = Collections
				.unmodifiableCollection(list);
		try {
			list.add("Chicago"); // OK
			readOnlyList.add("Chicago"); // will fail
		} catch (UnsupportedOperationException e) {
			System.err.println("Sorry - collection is read only!");
		}
	}
}