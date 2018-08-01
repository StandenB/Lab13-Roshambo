package lab13roshambo;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String cont = "y";
		int wins = 0, loses = 0, ties = 0;
		double percent = 0.0;
		
		// create human player
		System.out.println("Welcome to Rock, Paper, Scissors!");
		String humanName = Validator.getString(scnr, "What is your name human?");
		HumanPlayer human = new HumanPlayer(humanName, scnr);
		
		// Select an opponent
		int opponent = Validator.getInt(scnr, "Select opponent (1 or 2): ", 1, 2);
		Player challenger;
		
		if (opponent == 1) {
			challenger = new RandomPlayer("Tinder");
		}
		else {
			challenger = new RockPlayer("Dwayne");
		}
		System.out.println("You are now playing " + challenger.getName());		

		// game loop structure with tracking wins, loses and ties
		do {
			
			String result = playTheGame(human, challenger);
			
			if (result.equals("wins")) {
				wins = wins + 1;
			}
			else if (result.equals("loses")) {
				loses = loses + 1;
			}
			else {
				ties = ties + 1;
			}
			cont = Validator.getStringMatchingRegex(scnr, "Do you want to continue (y/n)? ",
					"y|Y|n|N");
		} while (cont.equalsIgnoreCase("y"));
		
		// print out final results
		System.out.println("Final Score:");
		System.out.println("Wins\tLoses\tTies");
		System.out.println("=====\t=====\t=====");
		System.out.println(wins + "\t" + loses + "\t" + ties);
		
		percent = 100.0 * ((double) wins / (wins + (double) loses));
		System.out.println("Winning percent = " + percent + "%");
		
		if (percent > 50) {
			System.out.println("\nGreat Job! Thanks for playing");
		}
		else {
			System.out.println("\nBetter luck next time - wah, wah...");
		}
	}
		
		
	// method for running roshambo and determining winner
	private static String playTheGame(HumanPlayer human, Player challenger) {
		Roshambo input = human.generateRoshambo();
		Roshambo computerOutput = challenger.generateRoshambo();
		String result = null;
		System.out.println("You selected: " + input);
		System.out.println(challenger.getName() + " selected: " + computerOutput);
		
		if (input == Roshambo.PAPER && computerOutput == Roshambo.ROCK) {
			System.out.println(human.getName() + " won!");
			result = "wins";
			return result;
		}
		else if (input == Roshambo.SCISSORS && computerOutput == Roshambo.PAPER) {
			System.out.println(human.getName() + " won!");
			result = "wins";
			return result;
		}
		else if (input == Roshambo.ROCK && computerOutput == Roshambo.SCISSORS) {
			System.out.println(human.getName() + " won!");
			result = "wins";
			return result;
		}
		else if (input == computerOutput) {
			System.out.println("Sad emoji face: Tie");
			result = "ties";
			return result;
		}
		else {
			System.out.println("The machines are winning");
			result = "loses";
			return result;
		}
	}
	
}
