package arrays;

public class Modifying {
	public static void f(int[] b) {
		b[3] = 99;		// this changes the original array
	}
	
	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 10 };
		f(a);		// pass a copy of the reference
		for(int i : a) {
	         System.out.print( i );
	         System.out.print(",");
	      }
	}
}
