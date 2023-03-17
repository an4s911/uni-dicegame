import java.util.Scanner;

public class DiceGame {
	private static int playerGrandTotal = 0;
	private static int playerTurnTotal = 0;

	private static int computerGrandTotal = 0;
	private static int computerTurnTotal = 0;

	private static PairOfDice playerDice = new PairOfDice();
	private static PairOfDice computerDice = new PairOfDice();

	public static void main(String[] args) {

		System.out.println("Welcome to the DiceGame. It's you against the computer.\n" +
				"You play by rolling the dice. The first player to get 100\n" +
				"points wins. However, if you roll one 1 you lose all the \n" +
				"points you've accumulated in your turn. If you roll two 1's,\n" +
				"you lose all your points. You can turn over the dice over at\n" +
				"any time. However, if you roll one or two 1's, you lose your\n" +
				"turn. I (the computer) play by the same rules, except I'll\n" +
				"always turn over the dice when I've rolled20 or more points\n" +
				"in a single turn.\n" +
				"Ready to begin? (Type 'y' when you're ready)");

		char choice = getChoiceFromPlayer("");

		if (choice != 'y') {
			return;
		}

		while (true) {
			boolean playerWins = emulatePlayerTurn();
			if (playerWins) {
				System.out.println("You won!");
				printScores();
				break;
			}

			boolean computerWins = emulateComputerTurn();
			if (computerWins) {
				System.out.println("Better luck next time!");
				printScores();
				break;
			}
		}

	}

	public static boolean emulatePlayerTurn() {
		boolean running = true;
		while (running) {
			System.out.println("You're rolling the dice...");
			playerDice.roll();
			System.out.println("You rolled " + playerDice.toString());

			int validation = validateRoll(playerDice);
			if (validation > 0) {
				playerTurnTotal += playerDice.getDiceSum();

				if (checkPlayerWin()) {
					playerGrandTotal += playerTurnTotal;
					return true;
				}

				printPlayerScores();
				char choice = getChoiceFromPlayer("Do you want to continue rolling? (Type 'y' when you're ready)");
				running = (choice == 'y');

			} else if (validation == 0) {
				System.out.println("You got a 1!");
				playerTurnTotal = 0;
			} else {
				System.out.println("You got two 1's!");
				playerTurnTotal = 0;
				playerGrandTotal = 0;
			}

			if (validation <= 0) {
				getChoiceFromPlayer("Continue? (Type 'y' when you're ready to turn the dice over to me)");
				running = false;
			}
		}

		playerGrandTotal += playerTurnTotal;
		playerTurnTotal = 0;

		printScores();

		return false;
	}

	public static boolean emulateComputerTurn() {
		boolean running = true;
		while (running) {
			System.out.println("I'm rolling the dice...");
			computerDice.roll();
			System.out.println("I rolled " + computerDice);

			int validation = validateRoll(computerDice);
			if (validation > 0) {
				computerTurnTotal += computerDice.getDiceSum();
				if (checkComputerWin()) {
					computerGrandTotal += computerTurnTotal;
					return true;
				}

				printComputerScores();
			} else if (validation == 0) {
				System.out.println("I got a 1!");
				computerTurnTotal = 0;
			} else {
				System.out.println("I got two 1's");
				computerTurnTotal = 0;
				computerGrandTotal = 0;
			}

			if (computerTurnTotal >= 20) {
				System.out.println("I got more than 20 in this turn!");
			}

			if (validation <= 0 || computerTurnTotal >= 20) {
				getChoiceFromPlayer("Continue? (Type 'y' when you're ready)");
				running = false;
			}
		}

		computerGrandTotal += computerTurnTotal;
		computerTurnTotal = 0;

		printScores();

		return false;
	}

	public static boolean checkPlayerWin() {
		if ((playerGrandTotal + playerTurnTotal) >= 100) {
			return true;
		}
		return false;
	}

	public static boolean checkComputerWin() {
		if ((computerGrandTotal + computerTurnTotal) >= 100) {
			return true;
		}
		return false;
	}

	public static void printPlayerScores() {
		System.out.println("This gives you a turn total of\n" +
				"\t" + playerTurnTotal);
		System.out.println("and a grand total of\n" +
				"\t" + (playerGrandTotal + playerTurnTotal));
		System.out.println("The computer has a total of\n" +
				"\t" + computerGrandTotal);
		System.out.println();
	}

	public static void printComputerScores() {
		System.out.println("This gives me a turn total of\n" +
				"\t" + computerTurnTotal);
		System.out.println("and a grand total of\n" +
				"\t" + (computerGrandTotal + computerTurnTotal));
		System.out.println("You have a total of\n" +
				"\t" + playerGrandTotal);
		System.out.println();
	}

	public static void printScores() {
		System.out.println("The score is: ");
		System.out.println("\tYou: " + playerGrandTotal);
		System.out.println("\tComputer: " + computerGrandTotal);
		System.out.println();
	}

	/**
	 * Validates roll of dice `dice`
	 * 
	 * @param dice object of type PairOfDice
	 * @return Integer.
	 *         Negative if two 1's, 0 if one 1 and positive if no 1's and the roll
	 *         is valid
	 */
	public static int validateRoll(PairOfDice dice) {
		if (dice.getDie1() == 1 && dice.getDie2() == 1) {
			return -1;
		} else if (dice.getDie1() == 1 || dice.getDie2() == 1) {
			return 0;
		} else {
			return 1;
		}
	}

	private static Scanner sc = new Scanner(System.in);

	public static char getChoiceFromPlayer(String prompt) {
		System.out.println(prompt);
		char choice = sc.nextLine().toLowerCase().charAt(0);
		System.out.println();
		return choice;
	}
}
