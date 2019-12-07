package ch10.q2;

import java.util.ArrayList;
import java.util.Iterator;

public class League {
  private ArrayList<Player> table;

  public League() {
		table = new ArrayList<Player>();
  }

	public void Add(Player p) {
		table.add(p);
	}

	public void Match(Player p1, int score1, Player p2, int score2) {
		p1.AddToScore(score1);
		p2.AddToScore(score2);
	}

	public void PrintTable() {
		Iterator iterator = table.iterator();
		while(iterator.hasNext()) {
			Player p = (Player) iterator.next();
			p.Display();
		}
	}
}
