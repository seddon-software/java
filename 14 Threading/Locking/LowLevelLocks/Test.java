////////////////////////////////////////////////////////////
//
//    Low level locking primitives
//
////////////////////////////////////////////////////////////

package Locking.LowLevelLocks;
import java.util.concurrent.locks.*;

class MyThread extends Thread {
  private String id;
  private Locker locker;
  
  MyThread(String id, Locker locker) {
    this.id = id;
    this.locker = locker;
  }  
  public void run() {
    locker.doit(id);
  }
}

public class Test {
  public static void main(String[] args) {
    Locker theLocker = new Locker();
    MyThread t1 = new MyThread("1", theLocker);
    MyThread t2 = new MyThread("2", theLocker);
    MyThread t3 = new MyThread("3", theLocker);
    MyThread t4 = new MyThread("4", theLocker);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}

class Locker {
  private final ReentrantLock myLock = new ReentrantLock();

  public void doit(String id) { 
    myLock.lock();  // block until condition holds
    try {
      System.out.println(id + " acquired lock");
      try {
      Thread.sleep(5000);
      } catch(InterruptedException e) {
        System.err.println(e);        
      }
    } finally {
      myLock.unlock();
      System.out.println(id + " released lock");
    }
  }
}
