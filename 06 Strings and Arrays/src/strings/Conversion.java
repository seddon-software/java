////////////////////////////////////////////////////////////
//
//	Test.java	
//
////////////////////////////////////////////////////////////

package strings;

public class Conversion {

	public static void main(String[] args) {
		// convert String to number
		String string1 = "63145";
		int number = Integer.parseInt(string1);

		// convert number to String
		String string2 = Integer.toString(number);

		// convert char array to string
		char[] charArray1 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		String string3 = new String(charArray1);
		// and back again
		char[] charArray2 = string3.toCharArray();
	}
}
