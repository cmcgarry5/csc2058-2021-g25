import java.util.Random;

public class Dice {
	
	private final int MAX_VALUE = 6;
	
	private int rollValue;
	private boolean isDouble;
	private boolean isSecondDouble;
	
	
	/*public Dice() { // does this class need a constructor - should we do the thing we did in SDP for only allowing one instance? Singleton Pattern?
		
	}*/
	
	private int roll() {
		
		Random rand = new Random();
		
		int value = rand.nextInt(MAX_VALUE+1);
		return value;
	}

	public void nextPlayer(){
		isDouble = false;
		isSecondDouble = false;
	}
	

	public int getRollValue() {

		int totalRoll = 0;
		
		int roll1 = roll();
		System.out.print("You rolled a " + roll1);
		int roll2 = roll();
		System.out.print(" and a " + roll2);
		
		totalRoll = roll1 + roll2;

		if(roll1 == roll2){
			if(isDouble == true){
				isSecondDouble = true;
			}
			else{
				isDouble = true;
			}
		}
		
		System.out.println(" = " + totalRoll + "\n");
		
		rollValue = totalRoll;
		
		return totalRoll;
		
	}

	public boolean getIsDouble(){
		return isDouble;
	}

	public boolean getIsSecondDouble(){
		return isSecondDouble;

	}
}
