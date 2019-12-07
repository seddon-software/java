////////////////////////////////////////////////////////////
//
//    Notify
//
////////////////////////////////////////////////////////////

package Synchronization.Notify;


public class Test {
  public static void main(String[] args) {

    Helper helper = new Helper();

    // Create 4 objects
    MyThread m1 = new MyThread(helper, "1");
    MyThread m2 = new MyThread(helper, "2");
    MyThread m3 = new MyThread(helper, "3");
    MyThread m4 = new MyThread(helper, "4");

    // Run each thread
    m1.start();
    m2.start();
    m3.start();
    m4.start();

    // wait for 30 seconds and then awaken all threads
    try {
      Thread.sleep(30 * 1000);
      helper.NotifyAll();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}

// This class is here to display output and to control the threads
class Helper {

  synchronized public void Wait(String s) {
    try {
      System.out.println("Thread " + s + " has locked helper object");
      Thread.sleep(5000);
      System.out.println("Thread " + s + " is waiting ...");
      wait();
      System.out.println("Thread " + s + " wait is over and has re-acquired lock");
      Thread.sleep(5000);
      System.out.println("Thread " + s + " is finishing ...");
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized public void NotifyAll() {
    notifyAll();
  }
}


class MyThread extends Thread {
  private Helper helper;
  private String s;

  public MyThread(Helper helper, String s) {
    this.helper = helper;
    this.s = s;
  }

  public void run() {
    helper.Wait(s);
  }
}
