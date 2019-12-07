////////////////////////////////////////////////////////////
//
//  Priority Inversion
//
////////////////////////////////////////////////////////////



package Advanced.PriorityInversion;

public class Test {
  public static void main(String[] args) {

    Lock lock = new Lock();

    HighPriorityThread high = new HighPriorityThread(lock);
    MediumPriorityThread medium = new MediumPriorityThread(lock);
    LowPriorityThread low = new LowPriorityThread(lock);

    high.setPriority(8);
    medium.setPriority(5);
    low.setPriority(2);

    high.start();
    medium.start();
    low.start();        
  }

  public static void Delay() {
    for(long k = 0; k < 10000 * 10000; k++) {}
  }

  public static void Print(String s) {
    System.out.print(s);
  }
}


class Lock {
  int stage = 1;

  public int getStage() {
    return stage;
  }

  public void setStage(int stage) {
    this.stage = stage;
  }

}

class HighPriorityThread extends Thread {
  private Lock lock;

  public HighPriorityThread(Lock lock) {
    this.lock = lock;
  }

  public void run() {
    for(int i = 0; i < 10; i++) {
      Test.Print("H");
    }

    try {
      synchronized(lock) {
        while(lock.getStage() < 2) {
          Test.Print("W");
          lock.wait();
        }
      }
    } catch(InterruptedException e) {
      // ...
    }

    for(int i = 0; i < 10; i++) {
      Test.Print("H");
    }

  }

}

class MediumPriorityThread extends Thread {
  private Lock lock;

  public MediumPriorityThread(Lock lock) {
    this.lock = lock;
  }

  public void run() {
    for(int i = 0; i < 100; i++) {
      Test.Print("M");
      Test.Delay();
      if(i % 20 == 0) Test.Print("\n"); 
    }
  }

}

class LowPriorityThread extends Thread {
  private Lock lock;

  public LowPriorityThread(Lock lock) {
    this.lock = lock;
  }

  public void run() {
    for(int i = 0; i < 10; i++) {
      Test.Print("L");
    }

    synchronized(lock) {
      for(int i = 0; i < 10; i++) {
        Test.Print("L");
        Test.Delay();
        lock.setStage(2);
      }            
      lock.notifyAll();
    }
  }

}

