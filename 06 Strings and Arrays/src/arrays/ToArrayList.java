////////////////////////////////////////////////////////////
//
//  Convert between Array and ArrayList
//
////////////////////////////////////////////////////////////

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ToArrayList {
  public static void main(String[] args) {
	  
	  // convert int[] to Integer[]
	  int[] a = { 2, 3, 5, 7, 11, 13, 17, 19 };
	  Integer[] b = new Integer[a.length];
	  for(int i = 0; i < a.length; i++) {
		  b[i] = a[i];
	  }
	  
	  // convert Integer[] to ArayList<Integer>
	  List<Integer> c = new ArrayList<Integer>();
	  c = Arrays.asList(b);

	  // convert ArayList<Integer> to Integer[]
	  Integer[] d = (Integer[]) c.toArray();
	  
	  // convert Integer[] to int[]
	  int[] e = new int[d.length];
	  for(int i = 0; i < d.length; i++) {
		  e[i] = d[i];
	  }
  }
}
