////////////////////////////////////////////////////////////
//
//    Executor Example
//
////////////////////////////////////////////////////////////

package Concurrency.Executor.Simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(3);
    MyClass m1 = new MyClass("1");
    MyClass m2 = new MyClass("2");
    MyClass m3 = new MyClass("3");
    MyClass m4 = new MyClass("4");
    MyClass m5 = new MyClass("5");
    MyClass m6 = new MyClass("6");
    MyClass m7 = new MyClass("7");
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

  public MyClass(String s) {
    this.s = s;
  }

  public void run() {
    for(int i = 0; i < 25; i++) {
      System.out.print(s);
      try {
        int delay = (int)(100 * Math.random());
        Thread.sleep(delay);
      } catch(InterruptedException e) {
        System.err.println(e);
      }
    }
  }
}
