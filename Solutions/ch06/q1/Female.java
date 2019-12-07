//Female.java	


package ch06.q1;

public class Female {
  private String name;
  private Marriage married;

  public Female(String n) {
    name = n;
  }

  public void SetSpouse(Marriage m) {
    married = m;
  }

  public void Print() {
    System.out.println(name);
  }

  public Male WhoIsSpouse() {
    if (married != null)
      return married.husband();
    else
      return null;
  }
}

