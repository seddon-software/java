package nestedClasses.anonymous;

public class Test {

	public static void main(String[] args) {

		{
			// impl is an instance of a class that extends MyClass
			MyClass impl = new MyClass() {
				public void g1() { System.out.println("g1() called ..."); }
				public void g2() { System.out.println("g2() called ..."); }
			};
			impl.g1();	
			impl.g2();	
			System.out.println("class=" + impl.getClass().getName());
		}
		{
			// impl is an instance of a class that implements MyInterface
			MyInterface impl = new MyInterface() {
				public void f1() { System.out.println("f1() called ..."); }
				public void f2() { System.out.println("f2() called ..."); }
			};
			impl.f1();	
			impl.f2();	
			System.out.println("class=" + impl.getClass().getName());
		}
	}
}



class MyClass {
	public void g1() {}
	public void g2() {}
}

interface MyInterface {
	public void f1();
	public void f2();
}
