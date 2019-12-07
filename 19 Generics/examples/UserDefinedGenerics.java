////////////////////////////////////////////////////////////
//
//	Test.java	
//
////////////////////////////////////////////////////////////

package examples;

class A {}
class B extends A {}
class C extends B {}

class Box<T> {
	private T item;

	public T get() {
		return item;
	}

	public void put(T item) {
		this.item = item;
	}
}

public class UserDefinedGenerics {
	public static void f(Box<? extends B> box) {
		try {
			C a = (C) box.get();
		} catch (ClassCastException e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
		try {
			Box<B> box = new Box<B>();
			box.put(new B());
			B b = box.get();
			box.put(new B());
			C c = (C) box.get();

			box.put(new C());
			f(box);
		} catch (ClassCastException e) {
			System.err.println(e);
		}
	}
}
