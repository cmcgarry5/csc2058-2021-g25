package v1;
import java.util.Random;

public class Dice {
	
	private final int maxValue = 6;
	
	private int rollValue;
	
	
	public Dice() {
		
	}
	
	private int roll() {
		
		Random rand = new Random();
		
		int value = rand.nextInt(maxValue+1);
		return value;
	}
	

	public int getRollValue() {
		// TODO Auto-generated method stub
		int totalRoll = 0;
		
		int roll1 = roll();
		System.out.print("You rolled a " + roll1);
		int roll2 = roll();
		System.out.print(" and a " + roll2);
		
		totalRoll = roll1 + roll2;
		
		System.out.println(" = " + totalRoll + "\n");
		
		rollValue = totalRoll;
		
		return totalRoll;
		
	}
	
	
	
	

}
