package lab13roshambo;

public class RockPlayer extends Player {

	// constructor - never has a retun type
	public RockPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}
}
