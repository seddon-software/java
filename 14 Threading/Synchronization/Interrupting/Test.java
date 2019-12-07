package Synchronization.Interrupting;

// This test demonstrates that if you interrupt a thread it will not
// receive an InterruptedException if it doesn't enter a wait state

public class Test {
	public static void main(String[] args) {

		Worker good = new WellBehavedWorker();
		Worker bad = new BadlyBehavedWorker();
		Worker sleepy = new SleepyWorker();
		
		Thread goodThread = new Thread(good);
		Thread badThread = new Thread(bad);
		Thread sleepyThread = new Thread(sleepy);
		
		goodThread.start();
		badThread.start();
		sleepyThread.start();

		goodThread.interrupt();
		badThread.interrupt();
		badThread.interrupt();
		badThread.interrupt();
		sleepyThread.interrupt();
	}
}

abstract class Worker implements Runnable {
	public void delay() {
		for(long i = 0; i < 1000 * 1000 * 200; i++) {
		}
	}	
}

class WellBehavedWorker extends Worker {
	public void run() {
		try {
			while(!Thread.currentThread().isInterrupted()) {
				Thread.sleep(0);	// wait briefly (otherwise can't catch InterruptedException) 
				delay();
				System.out.print("G");  // indicate we are still alive
			}
		} catch(InterruptedException e) {
			// ignore
		}
		System.out.println("\nWell behaved worker thread about to exit");		
	}
}

class BadlyBehavedWorker extends Worker implements Runnable {
	public void run() {
		try {
			while(true) {
				Thread.sleep(0);	// wait briefly (otherwise can't catch InterruptedException) 
				delay();
				System.out.print("B");  // indicate we are still alive
			}
		} catch(InterruptedException e) {
			// ignore
		}
		System.out.println("\nBadly behaved worker thread about to exit");		
	}
}

class SleepyWorker extends Worker implements Runnable {
	public void run() {
		try {
			while(true) {
				Thread.sleep(1000);	
				delay();
				System.out.print("S");  // indicate we are still alive
			}
		} catch(InterruptedException e) {
			// ignore
		}
		System.out.println("\nSleepy worker thread about to exit");		
	}
}

