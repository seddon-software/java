package examples.copyingAndCloning;

// The Object class defines a clone method:
//
//	protected native Object clone() throws CloneNotSupportedException;
//
// Derived classes can override this method to provide shallow copies,
// but they must implement the (empty) Clonnable interface.
// Caller's must provide a catch block

public class MyClonable {

	public static void main(String[] args) {
		Point p1 = new Point(5, 8);
		Point p2 = null;
			try {
				p2 = (Point) p1.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// the ids of p1 and p2 will be different
		System.out.println(p1);
		System.out.println(p2);
	}

}


class Point implements Cloneable {

	private final int x;
    private final int y;

	public Point clone() throws CloneNotSupportedException {
		return (Point) super.clone();
	}
	
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // ...
}
