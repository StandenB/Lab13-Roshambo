package lab13roshambo;

// import java.util.concurrent.ThreadLocalRandom;

public class RandomPlayer extends Player {

	public RandomPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		// int random = ThreadLocalRandom.current().nextInt(1, 4);
		int random2 = (int) (Math.random() * 3) + 1;
		
		switch (random2) {
		case 1:
			return Roshambo.ROCK;
		case 2:
			return Roshambo.PAPER;
		case 3:
			return Roshambo.SCISSORS;
		default :
			return null;
		}
	}
}
