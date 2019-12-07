////////////////////////////////////////////////////////////
//
//    CountDownLatch
//
////////////////////////////////////////////////////////////

package Concurrency.Synchronizer.CountDownLatch;

import java.util.concurrent.*;

public class Test {
  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(10);
    
    // startSignal is triggered by the main thread, but the
    // endSignal has to be triggered by all 7 worker threads
    
    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch endSignal = new CountDownLatch(7);
    
    MyClass m1 = new MyClass("1", startSignal, endSignal);
    MyClass m2 = new MyClass("2", startSignal, endSignal);
    MyClass m3 = new MyClass("3", startSignal, endSignal);
    MyClass m4 = new MyClass("4", startSignal, endSignal);
    MyClass m5 = new MyClass("5", startSignal, endSignal);
    MyClass m6 = new MyClass("6", startSignal, endSignal);
    MyClass m7 = new MyClass("7", startSignal, endSignal);
    
    pool.execute(m1);
    pool.execute(m2);
    pool.execute(m3);
    pool.execute(m4);
    pool.execute(m5);
    pool.execute(m6);
    pool.execute(m7);
    pool.shutdown();
    startSignal.countDown(); // release all threads at once
  }
}


class MyClass implements Runnable {
  private String s;
  private CountDownLatch startSignal;
  private CountDownLatch endSignal;
  
  public MyClass(String s, 
                 CountDownLatch startSignal, 
                 CountDownLatch endSignal) {
    this.s = s;
    this.startSignal = startSignal;
    this.endSignal = endSignal;
  }

  public void run() {
    // threads will all start together (startSignal)
    //   .. will all wait together (endSignal)
    //   .. and then run to completion
    try {
      startSignal.await();
      System.out.print("\n" + s + " starting ...");
      print25();        // doesn't throw
      System.out.print("\n" + s + " waiting ...");
      endSignal.countDown();
      endSignal.await();
      print25();        // doesn't throw
      System.out.print("\n" + s + " ending ...");
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

