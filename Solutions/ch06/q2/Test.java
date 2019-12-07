package ch06.q2;

public class Test {
  public static void main(String[] args) {
    Driver M_Schumacher = new Driver("Michael", "Schumacher");
    Driver R_Schumacher = new Driver("Ralph", "Schumacher");
    Driver J_Button = new Driver("Jenson", "Button");
    Driver E_Irvine  = new Driver("Eddie", "Irvine");
    Manufacturer ferrari = new Manufacturer("Ferrari");
    Manufacturer williams = new Manufacturer("Williams");

    ferrari.Employ(M_Schumacher);
    ferrari.Employ(E_Irvine);
    williams.Employ(R_Schumacher);
    williams.Employ(J_Button);

    ferrari.WhatIsYourTeam();
    williams.WhatIsYourTeam();

    ferrari.Release(E_Irvine);
    williams.Release(J_Button);
    ferrari.Employ(J_Button);
    williams.Employ(E_Irvine);

    ferrari.WhatIsYourTeam();
    williams.WhatIsYourTeam();
  }
}
