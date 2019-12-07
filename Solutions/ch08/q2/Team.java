package ch08.q2;


public class Team
{
  private Player player1;
  private Player player2;
  private Player player3;

  public void Add(Player p) throws MyException {
    if(player1 == null) player1 = p;
    else if(player2 == null) player2 = p;
    else if(player3 == null) player3 = p;
    // should get to here
    else throw new MyException("Team is full");
  }

  public void Display() {
    System.out.println("Team is: ");
    System.out.println("\t" + player1);
    System.out.println("\t" + player2);
    System.out.println("\t" + player3);
  }
}