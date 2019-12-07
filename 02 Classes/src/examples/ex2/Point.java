package examples.ex2;


public class Point {
	private String name;
	private int x;
	private int y;
	
	Point(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public void moveBy(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public String toString() {
		return String.format("Point %s is at [%s,%s]", name, x, y);
	}
}