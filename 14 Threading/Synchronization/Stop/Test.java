////////////////////////////////////////////////////////////
//
//    Example of Stopping a Thread
//
////////////////////////////////////////////////////////////

package Synchronization.Stop;

import java.lang.Math;
import java.util.concurrent.TimeUnit;


public class Test {
  public static void main(String[] args) {

    MyClass m1 = new MyClass("1");
    MyClass m2 = new MyClass("2");
    MyClass m3 = new MyClass("3");
    MyClass m4 = new MyClass("4");
    
    try {
      Thread.sleep(5 * 1000);
    } catch(InterruptedException ignore) {}
    
    m4.terminate();
    m3.terminate();
    m2.terminate();
    m1.terminate();
  }
}

class MyClass implements Runnable {
  private String s;
  private Thread thread;
  
  public MyClass(String s0) {
    s = s0;
    thread = new Thread(this);
    thread.start();
  }

  public void terminate() {
    thread.interrupt();
  }

  public void run() {
    while(!Thread.interrupted()) print10();
  }
  
  private void print10() {
    for(int i = 0; i < 10; i++)
    {
      try {
        System.out.print(s);
        int delay = (int)(10 * Math.random());
        TimeUnit.MILLISECONDS.sleep(delay);
      } catch(InterruptedException e) {
        thread.interrupt();     // reset the flag        
      }
    }
    System.out.println();
    
  }
}

