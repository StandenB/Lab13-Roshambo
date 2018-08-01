package lab13roshambo;

public abstract class Player {

	private String name;
	
	// constructor to input names
	public Player (String name) {
		super();
		this.name = name;
	}
	
	// getter - don't need setter since we are not allowing name changes
	public String getName() {
		return name;
	}
	// return one of ROCK, PAPER, SCISSORS
	public abstract Roshambo generateRoshambo();
	
	public String toString() {
		return "Player " + name;
	}
}
