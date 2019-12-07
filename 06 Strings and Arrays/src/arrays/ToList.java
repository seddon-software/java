package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ToList {

	public static void main(String[] args) {
		String[] names = { "John", "Zoe", "Paul", "Abdul", "Zia"};

		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(names));
		for(String name: names) {
			System.out.println(name);
		}
	}

}
