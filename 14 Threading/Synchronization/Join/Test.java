////////////////////////////////////////////////////////////
//
//    Join
//
////////////////////////////////////////////////////////////

package Synchronization.Join;


public class Test {
  public static void main(String[] args) {

    // Create 4 objects
    MyClass m1 = new MyClass("1");
    MyClass m2 = new MyClass("2");
    MyClass m3 = new MyClass("3");
    MyClass m4 = new MyClass("4");

    // Start each thread

    // wait for 30 seconds and then awaken all threads
    try {
      m1.start();
      m1.join();
      System.out.println("\nThread 1 has finished");

      m2.start();
      m2.join();
      System.out.println("\nThread 2 has finished");

      m3.start();
      m4.start();
      m3.join();
      System.out.println("\nThread 3 has finished");

      m4.join();
      System.out.println("\nThread 4 has finished");
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}



class MyClass extends Thread {
  private String s;

  public MyClass(String s) {
    this.s = s;
  }

  public void run() {
    for(int i = 1; i <= 25; i++)
    {
      System.out.print(s);
      try {
        int delay = (int)(100 * Math.random());
        Thread.sleep(delay);
      } catch(Exception e) {
        System.err.println(e);
      }
    }
  }
}
