////////////////////////////////////////////////////////////
//
//    CyclicBarrier Locks
//
////////////////////////////////////////////////////////////

package Concurrency.Synchronizer.CyclicBarrier;

import java.util.concurrent.*;

public class Test {
  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(4);
    CyclicBarrier barrier = new CyclicBarrier(4, new Trace());
    MyClass m1 = new MyClass("1", barrier);
    MyClass m2 = new MyClass("2", barrier);
    MyClass m3 = new MyClass("3", barrier);
    MyClass m4 = new MyClass("4", barrier);
    
    try {
      pool.execute(m1);
      Thread.sleep(1000);
      pool.execute(m2);
      Thread.sleep(2000);
      pool.execute(m3);
      Thread.sleep(3000);
      pool.execute(m4);
    } catch(InterruptedException e) {
      // ...
    }
    pool.shutdown();    
  }
}

class Trace implements Runnable {
  public void run() {
    System.out.println("\nBarrier tripped");
  }  
}

class MyClass implements Runnable {
  private String s;
  private CyclicBarrier barrier;
  
  public MyClass(String s, CyclicBarrier barrier) {
    this.s = s;
    this.barrier = barrier;
  }

  public void run() {
    try {
      print25();
      barrier.await();
      print25();
      
    // if thread is interrupted then all other waiting threads
    // will receive a BrokenBarrierException (all or nothing) 
    } catch(BrokenBarrierException e) {
      System.err.println(e);
    } catch(InterruptedException e) {
      System.err.println(e);
    }
  }
  
  public void print25() {  // doesn't throw
    try {
      for(int i = 0; i < 25; i++) {
        System.out.print(s);
        try {
          int delay = (int)(500 * Math.random());
          Thread.sleep(delay);
        } catch(InterruptedException e) {
          System.err.println(e);
        }
      } 
    } catch(Exception e) {
      // ...
    }
  }
}
