////////////////////////////////////////////////////////////
//
//	Test.java
//
////////////////////////////////////////////////////////////

package Varargs;


public class Test {

  public static void main(String[] args) {
    f(5, 7);
    f(2, 3, 10, 11, 12, 13, 14, 15);
    f(2, 3, 5, "abc", 6.876);
  }
  
  public static void f(int x, int y, Object ... args) {
	    System.out.print(x);
	    System.out.print(y);
	    for(Object arg : args) {
	      System.out.print(arg + " ");      
	    }
	    System.out.println();
	  }

  public static void f(int x, int y) {
	    System.out.print(x);
	    System.out.print(y);
	  }
}

