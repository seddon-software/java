package monitor;

import java.util.ArrayList;

public class Test extends Thread {
	
	public static void main(String[]  args){
		new Test().start();
	}
	
	public void run(){
		long start = System.currentTimeMillis();
		long then = start;
		while(true){			
			randomDelay();
			createYoungObjects();
			createObjectsInPermGen();
			then = printStatistics(start, then);
		}
	}

	private long printStatistics(long start, long then) {
		long now = System.currentTimeMillis();
		if (now - then > 1000){					
			System.out.println(
				((now - start)/1000) + " s\t" + 
				MyClass.created + " created\t" + 
				MyClass.freed + " freed"
			);
			then = now;
		}
		return then;
	}

	private void createYoungObjects() {
		int count = (int) Math.round(Math.random() * 10 * 1000);
		for (int i=0; i < count; i++){
			new MyClass();
		}
	}

	private void createObjectsInPermGen() {
		int count = (int) Math.round(Math.random() * 10 * 1000);
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i=0; i < count; i++) {
			list.add(new String("s" + i).intern());
			new MyClass();
		}
	}
	
	private void randomDelay() {
		try {					
			int delay = (int) Math.round(100 * Math.random());
			Thread.sleep(delay);
		} catch(InterruptedException e){ }
	}	
	
}

