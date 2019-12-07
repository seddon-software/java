package utils;

public class Point {
	private int x;
	private int y;
	private String name;
	private static int count;

	public static int getCount() {
		return count;
	}
	// CTOR
	public Point(int x0, int y0, String name) {
		x = x0;
		y = y0;
		this.name = name;
		count++;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void display() {
		System.out.printf("Point %s is at [%d,%d]\n", name, x, y);
	}
}
