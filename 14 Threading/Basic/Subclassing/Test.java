////////////////////////////////////////////////////////////
//
//  Subclassing 
//
////////////////////////////////////////////////////////////




package Basic.Subclassing;


import java.lang.Math;

public class Test {
	public static void main(String[] args){

		// create thread objects
		MyThread t1 = new MyThread("1");
		MyThread t2 = new MyThread("2");
		MyThread t3 = new MyThread("3");
		MyThread t4 = new MyThread("4");

		// run each thread
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}


class MyThread extends Thread {

	private String s;

	public MyThread(String s) {
		this.s = s;
	}

	public void run() {
		for(int i = 1; i <= 25; i++)
		{
			System.out.print(s);
			int delay = (int)(100 * Math.random());
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

