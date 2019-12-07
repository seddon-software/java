package examples.copyingAndCloning;

// you can use a copy constructor in preference to cloning for copying objects

public class CopyConstructor {

	public static void main(String[] args) {
		Item printer1 = new Item("Laser", "Medium", 30);
		Item printer2 = new Item(printer1);	// copy CTOR
		System.out.println(printer1);
		System.out.println(printer2);
	}

}

class Item {
	// CTOR
	public Item(String name, String size, double weight) {
		this.name = name;
		this.size = size;
		this.weight = weight;		
	}
	// copy CTOR
	public Item(Item p) {
		this.name = p.name;
		this.size = p.size;
		this.weight = p.weight;
	}
	private String name;
	private String size;
	private double weight;
}