////////////////////////////////////////////////////////////
//
//  Deadlock
//
////////////////////////////////////////////////////////////

package Advanced.Deadlock;


public class Test {
    public static void main(String[] args) {

        Lock lock1 = new Lock("1");
        Lock lock2 = new Lock("2");
        
        // acquiring locks in a different order can cause deadlock
        MyClass m1 = new MyClass("1", lock1, lock2);
        MyClass m2 = new MyClass("2", lock2, lock1);
        
        m1.start();
        m2.start();
    }
}


class Lock {
    private String s;
    public Lock(String s) {
        this.s = s;
    }
    public String getId() {
        return s;
    }
}

class MyClass extends Thread {
    private String s;
    private Lock lockA;
    private Lock lockB;

    public MyClass(String s, Lock lockA, Lock lockB) {
        this.s = s;
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run() {
        System.out.println("Thread " + s + " started");
        synchronized(lockA) {
            System.out.println("Thread " + s + " acquired lock" + lockA.getId());
            yield();
            synchronized(lockB) {
                System.out.println("Thread " + s + " acquired lock" + lockB.getId());
            }
        }
    }
}

