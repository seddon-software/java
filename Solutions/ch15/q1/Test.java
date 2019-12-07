package ch15.q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Test {

  public static void main(String[] args) {

    TupleComparator comparator = new TupleComparator();
    ArrayList<Tuple> list = new ArrayList<Tuple>();
    Tuple a = new Tuple(2,5,3);
    Tuple b = new Tuple(1,1,4);
    Tuple c = new Tuple(5,2,9);
    Tuple d = new Tuple(7,0,2);
    Tuple e = new Tuple(2,2,5);
    Tuple f = new Tuple(0,7,5);
    Tuple g = new Tuple(1,4,6);
    Tuple h = new Tuple(4,1,2);
    Tuple i = new Tuple(6,2,7);

    list.add(a);
    list.add(b);
    list.add(c);
    list.add(d);
    list.add(e);
    list.add(f);
    list.add(g);
    list.add(h);
    list.add(i);

    Tuple min = Collections.min(list, comparator);
    min.Print();

    Collections.sort(list, comparator);

    for(int k = 0; k < list.size(); k++) {
      list.get(k).Print();
    }
  }
}

class TupleComparator implements Comparator<Tuple> {
  public int compare(Tuple lhs, Tuple rhs) {
    return lhs.Modulus() - rhs.Modulus();
  }
  
}

class Tuple {
  private int _1;
  private int _2;
  private int _3;
  
  public Tuple(int _1, int _2, int _3) {
    this._1 = _1;
    this._2 = _2;
    this._3 = _3;
  }
  
  public int Modulus() {
    return _1*_1 + _2*_2 + _3*_3;
  }
  
  public void Print() {
    System.out.println("("+_1+","+_2+","+_3+")="+Modulus());
  }
}



