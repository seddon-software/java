package defaultMethods;


interface A {
	void f();
	void g();
	default int square(int x) {
		return x * x;
	}
}

interface B {
	void h();
	static void k() {}
	default int square(int x) {
		return x * x;
	}
}
public class X {

	public static void main(String[] args) {
		Z z = new Z();
		int a = z.square(5);
		z.k();
	}

}

class Z implements A, B {
	public void f() {}
	public void g() {}
	public void h() {}
	public void k() { B.k(); }
	@Override
	public int square(int x) {
		return A.super.square(x);
	}
}