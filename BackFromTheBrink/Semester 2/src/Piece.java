public class Piece {

	private String name;
	private int pos;

	private static int nextID = 1;
	private int id;

	private boolean taken;
	private boolean passedTravelSquare = false;


	public Piece(String name, int position) {
		this.name = name;
		this.pos = 10; //position;
		this.taken = false;
		this.id = getNextID();
	}
	
	public Piece(String name) {
		this.name = name;
		this.pos = 0;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public static int getNextID() {
		int id = nextID;
		nextID++;
		return id;

	}
	
	public Square move(int value) {
		int boardSize = BackFromTheBrink.board.size();
		int iter = 0;
		int newPos = 0;

		if (value > 0) {
			for (int pos = getPos(); iter < value + 1; pos++) {
				iter++;
				if (pos >= boardSize) {
					pos = 0;
					if(value - iter > 0) {
						passedTravelSquare = true;
					}
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

		//System.out.println("You have landed on " + Board.getSquare(pos).getName());


		return Board.getSquare(pos);
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

	public boolean getTaken(){
		return taken;
	}

	public int getID() {
		return id;
	}

	public void setTaken(boolean b) {
		this.taken = b;
	}

	public boolean hasPassedTravelSquare() {
		return passedTravelSquare;
	}

	public void setPassedTravelSquare(boolean bool) {
		passedTravelSquare = bool;
	}
}
