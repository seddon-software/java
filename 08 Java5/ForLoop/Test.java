////////////////////////////////////////////////////////////
//
//	ForLoop
//
////////////////////////////////////////////////////////////

package ForLoop;

import java.util.*;

public class Test {

  public static void main(String[] args) {
    Vector<String> colors = new Vector<String>();
    colors.add("green");
    colors.add("yellow");
    colors.add("red");
    colors.add("blue");
    colors.add("cyan");

    for (Iterator i = colors.iterator(); i.hasNext();) {
      System.out.println(i.next());
    }

    System.out.println("======================");

    for (Object color : colors) {
      try {
        if (color.equals("red")) colors.remove(color);
        System.out.println(color);
      } catch(ConcurrentModificationException e) {
        // exception thrown by another thread
        System.err.println(e);
      }
    }
  }
}
