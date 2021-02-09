import java.util.ArrayList;

public class Board {

	ArrayList<Square> Squares = new ArrayList<Square>();
	ArrayList<WildCard> wildCards = new ArrayList<WildCard>();
	static ArrayList<Piece> pieces = new ArrayList<Piece>();
	ArrayList<Biome> biomes = new ArrayList<Biome>();



	/*
	 * Adds square to the arraylist
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

	public WildCard draw(){
		WildCard wildCardDrawn = wildCards.get(wildCards.size()-1);
		wildCards.remove(wildCards.size()-1);
		wildCards.add(0, wildCardDrawn);
		return wildCardDrawn;
	}

	/*
	 * Returns wildcard to wildcard deck
	 */
	public void returnCard(WildCard wildcard) {
		//WildCard.restoreCard(wildcard); //error

	}

	public Board setupBoard() {

		Biome cave = new Biome("Cave Biome", 3, null);
		Biome wetlands = new Biome("Wetlands Biome", 3, null);
		Biome sky = new Biome("Sky Biome", 3, null);
		Biome forest = new Biome("Forest Biome", 2, null);
		Biome marine = new Biome("Marine Biome", 2, null);
		Biome jungle = new Biome("Jungle Biome", 3, null);
		Biome snow = new Biome("Snow Biome", 3, null);
		Biome exotic = new Biome("Exotic Biome", 3, null);

		this.addSquare(new Travel("Travel Square", 0));

		Habitat brownBear = new Habitat("Brown Bear Habitat", 1, 60, 4, 20, 60, 180, 320, 450, 50,forest);
		this.addSquare(brownBear);
		forest.addAnimalHabitat(brownBear);

		this.addSquare(new WildCardSquare("Wild Card 1", 2));

		Habitat jaguar =  new Habitat("Jaguar Habitat", 3, 60, 2, 10, 30, 90, 160, 250, 50,forest);
		this.addSquare(jaguar);
		forest.addAnimalHabitat(jaguar);

		this.addSquare(new Special("Conservation Fee Utility", 4));
		this.addSquare(new Special("Zile River", 5));

		Habitat crane = new Habitat("Whooping Crane Habitat", 6, 100, 6, 30, 90, 270, 400, 550, 50,sky);
		this.addSquare(crane);
		sky.addAnimalHabitat(crane);

		this.addSquare(new WildCardSquare("Wild Card 2", 7));

		Habitat parrot = new Habitat("Grey Parrot Habitat", 8, 100, 6, 30, 90, 270, 400, 550, 50,sky);
		this.addSquare(parrot);
		sky.addAnimalHabitat(parrot);

		Habitat duck =new Habitat("Hawaiian Duck Habitat", 9, 120, 8, 40, 100, 300, 450, 600, 50, sky);
		this.addSquare(duck);
		sky.addAnimalHabitat(duck);

		this.addSquare(new Special("Safari", 10));

		Habitat egret = new Habitat("Great Egret Habitat", 11, 160, 12, 60, 180, 500, 700, 900, 100,wetlands);
		this.addSquare(egret);
		wetlands.addAnimalHabitat(egret);

		this.addSquare(new Special("Electricity Utility", 12));

		Habitat rail = new Habitat("King Rail Habitat", 13, 140, 10, 50, 150, 450, 675, 750, 100,wetlands);
		this.addSquare(rail);
		wetlands.addAnimalHabitat(rail);

		Habitat shiner = new Habitat("Pugnose Shiner Habitat", 14, 140, 10, 50, 150, 450, 625, 750, 100,wetlands);
		this.addSquare(shiner);
		wetlands.addAnimalHabitat(shiner);

		this.addSquare(new Special("Hatsu River", 15));

		Habitat bat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100,cave);
		this.addSquare(bat);
		cave.addAnimalHabitat(bat);

		this.addSquare(new WildCardSquare("Wild Card 3", 17));

		Habitat salamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100,cave);
		this.addSquare(salamander);
		cave.addAnimalHabitat(salamander);

		Habitat eel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100,cave);
		this.addSquare(eel);
		cave.addAnimalHabitat(eel);

		this.addSquare(new Special("Back From The Brink Square", 20));

		Habitat leopard = new Habitat("Amur Leopard Habitat", 21, 200, 18, 90, 250, 700, 875, 1050, 150,exotic);
		this.addSquare(leopard);
		exotic.addAnimalHabitat(leopard);

		this.addSquare(new WildCardSquare("Wild Card 4", 22));

		Habitat rhino = new Habitat("Black Rhino Habitat", 23, 220, 18, 90, 250, 700, 875, 1050, 150,exotic);
		this.addSquare(rhino);
		exotic.addAnimalHabitat(rhino);

		Habitat tiger = new Habitat("Sunda Tiger Habitat", 24, 240, 20, 100, 300, 750, 925, 1100, 150,exotic);
		this.addSquare(tiger);
		exotic.addAnimalHabitat(tiger);

		this.addSquare(new Special("Trinity River", 25));

		Habitat bear = new Habitat("Polar Bear Habitat", 26, 260, 22, 110, 330, 800, 975, 1150, 150,snow);
		this.addSquare(bear);
		snow.addAnimalHabitat(bear);

		Habitat fox = new Habitat("Arctic Fox Habitat", 27, 260, 22, 110, 330, 800, 975, 1150, 150,snow);
		this.addSquare(fox);
		snow.addAnimalHabitat(fox);

		this.addSquare(new Special("Get Water", 28));

		Habitat wolf = new Habitat("Arctic Wolf Habitat", 29, 280, 24, 120, 360, 850, 1025, 1200, 150,snow);
		this.addSquare(wolf);
		snow.addAnimalHabitat(wolf);

		this.addSquare(new Special("Spotted By Predator", 30));

		Habitat gorilla = new Habitat("Cross River Gorilla Habitat", 31, 300, 26, 130, 390, 900, 1100, 1275, 200,jungle);
		this.addSquare(gorilla);
		jungle.addAnimalHabitat(gorilla);

		Habitat orangutan = new Habitat("Orangutan Habitat", 32, 300, 26, 130, 390, 900, 1100, 1275, 200,jungle);
		this.addSquare(orangutan);
		jungle.addAnimalHabitat(orangutan);

		this.addSquare(new WildCardSquare("Wild Card 5", 33));

		Habitat elephant = new Habitat("Asian Elephant Habitat", 34, 320, 28, 150, 450, 1000, 1200, 1400, 200,jungle);
		this.addSquare(elephant);
		jungle.addAnimalHabitat(elephant);

		this.addSquare(new Special("Duke River", 35));
		this.addSquare(new Special("Wild Card 6", 36));

		Habitat whale = new Habitat("Blue Whale Habitat", 37, 400, 50, 200, 600, 1400, 1700, 2000, 200,marine);
		this.addSquare(whale);
		marine.addAnimalHabitat(whale);

		this.addSquare(new Special("Brink Hotel",38));

		Habitat turtle = new Habitat("Sea Turtle Habitat", 39, 350, 35, 175, 500, 1100, 1300, 1500, 200,marine);
		this.addSquare(turtle);
		marine.addAnimalHabitat(turtle);


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


		biomes.add(cave);
		biomes.add(wetlands);
		biomes.add(sky);
		biomes.add(forest);
		biomes.add(marine);
		biomes.add(jungle);
		biomes.add(snow);
		biomes.add(exotic);


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
