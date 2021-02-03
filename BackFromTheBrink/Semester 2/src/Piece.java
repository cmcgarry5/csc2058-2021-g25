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
		int boardSize = BackFromTheBrink.board.size();
		int iter = 0;
		int newPos = 0;

		if (value > 0) {
			for (int pos = getPos(); iter < value + 1; pos++) {
				iter++;
				if (pos >= boardSize) {
					pos = 0;
				}
				newPos = pos;
			}

			this.pos = newPos;
		}
		else{
			for (int pos = getPos(); iter < value - 1; pos--) {
				iter--;
				if (pos < 0) {
					pos = 0;
				}
				newPos = pos;
			}

			this.pos = newPos;
		}
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
