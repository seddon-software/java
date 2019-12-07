////////////////////////////////////////////////////////////
//
//    ArrayList
//
////////////////////////////////////////////////////////////


package Concurrency.ThreadSafeCollections.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.*;

public class Test2 {
  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(10);
    ArrayList<Integer> list = 
      new ArrayList<Integer>(); 

    for(int i = 1; i <= 10; i++) {
      list.add(i);
    }


    for(int i = 1; i <= 10; i++) {
      pool.execute(new MyThread2(i, list));
    }
    pool.shutdown();

    for(int i = 0; i < 25; i++) {
      Print(list);
    }
  }

  public static void Print(ArrayList<Integer> list) {
    System.out.print("List: ");      
    try {
      Iterator<Integer> iterator = list.iterator();
      Thread.sleep(1000);
      while(iterator.hasNext()) {
        System.out.print(iterator.next());
      }
    } catch(InterruptedException e) {
      System.err.println(e);
    } catch(ConcurrentModificationException e) {
      System.err.println(e);
    }
    System.out.println();      
  }
}


class MyThread2 implements Runnable {
  private int n;
  private ArrayList<Integer> list;

  public MyThread2(int n, ArrayList<Integer> list) {
    this.n = n;
    this.list = list;
  }

  public void run() {
    int delay = 0;
    for(int i = 0; i < 25; i++) {
      try {
        delay = (int)(1000 * Math.random());
        Thread.sleep(delay);
        list.remove(list.indexOf(n));
        Thread.sleep(0);

        delay = (int)(100 * Math.random());
        Thread.sleep(delay);
        list.add(n);
      } catch(InterruptedException e) {
        System.err.println(e);
      }
    }
  }
}
