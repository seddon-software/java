////////////////////////////////////////////////////////////
//
//  Runnable 
//
////////////////////////////////////////////////////////////



package Basic.Runnable;

import java.lang.Math;
import java.util.concurrent.TimeUnit;


public class Test {
  public static void main(String[] args) {

    // Create 4 objects
    MyClass m1 = new MyClass("1");
    MyClass m2 = new MyClass("2");
    MyClass m3 = new MyClass("3");
    MyClass m4 = new MyClass("4");

    // Create 4 thread objects
    // passing a reference to our objects
    // and start each thread
    Thread t1 = new Thread(m1);
    t1.start();
    
    new Thread(m2).start();
    new Thread(m3).start();
    new Thread(m4).start();
  }
}

//threads call back on run() method
class MyClass extends Something implements Runnable {
  private String s;

  public MyClass(String s0) {
    s = s0;
  }

  public void run() {
    for(int i = 1; i <= 25; i++)
    {
      System.out.print(s);
      try {
        int delay = (int)(10 * Math.random());
        TimeUnit.MILLISECONDS.sleep(delay);
      } catch(Exception e) {
        System.err.println("Bad boy");
      }
    }
  }
}

class Something {}
