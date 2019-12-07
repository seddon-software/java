package polymorphism2;

public class TestPerson {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		SalesPerson s1 = new SalesPerson();
		SalesPerson s2 = new SalesPerson();
		NightOut(e1);
		NightOut(s1);
		NightOut(p1);
	}
	public static void NightOut(Person p) {
		p.drink();
		p.drink();
		p.eat();
		p.drink();
		p.sleep();
	}
}

class Person {
	public void eat() { System.out.println("MacDonalds"); }
	public void drink() { System.out.println("Gin"); }
	public void sleep() { System.out.println("ZZZZZZZZZZZZ"); }
}

class Employee extends Person {
	public void eat() {
		super.eat();
		System.out.println("Zizzi"); 
	}
	public void drink() { System.out.println("Prosecco"); }	
}

class SalesPerson extends Employee {
	public void eat() { System.out.println("Fat Duck"); }
	public void drink() { System.out.println("Bolly"); }	
}