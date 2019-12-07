

//Semaphores



package Concurrency.Synchronizer.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Test {
  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(10);
    Semaphore theSemaphore = new Semaphore(3, true);
    MyClass m1 = new MyClass("1", theSemaphore);
    MyClass m2 = new MyClass("2", theSemaphore);
    MyClass m3 = new MyClass("3", theSemaphore);
    MyClass m4 = new MyClass("4", theSemaphore);
    MyClass m5 = new MyClass("5", theSemaphore);
    MyClass m6 = new MyClass("6", theSemaphore);
    MyClass m7 = new MyClass("7", theSemaphore);

    pool.execute(m1);
    pool.execute(m2);
    pool.execute(m3);
    pool.execute(m4);
    pool.execute(m5);
    pool.execute(m6);
    pool.execute(m7);
    pool.shutdown();    
  }
}

class MyClass implements Runnable {
  private String s;
  private Semaphore theSemaphore;

  public MyClass(String s, Semaphore theSemaphore ) {
    this.s = s;
    this.theSemaphore = theSemaphore;
  }

  public void work() {
    try {
      System.out.println("\nThread " + s + " acquired semaphore ...");
      Thread.sleep(1000);
      print25();
    } catch(InterruptedException e) {
      System.err.println(e);
    } catch(Exception e) {
      // ignore
    }
  }
  
  public void run() {
    //print25();
    try {
      theSemaphore.acquire();
      work();                   // doesn't throw
      theSemaphore.release();
      System.out.println("\nThread " + s + " released semaphore ...");
    } catch(InterruptedException e) {
      // acquire failed, so don't release
    }
  }

  public void print25() {
    for(int i = 0; i < 25; i++) {
      System.out.print(s);
      try {
        int delay = (int)(1000 * Math.random());
        Thread.sleep(delay);
      } catch(InterruptedException e) {
        System.err.println(e);
      }
    }
  }
}
