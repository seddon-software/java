////////////////////////////////////////////////////////////
//
//  ThreadLocal Storage
//
////////////////////////////////////////////////////////////



package Basic.ThreadLocal;
import java.lang.Math;

public class Test {

  public static void main(String[] args){

    // create thread objects
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();
    MyThread t3 = new MyThread();
    MyThread t4 = new MyThread();

    // run each thread
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}


class MyThread extends Thread {

  public void run() {
    // each thread gets its own reference to a ThreadLocal
    ThreadLocal<Integer> id = new ThreadLocal<Integer>();
    id.set((int)(100 * Math.random()));

    for(int i = 1; i <= 10; i++)
    {
      System.out.print("," + id.get());
      try {
        int delay = (int)(10 * Math.random());
        Thread.sleep(delay);
      } catch(Exception e) {
        // ignore
      }
    }
  }
}

