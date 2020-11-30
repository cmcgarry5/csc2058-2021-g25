package MoveAroundBoard;

public class Dice {
	private double numRoll;
	
	Dice(){
		this.numRoll = 0;
	}
	
	public void roll() {
		this.numRoll = 1 + Math.random() * ((6-1)+1);
	}
	
	public double getRoll() {
		return numRoll;
	}
	
}
