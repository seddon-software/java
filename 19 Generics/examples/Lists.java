////////////////////////////////////////////////////////////
//
//	Test.java	
//
////////////////////////////////////////////////////////////

package examples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lists {

  public static void main(String[] args) {
    List<Integer> myList = new LinkedList<Integer>();
    myList.add(new Integer(2));
    myList.add(new Integer(3));
    myList.add(new Integer(5));
    myList.add(new Integer(7));
    myList.add(11);

    // old loop syntax
    for(Iterator<Integer> i = myList.iterator(); i.hasNext(); ) {
      int x = i.next();
      System.out.println(x);
    }

    // new loop syntax
    for (Integer i : myList) {
      System.out.println(i);
    }
  }
}

