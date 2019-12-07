
package ch07.q3;

public class Test {
  public static void main(String[] args) {
    Shape[] list = new Shape[8];
    list[0] = new Circle(0, 0, 50);
    list[1] = new Rectangle(1, 1, 20, 25);
    list[2] = new Polygon(2, 2, 5);
    list[3] = new Circle(3, 3, 50);
    list[4] = new Circle(4, 4, 80);
    list[5] = new Polygon(5, 5, 12);
    list[6] = new Circle(6, 6, 35);
    list[7] = new Rectangle(7, 7, 78, 51);
    Print(list);
  }

  static void Print(Shape[] theList) {
    for(int i = 0; i < theList.length; i++) {
      System.out.println(theList[i].Details());
    }
  }
}

