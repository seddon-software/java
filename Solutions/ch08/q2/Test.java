package ch08.q2;


public class Test
{
  public static void main(String[] args) {
    Team united = new Team();

    Player scholes = new Player("Paul Scholes");
    Player giggs = new Player("Ryan Giggs");
    Player yorke = new Player("Dwight Yorke");
    Player cole = new Player("Andy Cole");

    try {
      united.Add(scholes);
      united.Add(giggs);
      united.Add(yorke);
      united.Add(cole);
    } catch (MyException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      united.Display();
    }
  }
}
