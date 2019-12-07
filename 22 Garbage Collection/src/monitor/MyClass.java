package monitor;

public class MyClass {
	static long created;	
	static long freed;

	public MyClass(){
		created++;
	}	
	public void finalize(){
		freed++;
	}		
}

