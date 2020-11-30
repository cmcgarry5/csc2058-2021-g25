package MoveAroundBoard;

public class Player {
	
	private String name;
	private Piece piece;
	
	Player(String nameSet){
		setName(nameSet);
	}

	private void setName(String nameSet) {
		this.name = nameSet;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public String getName() {
		return name;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	
}
