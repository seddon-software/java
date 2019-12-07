package examples.ex2;

public class TestPoint {

	public static void main(String[] args) {
		Point p1 = new Point("point-1", 250, 380);
		Point p2 = new Point("point-2", 270, 360);
		Point p3 = new Point("point-3", 290, 340);
		p1.moveBy(2, 3);
		p2.moveBy(1, 1);
		p3.moveBy(4, 0);
		System.out.println(p1); // calls toString()
		System.out.println(p2);
		System.out.println(p3);
	}

}

