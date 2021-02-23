import java.util.ArrayList;

public class Board {

	static ArrayList<Square> Squares = new ArrayList<Square>();
	static ArrayList<WildCard> wildCards = new ArrayList<WildCard>();
	static ArrayList<Piece> pieces = new ArrayList<Piece>();
	static ArrayList<Biome> biomes = new ArrayList<Biome>();



	/*
	 * Adds square to the arraylist
	 */
	public static void addSquare(Square square) {
		Squares.add(square);
	}

	/*
	 * Return name of selected Square
	 */
	public static Square getSquare(int index) {

		return Squares.get(index);
	}

	/*
	 * Return name of all Squares
	 */
	public static void allSquare() {
		System.out.println("All Squares: \n");
		for (int index = 0; index < Square.getNextPos(); index++) {
			Square info = Squares.get(index);
			System.out.println("Info : " + info);
		}
	}

	/*
	 * Returns size of Squares arraylist
	 */
	public static int size() {
		int squareSize = Squares.size();
		return squareSize;
	}

	/*
	 * Adds WildCard to wildCards arraylist
	 */
	public static void addWildCard(WildCard wildcard) {
		wildCards.add(wildcard);
	}

	/*
	 * Gets card from Wildcard array 
	 */
	public static WildCard draw(){
		WildCard wildCardDrawn = wildCards.get(wildCards.size()-1);
		wildCards.remove(wildCards.size()-1);
		wildCards.add(0, wildCardDrawn);
		return wildCardDrawn;
	}

	public static void addAnimalHabitat(Habitat habitat){
		Biome biome = habitat.getBiome();

		for(int i = 0; i<biomes.size(); i++){
			if(biomes.get(i).getName().equals(biome.getName())){
				biomes.get(i).addAnimalHabitat(habitat);
				return;
			}
		}
	}

	public static Habitat removeAnimalHabitat(Habitat habitat){
		Habitat hab = null;
		Biome biome = habitat.getBiome();

		for(int i = 0; i<biomes.size(); i++){
			if(biomes.get(i).getName().equals(biome.getName())){
				hab = biomes.get(i).removeHabitat(habitat);
			}
			else{
				return hab;
			}
		}
		return hab;
	}

	public static void setupBoard() {

		Biome cave = new Biome("Cave Biome", 3);
		Biome wetlands = new Biome("Wetlands Biome", 3);
		Biome sky = new Biome("Sky Biome", 3);
		Biome forest = new Biome("Forest Biome", 2);
		Biome marine = new Biome("Marine Biome", 2);
		Biome jungle = new Biome("Jungle Biome", 3);
		Biome snow = new Biome("Snow Biome", 3);
		Biome exotic = new Biome("Exotic Biome", 3);

		addSquare(new Travel("Travel Square", 0));

		Habitat brownBear = new Habitat("Brown Bear Habitat", 1, 60, 4, 20, 60, 180, 320, 450, 50,forest);
		addSquare(brownBear);
		forest.addAnimalHabitat(brownBear);

		addSquare(new WildCardSquare("Wild Card 1", 2));

		Habitat jaguar =  new Habitat("Jaguar Habitat", 3, 60, 2, 10, 30, 90, 160, 250, 50,forest);
		addSquare(jaguar);
		forest.addAnimalHabitat(jaguar);

		addSquare(new Special("Conservation Fee Utility", 4, 200));
		addSquare(new RiverSquare("Zile River", 5));

		Habitat crane = new Habitat("Whooping Crane Habitat", 6, 100, 6, 30, 90, 270, 400, 550, 50,sky);
		addSquare(crane);
		sky.addAnimalHabitat(crane);

		addSquare(new WildCardSquare("Wild Card 2", 7));

		Habitat parrot = new Habitat("Grey Parrot Habitat", 8, 100, 6, 30, 90, 270, 400, 550, 50,sky);
		addSquare(parrot);
		sky.addAnimalHabitat(parrot);

		Habitat duck =new Habitat("Hawaiian Duck Habitat", 9, 120, 8, 40, 100, 300, 450, 600, 50, sky);
		addSquare(duck);
		sky.addAnimalHabitat(duck);

		addSquare(new SafariSquare("Safari", 10));

		Habitat egret = new Habitat("Great Egret Habitat", 11, 160, 12, 60, 180, 500, 700, 900, 100,wetlands);
		addSquare(egret);
		wetlands.addAnimalHabitat(egret);

		addSquare(new Special("Electricity Utility", 12, 150));

		Habitat rail = new Habitat("King Rail Habitat", 13, 140, 10, 50, 150, 450, 675, 750, 100,wetlands);
		addSquare(rail);
		wetlands.addAnimalHabitat(rail);

		Habitat shiner = new Habitat("Pugnose Shiner Habitat", 14, 140, 10, 50, 150, 450, 625, 750, 100,wetlands);
		addSquare(shiner);
		wetlands.addAnimalHabitat(shiner);

		addSquare(new RiverSquare("Hatsu River", 15));

		Habitat bat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100,cave);
		addSquare(bat);
		cave.addAnimalHabitat(bat);

		addSquare(new WildCardSquare("Wild Card 3", 17));

