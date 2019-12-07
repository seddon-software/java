
package ch10.q1;
import java.util.*;


public class Test
{
	public static void main(String[] args) {
		ArrayList<Shape> theList = new ArrayList<Shape>();
		theList.add(new Circle(10));
		theList.add(new Circle(20));
		theList.add(new Rectangle(15, 15));
		theList.add(new Rectangle(25, 15));
		theList.add(new Pie(50, 90));
		theList.add(new Pie(50, 45));

		Iterator i = theList.iterator();
		while(i.hasNext())
		{
			Shape s = (Shape) i.next();
			System.out.println("Area is: " + s.Area());
		}
	}
}



