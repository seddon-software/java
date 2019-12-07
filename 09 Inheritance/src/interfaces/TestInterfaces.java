package interfaces;

public class TestInterfaces {

	public static void main(String[] args) {
		Shape t = null;
		Shape r = null;
		Shape e = null;
		try {
			t = ShapeFactory.create("Triangle");
			r = ShapeFactory.create("Rectangle");
			e = ShapeFactory.create("Ellipse");
		} catch (Exception ex) {
			// log it
			ex.printStackTrace();
		}
		showAnyShape(t);
		showAnyShape(r);
		showAnyShape(e);
	}
	
	public static void showAnyShape(Shape s) {
		s.show();
	}

}

class ShapeFactory {
	public static Shape create(String type) throws Exception {
		Shape result = null;
		if(type.equals("Triangle")) result = new Triangle();
		if(type.equals("Rectangle")) result = new Rectangle();
		if(type.equals("Ellipse")) result = new Ellipse();
		if(result == null) throw new Exception("Illegal type");
		return result;
	}
}

interface IShape {
	void draw();
	void show();
	void hide();
}
abstract class Shape implements IShape {
	abstract public void draw();
	public void show() { System.out.println("default impl"); }
	public void hide() { System.out.println("default impl"); }
}
class Triangle extends Shape {
	public void draw() { System.out.println("Triangle draw"); }
	public void show() { super.show(); System.out.println("Triangle show"); }
	public void hide() { System.out.println("Triangle hide"); }	
}
class Rectangle extends Shape {
	public void draw() { System.out.println("Rectangle draw"); }
	public void show() { System.out.println("Rectangle show"); }
	public void hide() { System.out.println("Rectangle hide"); }	
}
class Ellipse extends Shape {
	public void draw() { System.out.println("Ellipse draw"); }
	public void show() { System.out.println("Ellipse show"); }
	public void hide() { System.out.println("Ellipse hide"); }	
}