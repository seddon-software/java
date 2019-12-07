////////////////////////////////////////////////////////////
//
//	Test.java	
//
////////////////////////////////////////////////////////////

package examples;

import java.util.ArrayList;
import java.util.List;

public class Erasure {

@SuppressWarnings("rawtypes")
public static void main(String[] args) {
    List<AAAA> listA = new ArrayList<AAAA>();
    List<BBBB> listB = new ArrayList<BBBB>();
    
    Class a = listA.getClass();
    Class b = listB.getClass();
    
    System.out.println("listA is in class: " + a.getName());
    System.out.println("listB is in class: " + b.getName());
  }
}

class AAAA {}
class BBBB {}


