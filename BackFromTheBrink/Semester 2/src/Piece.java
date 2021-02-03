public class Piece {

	private String name;
	private int pos;
	
	public Piece(String name, int position) { // do we need this constructor
		this.name = name;
		this.pos = position;
		
	}
	
	public Piece(String name) {
		this.name = name;
		this.pos = 0;
	}
	
	public void move(int value) {

		pos+= value;
	}
	
	public void move(Square square) {
		int pos = square.getPos();
		this.pos = pos;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public int getPos(){
		return this.pos;
	}

}
