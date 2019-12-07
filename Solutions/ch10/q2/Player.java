////////////////////////////////////////////////////////////
//
//		Squash
//
////////////////////////////////////////////////////////////

package ch10.q2;

public class Player {
	private String name;
	private int score;

	public Player(String n) {
		name = n;
	}

	public void AddToScore(int s) {
		score += s;
	}

	public void Display() {
		System.out.println(name + " has a score of " + score);
	}
}

