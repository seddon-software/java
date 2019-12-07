////////////////////////////////////////////////////////////
//
//    Monitors
//
////////////////////////////////////////////////////////////

package Synchronization.Monitors;




public class Test {
  public static void main(String[] args) {

  // set up monitors
    Lock lock1 = new Lock();
    Lock lock2 = new Lock();
    Lock lock3 = new Lock();
    Lock lock4 = new Lock();

  // create 4 objects
    MyClass m1 = new MyClass("1", lock1);
    MyClass m2 = new MyClass("2", lock2);
    MyClass m3 = new MyClass("3", lock1);
    MyClass m4 = new MyClass("4", lock2);

  // create 4 thread objects linked to the MyClass objects
    Thread t1 = new Thread(m1);
    Thread t2 = new Thread(m2);
    Thread t3 = new Thread(m3);
    Thread t4 = new Thread(m4);

  // create 4 O/S threads
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}

// this class contains the callback run method
// and prints out strings at random intervals
class MyClass implements Runnable {
  private String s;
  private Lock lock;

  public MyClass(String s, Lock lock) {
    this.s = s;
    this.lock = lock;
  }

  public void run() {
	
    synchronized(lock)
    {
      for(int i = 1; i <= 25; i++)
      {
        System.out.print(s);
        Delay();
      }
    }
  }

  private void Delay() {
    try {
      int i = (int) (Math.random() * 1000.0);
      Thread.sleep(i);
    } catch(InterruptedException e) {
    }
  }
}


// simple class to provide the monitor
class Lock {}







