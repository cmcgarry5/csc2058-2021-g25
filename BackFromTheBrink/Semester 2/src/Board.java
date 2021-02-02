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

}
