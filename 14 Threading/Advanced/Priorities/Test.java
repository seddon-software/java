////////////////////////////////////////////////////////////
//
//  Thread Priorities
//
////////////////////////////////////////////////////////////


package Advanced.Priorities;


public class Test {
  public static void main(String[] args) {

    MyClass high = new MyClass("H");
    MyClass medium = new MyClass("M");
    MyClass low = new MyClass("L");

    high.setPriority(8);
    medium.setPriority(5);
    low.setPriority(2);

    low.start();
    medium.start();
    high.start();
  }
}



class MyClass extends Thread {
  private String s;

  public MyClass(String s) {
    this.s = s;
  }

  public void run() {
    for(int i = 0; i < 25; i++) {
      System.out.print(s);
    }
  }
}

