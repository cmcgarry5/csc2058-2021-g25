package MoveAroundBoard;

public class Piece {
	private int position;
	private String name;
	
	Piece(String nameSet, int pos){
		setName(nameSet);
		move(pos);
	}
	
	Piece(){
		
	}
	
	void move(int pos) {
		this.position = pos;
	}
	
	void move(Square square) {
		this.position = square.getPos();
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
