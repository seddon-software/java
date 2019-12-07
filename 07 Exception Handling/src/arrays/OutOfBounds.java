////////////////////////////////////////////////////////////
//
//    Exceptions
//
////////////////////////////////////////////////////////////

package arrays;


public class OutOfBounds {
  public static void main(String[] args) {

    try {
      int a[ ] = new int[100];
      a[65] = 0;
      a[75] = 0;
      a[85] = 0;
      a[95] = 0;
      a[105] = 0;
      a[115] = 0;
      a[125] = 0;
    } catch(ArrayIndexOutOfBoundsException e) {
        System.err.println("Message: " + e.getMessage());
        System.err.println("ToString: " + e.toString());
        System.err.println(e);
        e.printStackTrace();
    } finally {
      System.err.println("Say something");
    }
  }
}