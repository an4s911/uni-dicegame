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

		char choice = getChoiceFromPlayer();

		while (choice == 'y') {
			choice = emulatePlayerTurn();
		}
	}

	public static char emulatePlayerTurn() {
		while (true) {
			System.out.println("You're rolling the dice...");
			playerDice.roll();
			System.out.println("You rolled " + playerDice.toString());

			int validation = validateRoll(playerDice);

			if (validation > 0) {
				playerTurnTotal += playerDice.getDiceSum();
				printPlayerScores();
			} else if (validation == 0) {
				System.out.println("You got a 1!");
				playerTurnTotal = 0;
			} else {
				System.out.println("You got two 1's!");
				playerTurnTotal = 0;
				playerGrandTotal = 0;
			}

			if (validation <= 0) {
				System.out.println("Continue? (Type 'y' when you're ready to turn the dice over to me)");
				break;
			}

			if (checkPlayerWin()) {
				System.out.println("YOU GOT MORE THAN 100.\nYOU WIN!!!");
				return 'n'; // will return 'n' for NO. So the game ends
			}

			System.out.println("Do you want to continue rolling? (Type 'y' or 'n')");
			char choice = getChoiceFromPlayer();

			if (choice != 'y') {
				break;
			}
		}

		playerGrandTotal += playerTurnTotal;
		playerTurnTotal = 0;
		char choice = getChoiceFromPlayer();
		return choice;
	}

	public static void emulateComputerTurn() {

	}

	public static boolean checkPlayerWin() {
		if ((playerGrandTotal + playerTurnTotal) >= 100) {
			return true;
		}
		return false;
	}

	public static boolean checkComputerWin() {
		return false;
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

	public static void printPlayerScores() {
		System.out.println("This gives you a turn total of\n" +
				"\t" + playerTurnTotal);
		System.out.println("and a grand total of\n" +
				"\t" + (playerGrandTotal + playerTurnTotal));
		System.out.println("The computer has a total of\n" +
				"\t" + computerGrandTotal);
	}

	public static void printComputerScores() {
		System.out.println("This gives me a turn total of\n" +
				"\t" + computerTurnTotal);
		System.out.println("and a grand total of\n" +
				"\t" + (computerGrandTotal + computerTurnTotal));
		System.out.println("You have a total of\n" +
				"\t" + playerGrandTotal);
	}

	private static Scanner sc = new Scanner(System.in);

	public static char getChoiceFromPlayer() {
		char choice = sc.nextLine().toLowerCase().charAt(0);
		return choice;
	}
}
