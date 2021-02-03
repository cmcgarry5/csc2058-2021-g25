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
		Square brownBear = new Habitat("Brown Bear Habitat", 1, 60, 4, 20, 60, 180, 320, 450, 50);
		Square wildCard1 = new WildCardSquare("Wild Card 1", 2);
		Square jaguar = new Habitat("Jaguar Habitat", 3, 60, 2, 10, 30, 90, 160, 250, 50);
		Square conservationFee = new Special("Conservation Fee Utility", 4);
		Square zileRiver = new Special("Zile River", 5);
		Square whoopingCrane = new Habitat("Whooping Crane Habitat", 6, 100, 6, 30, 90, 270, 400, 550, 50);
		Square wildCard2 = new WildCardSquare("Wild Card 2", 7);
		Square greyParrot = new Habitat("Grey Parrot Habitat", 8, 100, 6, 30, 90, 270, 400, 550, 50);
		Square hawaiianDuck = new Habitat("Hawaiian Duck Habitat", 9, 120, 8, 40, 100, 300, 450, 600, 50);
		Square safari = new Special("Safari", 10);
		Square greatEgret = new Habitat("Great Egret Habitat", 11, 160, 12, 60, 180, 500, 700, 900, 100);
		Square electricity = new Special("Electricity Utility", 12);
		Square kingRail = new Habitat("King Rail Habitat", 13, 140, 10, 50, 150, 450, 675, 750, 100);
		Square pugnoseShiner = new Habitat("pugnose Shiner Habitat", 14, 140, 10, 50, 150, 450, 625, 750, 100);
		Square hatsuRiver = new Special("Hatsu River", 15);
		Square greyBat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100);
		Square wildCard3 = new WildCardSquare("Wild Card 3", 17);
		Square blindSalamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100);
		Square blindCaveEel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100);
		Square bftb = new Special("Back From The Brink Square", 20);
		Square amurLeopard = new Habitat("Amur Leopard Habitat", 21, 200, 18, 90, 250, 700, 875, 1050, 150);
		Square wildCard4 = new WildCardSquare("Wild Card 4", 22);
		Square blackRhino = new Habitat("Black Rhino Habitat", 23, 220, 18, 90, 250, 700, 875, 1050, 150);
		Square sundaTiger = new Habitat("Sunda Tiger Habitat", 24, 240, 20, 100, 300, 750, 925, 1100, 150);
		Square trinityRiver = new Special("Trinity River", 25);
		Square polarBear = new Habitat("Polar Bear Habitat", 26, 260, 22, 110, 330, 800, 975, 1150, 150);
		Square arcticFox = new Habitat("Arctic Fox Habitat", 27, 260, 22, 110, 330, 800, 975, 1150, 150);
		Square water = new Special("Get Water", 28);
		Square arcticWolf = new Habitat("Arctic Wolf Habitat", 29, 280, 24, 120, 360, 850, 1025, 1200, 150);
		Square spottedByPredator = new Special("Spotted By Predator", 30);
		Square crossRiverGorilla = new Habitat("Cross River Gorilla Habitat", 31, 300, 26, 130, 390, 900, 1100, 1275, 200);
		Square orangutan = new Habitat("Orangutan Habitat", 32, 300, 26, 130, 390, 900, 1100, 1275, 200);
		Square wildCard5 = new WildCardSquare("Wild Card 5", 33);
		Square asianElephant = new Habitat("Asian Elephant Habitat", 34, 320, 28, 150, 450, 1000, 1200, 1400, 200);
		Square dukeRiver = new Special("Duke River", 35);
		Square wildCard6 = new Special("Wild Card 6", 36);
		Square blueWhale = new Habitat("Blue Whale Habitat", 37, 400, 50, 200, 600, 1400, 1700, 2000, 200);
		Square seaTurtle = new Habitat("Sea Turtle Habitat", 38, 350, 35, 175, 500, 1100, 1300, 1500, 200);

		ArrayList<Square> board = new ArrayList<>();

		board.add(travel);
		board.add(brownBear);
		board.add(wildCard1);
		board.add(jaguar);
		board.add(conservationFee);
		board.add(zileRiver);
		board.add(whoopingCrane);
		board.add(wildCard2);
		board.add(greyParrot);
		board.add(hawaiianDuck);
		board.add(safari);
		board.add(greatEgret);
		board.add(electricity);
		board.add(kingRail);
		board.add(pugnoseShiner);
		board.add(hatsuRiver);
		board.add(greyBat);
		board.add(wildCard3);
		board.add(blindSalamander);
		board.add(blindCaveEel);
		board.add(bftb);
		board.add(amurLeopard);
		board.add(wildCard4);
		board.add(blackRhino);
		board.add(sundaTiger);
		board.add(trinityRiver);
		board.add(polarBear);
		board.add(arcticFox);
		board.add(water);
		board.add(arcticWolf);
		board.add(spottedByPredator);
		board.add(crossRiverGorilla);
		board.add(orangutan);
		board.add(wildCard5);
		board.add(asianElephant);
		board.add(dukeRiver);
		board.add(wildCard6);
		board.add(blueWhale);
		board.add(seaTurtle);

		return board;
	}
}
