package mvc.models;

public class Rugby {
	private String name;
	private int points;
	
	public Rugby(String name, int points) {
		this.name = name;
		this.points = points;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}
