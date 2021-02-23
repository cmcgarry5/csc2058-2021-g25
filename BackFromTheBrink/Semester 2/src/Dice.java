import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Dice {
	private final int MAX_VALUE = 6;
	private int rollValue;
	private boolean isDouble;
	private boolean isSecondDouble;

	public Dice() { // does this class need a constructor - should we do the thing we did in SDP for only allowing one instance? Singleton Pattern?
		this.isDouble = false;
		this.isSecondDouble = false;
	}

	private int roll() {
		Random rand = new Random();
		int value = 1 + rand.nextInt(MAX_VALUE);
		return value;
	}

	public void nextPlayer() {
		isDouble = false;
		isSecondDouble = false;
	}

	public int getRollValue() {

		if(getIsDouble() && BackFromTheBrink.begun == true){
			System.out.println("You rolled a double in your previous roll!");
		}

		int totalRoll = 0;

		Scanner sc = new Scanner(System.in);

		String input;
		do{
			System.out.println("Roll the dice by entering 'r' :");

			input = sc.nextLine();
			input = input.trim();

			if(input.equalsIgnoreCase("r")){
				break;
			}
			else{
				System.out.println("Invalid input, please try again");
				continue;
			}
		}
		while(true);

		int roll1 = roll();
		System.out.print("You rolled a " + roll1);
		int roll2 = roll();
		System.out.print(" and a " + roll2);

		totalRoll = roll1 + roll2;

		if (roll1 == roll2) {
			if (isDouble == true) {
				isSecondDouble = true;
			} else {
				isDouble = true;
			}
		}

		System.out.println(" = " + totalRoll + "\n");

		rollValue = totalRoll;

		return totalRoll;

	}

	public boolean getIsDouble() {
		return isDouble;
	}

	public boolean getIsSecondDouble() {
		return isSecondDouble;

	}

	public void tryDouble(Player player) {
		nextPlayer();
		int rollValue = this.getRollValue();
			if(this.isDouble) {
				System.out.println("You rolled a double! You luckily escaped from the predator and escaped! \n");
				player.getPiece().move(rollValue);
				player.setInSafari(false);
				nextPlayer();
			}
			else {
				System.out.println("Unlucky, " + player.getName() + ", the predator is still lurking nearby...\n");
				nextPlayer();
				}
			}

}
