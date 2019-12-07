////////////////////////////////////////////////////////////
//
//	AutoBoxing
//
////////////////////////////////////////////////////////////

package AutoBoxing;

import java.util.*;

public class Test {

  public static void main(String[] args) {
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    
    for(int i = 0; i < list.size(); i++) {
      int x = list.get(i);
      System.out.println(x);
    }
    
    list.add(0, null);
    try {
      int x = list.get(0);
    } catch(NullPointerException e) {
      System.out.println(e);      
    }
  }
}

