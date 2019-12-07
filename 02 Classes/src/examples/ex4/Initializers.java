package examples.ex4;

public class Initializers {

	public static void main(String[] args) {
		Point p1 = new Point("origin");
		Point p2 = new Point("point-1", 270, 360);
		Point p3 = new Point("point-2", 290, 340);
		p1.moveBy(2, 3);
		p2.moveBy(1, 1);
		p3.moveBy(4, 0);
		System.out.println(p1); // calls toString()
		System.out.println(p2);
		System.out.println(p3);
	}

}


class Point {
	static {
		System.out.println("static initializer called on class load");
	}
	{
		System.out.println("instance initializer called on object creation");
	}
	private String name;
	
	private int x = 0;	// instance variable initializer
	private int y = 0;
	
	Point(String name, int x, int y) {
		System.out.println("CTOR called");		
		this.name = name;
		this.x = x;
		this.y = y;
	}
	Point(String name) {
		System.out.println("CTOR called");		
		this.name = name;
	}


	public void moveBy(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public String toString() {
		return String.format("Point %s is at [%s,%s]", name, x, y);
	}
}

