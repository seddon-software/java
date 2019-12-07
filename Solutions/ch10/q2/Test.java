
package ch10.q2;


public class Test {
  public static void main(String[] args) {
    Player john = new Player("John");
    Player peter = new Player("Peter");
    Player larry = new Player("Larry");
    Player tom = new Player("Tom");

    League theTable = new League();
    theTable.Add(john);
    theTable.Add(peter);
    theTable.Add(larry);
    theTable.Add(tom);

    theTable.Match(john,  5, peter, 5);
    theTable.Match(larry, 8, tom,   2);
    theTable.Match(john,  3, larry, 7);
    theTable.Match(peter, 6, tom,   4);
    theTable.Match(john,  0, tom,  10);
    theTable.Match(peter, 9, larry, 1);

    theTable.PrintTable();
  }
}

