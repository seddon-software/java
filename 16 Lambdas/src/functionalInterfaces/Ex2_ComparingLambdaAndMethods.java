package functionalInterfaces;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Ex2_ComparingLambdaAndMethods {
	static List<Person> staff = new ArrayList<Person>();
	
    public static void findPersonsOlderThan(int age) {
        for (Person p : staff) {
            if (p.getAge() >= age) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
	    staff.add(new Person("John", 23));
	    staff.add(new Person("Zoe", 41));
	    staff.add(new Person("Paul", 29));
	    staff.add(new Person("Abdul", 17));
	    staff.add(new Person("Zia", 33));
	    System.out.println(staff);

	    // traditional method call
	    findPersonsOlderThan(35);

	    // lambda call
	    Consumer<Integer> findPersonsOlderThan = (x) -> {
	        for (Person p : staff) {
	            if (p.getAge() >= x) {
	                System.out.println(p);
	            }
	        }  
	    };
	    findPersonsOlderThan.accept(35);
    };
}

class Person {
	public String getName() {
		return name;
	}
	public String toString() {
		return name + ", " + age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
}