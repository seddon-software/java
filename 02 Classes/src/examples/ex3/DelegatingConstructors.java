package examples.ex3;

public class DelegatingConstructors {

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
	private String name;
	private int x;
	private int y;
	
	Point(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	Point(String name) {
		this(name, 0, 0);  // delegating constructor
	}
	
	public void moveBy(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public String toString() {
		return String.format("Point %s is at [%s,%s]", name, x, y);
	}
}

