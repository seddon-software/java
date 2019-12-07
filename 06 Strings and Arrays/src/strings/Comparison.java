package strings;
////////////////////////////////////////////////////////////
//
//	Test.java	
//
////////////////////////////////////////////////////////////



public class Comparison {

	public static void main(String[] args) {
		// constant (interned) strings that are equal use the same reference
		// non interned strings that are equal use a different reference
		// but can be compared using equals()
		String abc = "ABC";
		String def = "DEF";

		String s1 = "ABCDEF";
		String s2 = "ABCDEF";
		String s3 = "ABC" + "DEF";
		String s4 = abc + def;
		String s5 = s4.intern(); // make string intern
		String s6 = new String("ABCDEF");

		// don't use == to compare strings (it only works for interned strings)
		boolean test;
		test = s1 == s2; // true
		test = s1 == s3; // true
		test = s1 == s4; // false
		test = s1 == s5; // true
		test = s1 == s6; // false

		// use equals to compare strings (always works)
		test = s1.equals(s2); // all true
		test = s1.equals(s3);
		test = s1.equals(s4);
		test = s1.equals(s5);
		test = s1.equals(s6);
	}
}