		Habitat salamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100,cave);
		addSquare(salamander);
		cave.addAnimalHabitat(salamander);

		Habitat eel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100,cave);
		addSquare(eel);
		cave.addAnimalHabitat(eel);

		addSquare(new BackFromTheBrinkSquare("Back From The Brink Square", 20, 1000));

		Habitat leopard = new Habitat("Amur Leopard Habitat", 21, 200, 18, 90, 250, 700, 875, 1050, 150,exotic);
		addSquare(leopard);
		exotic.addAnimalHabitat(leopard);

		addSquare(new WildCardSquare("Wild Card 4", 22));

		Habitat rhino = new Habitat("Black Rhino Habitat", 23, 220, 18, 90, 250, 700, 875, 1050, 150,exotic);
		addSquare(rhino);
		exotic.addAnimalHabitat(rhino);

		Habitat tiger = new Habitat("Sunda Tiger Habitat", 24, 240, 20, 100, 300, 750, 925, 1100, 150,exotic);
		addSquare(tiger);
		exotic.addAnimalHabitat(tiger);

		addSquare(new RiverSquare("Trinity River", 25));

		Habitat bear = new Habitat("Polar Bear Habitat", 26, 260, 22, 110, 330, 800, 975, 1150, 150,snow);
		addSquare(bear);
		snow.addAnimalHabitat(bear);

		Habitat fox = new Habitat("Arctic Fox Habitat", 27, 260, 22, 110, 330, 800, 975, 1150, 150,snow);
		addSquare(fox);
		snow.addAnimalHabitat(fox);

		addSquare(new Special("Get Water", 28, 150));

		Habitat wolf = new Habitat("Arctic Wolf Habitat", 29, 280, 24, 120, 360, 850, 1025, 1200, 150,snow);
		addSquare(wolf);
		snow.addAnimalHabitat(wolf);

		addSquare(new Special("Spotted By Predator", 30, 0));

		Habitat gorilla = new Habitat("Cross River Gorilla Habitat", 31, 300, 26, 130, 390, 900, 1100, 1275, 200,jungle);
		addSquare(gorilla);
		jungle.addAnimalHabitat(gorilla);

		Habitat orangutan = new Habitat("Orangutan Habitat", 32, 300, 26, 130, 390, 900, 1100, 1275, 200,jungle);
		addSquare(orangutan);
		jungle.addAnimalHabitat(orangutan);

		addSquare(new WildCardSquare("Wild Card 5", 33));

		Habitat elephant = new Habitat("Asian Elephant Habitat", 34, 320, 28, 150, 450, 1000, 1200, 1400, 200,jungle);
		addSquare(elephant);
		jungle.addAnimalHabitat(elephant);

		addSquare(new RiverSquare("Duke River", 35));
		addSquare(new WildCardSquare("Wild Card 6", 36));

		Habitat whale = new Habitat("Blue Whale Habitat", 37, 400, 50, 200, 600, 1400, 1700, 2000, 200,marine);
		addSquare(whale);
		marine.addAnimalHabitat(whale);

		addSquare(new Special("Brink Hotel",38, 150));

		Habitat turtle = new Habitat("Sea Turtle Habitat", 39, 350, 35, 175, 500, 1100, 1300, 1500, 200,marine);
		addSquare(turtle);
		marine.addAnimalHabitat(turtle);


		addWildCard(new moveWildCard("Advance to Jaguar", true, false, BackFromTheBrink.board.getSquare(3)));
		addWildCard(new moveWildCard("Advance to Blue Whale", true, false, BackFromTheBrink.board.getSquare(37)));
		addWildCard(new moveWildCard("Advance to the Nearest River", true, true,null));
		addWildCard(new moveWildCard("Advance to Travel Square", true, false, BackFromTheBrink.board.getSquare(0)));
		addWildCard(new moveWildCard("Go Back 3 Squares", false, false, null));
		addWildCard(new moveWildCard("Caught by Predator, advance to Hiding in Safari", true, false, BackFromTheBrink.board.getSquare(10)));
		addWildCard(new EscapeCard("Escape Safari Card"));
		addWildCard(new receiveMatWildCard("Received a Grant", false, false, 200));
		addWildCard(new payUpWildCard("Assessed for Maintenance", true, 0));
		addWildCard(new receiveMatWildCard("Successful Breeding", true, false, 0));
		addWildCard(new payUpWildCard("Elected As Chairman", false, 50));
		addWildCard(new payUpWildCard("Food Bills", false, 100));
		addWildCard(new receiveMatWildCard("Conservation Fee Refund", false, false, 200));
		addWildCard(new receiveMatWildCard("Conservation Scheme", false, true, 0));


		biomes.add(cave);
		biomes.add(wetlands);
		biomes.add(sky);
		biomes.add(forest);
		biomes.add(marine);
		biomes.add(jungle);
		biomes.add(snow);
		biomes.add(exotic);


		pieces.add(new Piece("Sir David Attenborough",0));
		pieces.add(new Piece("Steve Irwin",0));
		pieces.add(new Piece("Greta Thunberg",0));
		pieces.add(new Piece("Steve Backshall",0));
		pieces.add(new Piece("Jane Goodall",0));
		pieces.add(new Piece("John Muir",0));
		pieces.add(new Piece("Theodore Roosevelt",0));
		pieces.add(new Piece("Theodore Roosevelt v2",0));
	}
}
