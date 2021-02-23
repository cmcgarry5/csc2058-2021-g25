package MoveAroundBoard;

public class Dice {
	private int rollValue;
	
	Dice(){
		this.rollValue = 0;
	}
	
	public void roll() {
		this.rollValue = (int) (1 + Math.random() * ((6-1)+1));
	}
	
	public double getRoll() {
		return rollValue;
	}
	
}
