package polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void NightOut(Person p) {
		p.drink();
		p.eat();
		p.sleep();
	}
	
	public static void GroupNightOut(List<Person> list) {
		for(Person p : list) NightOut(p);
	}
	
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		SalesPerson s1 = new SalesPerson();
		SalesPerson s2 = new SalesPerson();
		NightOut(s2);
		List<Person> list = new ArrayList<Person>();
		list.add(s1);
		list.add(p2);
		list.add(e1);
		list.add(p2);
		GroupNightOut(list);
	}

}

class Person {
	public void eat() { System.out.println("MacDonalds"); }
	public void drink() { System.out.println("Beer"); }
	public void sleep() {  System.out.println("ZZZZZZZ"); }
}

class Employee extends Person {
	public void eat() { System.out.println("Nandos"); }
	public void drink() { System.out.println("Wine"); }
}

class SalesPerson extends Employee {
	public void eat() { System.out.println("Fat Duck"); }
	public void drink() { System.out.println("Champagne"); }
}

