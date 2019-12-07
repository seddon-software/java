////////////////////////////////////////////////////////////
//
//		Static Methods
//
////////////////////////////////////////////////////////////

package ch04;

public class TestStatics {
	public static void main(String[] args) {
		Phone dicksPhone = new Phone("Dick");
		Phone johnsPhone = new Phone("John");
		Phone marysPhone = new Phone("Mary");
		dicksPhone.call( 3, 15);
		johnsPhone.call( 2, 10);
		dicksPhone.call(15, 30);
		marysPhone.call(10,  0);
		dicksPhone.call( 3, 15);
		johnsPhone.call( 1,  0);
		marysPhone.call( 2, 15);
		marysPhone.call(12, 15);
		dicksPhone.call( 9,  0);
		johnsPhone.call(30, 45);
		dicksPhone.call(17, 15);

		dicksPhone.PrintTotals();
		johnsPhone.PrintTotals();
		marysPhone.PrintTotals();

		Phone.HowManyCalls();
	}
}

class Phone {
  private static int totalCalls;
	private int minutes;
	private int seconds;
	private String name;

	public Phone(String n) {
		name = n;
	}

	public static void HowManyCalls() {
		System.out.println("There have been " + totalCalls + " calls");
	}

	public void PrintTotals() {
		System.out.println(name + " has used " + minutes + ":" + seconds);
	}

	public void call(int m, int s) {
		seconds += s;
		minutes += m + seconds/60;
		seconds = seconds%60;
		totalCalls++;
	}

}

