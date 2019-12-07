////////////////////////////////////////////////////////////
//
//  Daemon Threads
//
////////////////////////////////////////////////////////////

package Advanced.DaemonThreads;


public class Test {
    public static void main(String[] args) {

        MyThread t1 = new MyThread("1", 10);
        MyThread t2 = new MyThread("2", 250);
        MyThread t3 = new MyThread("3", 250);
        MyThread t4 = new MyThread("4", 250);
        
        t2.setDaemon(true);
        t3.setDaemon(true);
        t4.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}



class MyThread extends Thread {
    private String s;
    private int loops;

    public MyThread(String s, int loops) {
        this.s = s;
        this.loops = loops;
    }

    public void run() {
        for(int i = 0; i < loops; i++) {
            System.out.print(s);
            if(i % 50 == 0) System.out.print("\n"); 
        }
    }
}

