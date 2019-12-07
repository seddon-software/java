////////////////////////////////////////////////////////////
//
//	Test.java
//
////////////////////////////////////////////////////////////

package StaticImports;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class Test {
  public static void main(String[] args) {
    double d1 = Math.cos(Math.PI * 100.0);
    double d2 = cos(PI * 100.0);
  }
}

