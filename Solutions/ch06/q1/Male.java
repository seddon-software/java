//Male.java	


package ch06.q1;

public class Male {
  private String name;
  private Marriage married;

  public Male(String n) {
    name = n;
  }

  public void SetSpouse(Marriage m) {
    married = m;
  }

  public void Print() {
    System.out.println(name);
  }

  public Female WhoIsSpouse() {
    if (married != null)
      return married.wife();
    else
      return null;
  }
}

