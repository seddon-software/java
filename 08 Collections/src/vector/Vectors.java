////////////////////////////////////////////////////////////
//
//    Vector
//
////////////////////////////////////////////////////////////

package vector;

import java.util.*;


public class Vectors {
  public static void main(String[] args) {
    String[] names = {"New York", "Tokyo", "London", "Paris", "Rome"};
    Vector<String> v = new Vector<String>();

    // create collection
    for(int i = 0; i < names.length; i++) {
      v.add(names[i]);
    }

    // iterate using elementAt
    for(int i = 0; i < v.size(); i++) {
      String city = v.elementAt(i);
      System.out.println(i + ": " + city);
    }

    // iterate using enumerators
    Enumeration<String> e = v.elements();
    while(e.hasMoreElements()) {
      String city = e.nextElement();
      System.out.println(city);
    }
  }
}