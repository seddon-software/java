package arrays;

import java.util.Arrays;

public class Copying {

	public static void f(int[] fa) {
		fa[3] = 99;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 10 };
		int[] b = Arrays.copyOf(a, a.length);
		int[] c = a.clone();

		boolean test;
		test = a == b; // false
		test = a == c; // false

		// passing an array to a function
		f(a);
	}
}
