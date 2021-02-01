package v1;

public class Piece {
	
	public class Square{ // delete classs when classes brought together

		public int getPos() {
			// TODO Auto-generated method stub
			return 0;
		}} 

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
	
	
	
	
}
