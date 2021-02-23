package MoveAroundBoard;

public class Piece {
	private int position;
	private String name;
	
	Piece(String nameSet, int pos){
		setName(nameSet);
		move(pos);
	}
	
	Piece(String nameSet){
		setName(nameSet);
	}
	
	public void move(int pos) {
		this.position = pos;
	}
	
	public void move(Square square) {
		this.position = square.getPos();
		System.out.println("Moving to Square: " + square.getSquareInfo() + " ...");
	}
	
	private void setName(String nameSet) {
		this.name = nameSet;
	}
	
	public int getPos(){
		return position;
	}
	
	public String getName() {
		return name;
	}
}
