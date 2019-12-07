package rethrow;

class MyExceptionA extends Exception {
	public MyExceptionA(String message) {
		super(message);
	}
}

class MyExceptionB extends Exception {
	public MyExceptionB(String message, Throwable t) {
		super(message, t);
	}
}

public class Test {

	public static void main(String[] args) {
		try {
			f();
		} catch (MyExceptionB e) {
			e.printStackTrace();
		}
	}
	
	public static void f() throws MyExceptionB {
		try {
			throw new MyExceptionA("First message");
		} catch (Exception e) {
			// log it
			throw new MyExceptionB("Second message", e);
		}
	}

}
