package CompilingClassloader;




public class MyClassA {
  static public void main( String args[] ) throws Exception {
    System.out.println("calling main");
    new MyClassB();
  }

  static public void f(String s1, String s2) {
    System.out.println("calling f(String, String)");
    System.out.println(s1 + s2);
    new MyClassB();
  }
}