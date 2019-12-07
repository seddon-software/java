

//Marriage



package ch06.q1;

public class Test {
  public static void main(String[] args) {
    Male   bob   = new Male("Bob");
    Female carol = new Female("Carol");
    Male   ted   = new Male("Ted");
    Female alice = new Female("Alice");

    Marriage pair1 = new Marriage(bob, carol);
    Marriage pair2 = new Marriage(ted, alice);

    pair1.wife().Print();
    pair2.husband().Print();

    carol.WhoIsSpouse().Print();
    ted.WhoIsSpouse().Print();
  }
}




