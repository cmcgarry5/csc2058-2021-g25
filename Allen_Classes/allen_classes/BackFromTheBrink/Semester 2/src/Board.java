import java.util.ArrayList;

public class Board {

	ArrayList<Square> Squares = new ArrayList<Square>();
	ArrayList<WildCard> wildCards = new ArrayList<WildCard>();
	static ArrayList<Piece> pieces = new ArrayList<Piece>();



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

		return Squares.get(index);
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
		//String name = WildCard.getCard(); //error
		
	}

	/*
	 * Returns wildcard to wildcard deck
	 */
	public void returnCard(WildCard wildcard) {
		//WildCard.restoreCard(wildcard); //error

	}

	public Board setupBoard() {

		this.addSquare(new Travel("Travel Square", 0));
		this.addSquare(new Habitat("Brown Bear Habitat", 1, 60, 4, 20, 60, 180, 320, 450, 50));
		this.addSquare(new WildCardSquare("Wild Card 1", 2));
		this.addSquare(new Habitat("Jaguar Habitat", 3, 60, 2, 10, 30, 90, 160, 250, 50));
		this.addSquare(new Special("Conservation Fee Utility", 4));
		this.addSquare(new Special("Zile River", 5));
		this.addSquare(new Habitat("Whooping Crane Habitat", 6, 100, 6, 30, 90, 270, 400, 550, 50));
		this.addSquare(new WildCardSquare("Wild Card 2", 7));
		this.addSquare(new Habitat("Grey Parrot Habitat", 8, 100, 6, 30, 90, 270, 400, 550, 50));
		this.addSquare(new Habitat("Hawaiian Duck Habitat", 9, 120, 8, 40, 100, 300, 450, 600, 50));
		this.addSquare(new Special("Safari", 10));
		this.addSquare(new Habitat("Great Egret Habitat", 11, 160, 12, 60, 180, 500, 700, 900, 100));
		this.addSquare(new Special("Electricity Utility", 12));
		this.addSquare(new Habitat("King Rail Habitat", 13, 140, 10, 50, 150, 450, 675, 750, 100));
		this.addSquare(new Habitat("pugnose Shiner Habitat", 14, 140, 10, 50, 150, 450, 625, 750, 100));
		this.addSquare(new Special("Hatsu River", 15));
		this.addSquare(new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100));
		this.addSquare(new WildCardSquare("Wild Card 3", 17));
		this.addSquare(new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100));
		this.addSquare(new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100));
		this.addSquare(new Special("Back From The Brink Square", 20));
		this.addSquare(new Habitat("Amur Leopard Habitat", 21, 200, 18, 90, 250, 700, 875, 1050, 150));
		this.addSquare(new WildCardSquare("Wild Card 4", 22));
		this.addSquare(new Habitat("Black Rhino Habitat", 23, 220, 18, 90, 250, 700, 875, 1050, 150));
		this.addSquare(new Habitat("Sunda Tiger Habitat", 24, 240, 20, 100, 300, 750, 925, 1100, 150));
		this.addSquare(new Special("Trinity River", 25));
		this.addSquare(new Habitat("Polar Bear Habitat", 26, 260, 22, 110, 330, 800, 975, 1150, 150));
		this.addSquare(new Habitat("Arctic Fox Habitat", 27, 260, 22, 110, 330, 800, 975, 1150, 150));
		this.addSquare(new Special("Get Water", 28));
		this.addSquare(new Habitat("Arctic Wolf Habitat", 29, 280, 24, 120, 360, 850, 1025, 1200, 150));
		this.addSquare(new Special("Spotted By Predator", 30));
		this.addSquare(new Habitat("Cross River Gorilla Habitat", 31, 300, 26, 130, 390, 900, 1100, 1275, 200));
		this.addSquare(new Habitat("Orangutan Habitat", 32, 300, 26, 130, 390, 900, 1100, 1275, 200));
		this.addSquare(new WildCardSquare("Wild Card 5", 33));
		this.addSquare(new Habitat("Asian Elephant Habitat", 34, 320, 28, 150, 450, 1000, 1200, 1400, 200));
		this.addSquare(new Special("Duke River", 35));
		this.addSquare(new Special("Wild Card 6", 36));
		this.addSquare(new Habitat("Blue Whale Habitat", 37, 400, 50, 200, 600, 1400, 1700, 2000, 200));
		this.addSquare(new Habitat("Sea Turtle Habitat", 38, 350, 35, 175, 500, 1100, 1300, 1500, 200));


		this.addWildCard(new moveWildCard("Advance to Jaguar", true, false, BackFromTheBrink.board.getSquare(3)));
		this.addWildCard(new moveWildCard("Advance to Blue Whale", true, false, BackFromTheBrink.board.getSquare(37)));
		this.addWildCard(new moveWildCard("Advance to the Nearest River", true, true,null));
		this.addWildCard(new moveWildCard("Advance to Travel Square", true, false, BackFromTheBrink.board.getSquare(0)));
		this.addWildCard(new moveWildCard("Go Back 3 Squares", false, false, null));
		this.addWildCard(new moveWildCard("Caught by Predator, advance to Hiding in Safari", true, false, BackFromTheBrink.board.getSquare(10)));
		this.addWildCard(new EscapeCard("Escape Safari Card"));
		this.addWildCard(new receiveMatWildCard("Received a Grant", false, false, 200));
		this.addWildCard(new payUpWildCard("Assessed for Maintenance", true, 0));
		this.addWildCard(new receiveMatWildCard("Successful Breeding", true, false, 0));
		this.addWildCard(new payUpWildCard("Elected As Chairman", false, 50));
		this.addWildCard(new payUpWildCard("Food Bills", false, 100));
		this.addWildCard(new receiveMatWildCard("Conservation Fee Refund", false, false, 200));
		this.addWildCard(new receiveMatWildCard("Conservation Scheme", false, true, 0));

		this.pieces.add(new Piece("Sir David Attenborough",0));
		this.pieces.add(new Piece("Steve Irwin",0));
		this.pieces.add(new Piece("Greta Thunberg",0));
		this.pieces.add(new Piece("Steve Backshall",0));
		this.pieces.add(new Piece("Jane Goodall",0));
		this.pieces.add(new Piece("John Muir",0));
		this.pieces.add(new Piece("Theodore Roosevelt",0));
		this.pieces.add(new Piece("Theodore Roosevelt v2",0));




		return this;
	}
}