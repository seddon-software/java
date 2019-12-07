////////////////////////////////////////////////////////////
//
//	Test.java
//
////////////////////////////////////////////////////////////

package printf;


public class Test {

  public static void main(String[] args) {
    int x = 100;
    double d = -49.63;
    String s = "Hello";
    
    System.out.printf("%+08d %6.2f %10s\n", x, d, s);
    System.out.printf("%-10s%-10s", s, s);
  }
}

