////////////////////////////////////////////////////////////
//
//    Exceptions
//
////////////////////////////////////////////////////////////

package nestedExceptions;



public class Test {
  public static void main(String[] args) {

    try {
      f1();
    } catch(Exception e) {
      System.err.println(e);
    }
  }

  static void f1() throws Exception {
    f2();
  }

  static void f2() throws Exception {
    try {
      f3();
    } catch(MyException e) {
      e.printStackTrace();
      throw new Exception("some error");
    } catch(YourException e) {
      e.printStackTrace();
      throw new Exception("some error");
    }
  }

  static void f3() throws Exception {
    f4();
  }

  static void f4() throws Exception {
    int x = 1;
    try {
	  throw new OtherException();
//    } catch(MyException e) {
//    	x = 33;
    } finally {
    	x = 66;
    }
  }
}


class MyException extends Exception {}
class YourException extends Exception {}
class OtherException extends Exception {}

