package greetings;

import utils.Point;

public class Hello {

	private static void doIt(Point p1, Point p2, Point p3) {
		p1.moveBy(1, 1);
		p2.moveBy(2, 3);
		p3.moveBy(3, 6);
		p1.display();
		p2.display();
		p3.display();
	}
	public static void main(String[] args) {
		Point p1 = new Point(100, 200, "point-1");
		Point p2 = new Point(110, 230, "point-2");
		Point p3 = new Point(120, 240, "point-3");
		doIt(p1, p2, p3);
		System.out.println(Point.getCount());
		
	}


}

