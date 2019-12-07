

//Exchanger



package Concurrency.Synchronizer.Exchanger;

import java.util.concurrent.*;

public class Test {
  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(2);
    Exchanger<Buffer> exchanger = new Exchanger<Buffer>();

    Buffer b1 = new Buffer("bufferA");
    Buffer b2 = new Buffer("bufferB");
    MyClass m1 = new MyClass("1", 50, b1, exchanger);
    MyClass m2 = new MyClass("2", 25, b2, exchanger);

    pool.execute(m1);
    pool.execute(m2);
    pool.shutdown();
  }
}

class Buffer {
  private String name;
  public Buffer(String name) {
    this.name = name;
  }
  public String toString() {
    return name;
  }
}

class MyClass implements Runnable {
  private String s;
  private int loops;
  private Buffer buffer;
  private Exchanger<Buffer> exchanger;

  public MyClass(String s, int loops, Buffer buffer, Exchanger<Buffer> exchanger) {
    this.s = s;
    this.loops = loops;
    this.buffer = buffer;
    this.exchanger = exchanger;
  }

  public void run() {
    try {
      System.out.println("\nThread " + s + " starting with " + buffer);
      print();
      System.out.println("\nThread " + s + " ready to exchange");
      buffer = exchanger.exchange(buffer);
      System.out.println("\nThread " + s + " ending with " + buffer);
    } catch(InterruptedException e) {
      System.err.println(e);
    }
  }

  public void print() {
    for(int i = 0; i < loops; i++) {
      System.out.print(s);
      try {
        int delay = (int)(500 * Math.random());
        Thread.sleep(delay);
      } catch(InterruptedException e) {
        System.err.println(e);
      }
    }
  }
}
