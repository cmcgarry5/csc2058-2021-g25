import java.util.ArrayList;

public class Board {

	ArrayList<Square> Squares = new ArrayList<Square>();
	ArrayList<WildCard> wildCards = new ArrayList<WildCard>();


	/*
	 * Adds sqare to the arraylist
	 */
	public void addSquare(Square square) {
		Squares.add(square);
	}

	/*
	 * Return name of selected Square
	 */
	public Square getSquare(int index) {

		return getSquare(index);
	}

	/*
	 * Return name of all Squares
	 */
	public void allSquare() {
		System.out.println("All Squares: \n");
		for (int index = 0; index < Square.getNextPos(); index++) {
			Square info = Squares.get(index);
			System.out.println("Info : " + info);
		}

	}

	/*
	 * Returns size of Squares arraylist
	 */
	public int size() {
		int squareSize = Squares.size();
		return squareSize;
	}

	/*
	 * Adds WildCard to wildCards arraylist
	 */
	public void addWildCard(WildCard wildcard) {
		wildCards.add(wildcard);
	}

	/*
	 * Gets card from Wildcard class then displays it to player
	 */
	public void draw(WildCard wildcard, Player player) {
		String name = WildCard.getCard();
		
	}

	/*
	 * Returns wildcard to wildcard deck
	 */
	public void returnCard(WildCard wildcard) {
		WildCard.restoreCard(wildcard);

	}

	public ArrayList<Square> setupBoard() {
		Square travel = new Travel("Travel Square", 0);
		Square brownBear = new Habitat("Brown Bear Square", 1, 60, 4, 20, 60, 180, 320, 450, 50);
		Square wildCard1 = new WildCardSquare("Wild Card 1", 2);
		Square jaguar = new Habitat("Jaguar Square", 3, 60, 2, 10, 30, 90, 160, 250, 50);
		Square conservationFee = new Special("Conservation Fee Square", 4);
	}
}
