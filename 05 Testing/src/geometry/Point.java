package geometry;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveBy(int dx, int dy) throws Exception {
		x += dx;
		y += dy;
	}
	
	public void reflectAboutTheOrigin() {
		x = -x;
		y = -y;
	}
	public int distanceSquared() throws Exception {
		int distanceSq;
		distanceSq = x * x + y * y;
		if(distanceSq > 100) throw new TooFar("from origin");
		return distanceSq;
	}
	
	public boolean equals(Object o) {
		Point q = (Point) o;
		if(this.x != q.x) return false;
		if(this.y != q.y) return false;
		return true;
	}
}

class TooFar extends Exception {
	public TooFar(String message) {
		super(message);
	}
}
