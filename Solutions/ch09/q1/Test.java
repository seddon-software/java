

//Polymorphism



package ch09.q1;


public class Test
{
  public static void main(String[] args) {
    Shape[] theList = new Shape[6];
    theList[0] = new Circle(10);
    theList[1] = new Circle(20);
    theList[2] = new Rectangle(15, 15);
    theList[3] = new Rectangle(25, 15);
    theList[4] = new Pie(50, 90);
    theList[5] = new Pie(50, 45);

    for(int i = 0; i < theList.length; i++) {
      System.out.println("Area is: " + theList[i].Area());
    }
  }
}


