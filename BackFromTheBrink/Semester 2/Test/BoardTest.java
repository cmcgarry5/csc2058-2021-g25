import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {

   static Square newSquare;
   static WildCard newWildCard;
   static WildCard newWildCard2;

//    Biome cave = new Biome("Cave Biome", 3);
//    Biome wetlands = new Biome("Wetlands Biome", 3);
//    Biome sky = new Biome("Sky Biome", 3);
//    Biome forest = new Biome("Forest Biome", 2);
//    Biome marine = new Biome("Marine Biome", 2);
//    Biome jungle = new Biome("Jungle Biome", 3);
//    Biome snow = new Biome("Snow Biome", 3);
//    Biome exotic = new Biome("Exotic Biome", 3);
//
//    Square travel = new Travel("Travel Square", 0);
//    Habitat brownBear = new Habitat("Brown Bear Habitat", 1, 60, 4, 20, 60, 180, 320, 450, 50,forest,1);
//    Square wildCard1 = new WildCardSquare("Wild Card", 2);
//    Habitat jaguar =  new Habitat("Jaguar Habitat", 3, 60, 2, 10, 30, 90, 160, 250, 50,forest,2);
//    Square conservation = new Special("Conservation Fee", 4, 200);
//    Square zile = new RiverSquare("Zile River", 5);
//    Habitat crane = new Habitat("Whooping Crane Habitat", 6, 100, 6, 30, 90, 270, 400, 550, 50,sky,1);
//    Square wildCard2 = new WildCardSquare("Wild Card", 7);
//    Habitat parrot = new Habitat("Grey Parrot Habitat", 8, 100, 6, 30, 90, 270, 400, 550, 50,sky,2);
//    Habitat duck =new Habitat("Hawaiian Duck Habitat", 9, 120, 8, 40, 100, 300, 450, 600, 50, sky,3);
//    Square safari = new SafariSquare("Visiting Safari", 10);
//    Habitat egret = new Habitat("Great Egret Habitat", 11, 160, 12, 60, 180, 500, 700, 900, 100,wetlands,1);
//    Square electric = new Special("Pay Electricity", 12, 150);
//    Habitat rail = new Habitat("King Rail Habitat", 13, 140, 10, 50, 150, 450, 675, 750, 100,wetlands,2);
//    Habitat shiner = new Habitat("Pugnose Shiner Habitat", 14, 140, 10, 50, 150, 450, 625, 750, 100,wetlands,3);
//    Square hatsu = new RiverSquare("Hatsu River", 15);
//    Habitat bat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100,cave,1);
//    Square wildCard3 = new WildCardSquare("Wild Card", 17);
//    Habitat salamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100,cave,2);
//    Habitat eel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100,cave,3);
//    Square bftb = new BackFromTheBrinkSquare("Back From The Brink Square", 20, 1000);
//    Habitat leopard = new Habitat("Amur Leopard Habitat", 21, 200, 18, 90, 250, 700, 875, 1050, 150,exotic,1);
//    Square wildCard4 = new WildCardSquare("Wild Card", 22);
//    Habitat rhino = new Habitat("Black Rhino Habitat", 23, 220, 18, 90, 250, 700, 875, 1050, 150,exotic,2);
//    Habitat tiger = new Habitat("Sunda Tiger Habitat", 24, 240, 20, 100, 300, 750, 925, 1100, 150,exotic,3);
//    Square trinity = new RiverSquare("Trinity River", 25);
//    Habitat bear = new Habitat("Polar Bear Habitat", 26, 260, 22, 110, 330, 800, 975, 1150, 150,snow,1);
//    Habitat fox = new Habitat("Arctic Fox Habitat", 27, 260, 22, 110, 330, 800, 975, 1150, 150,snow,2);
//    Square water = new Special("Get Water", 28, 150);
//    Habitat wolf = new Habitat("Arctic Wolf Habitat", 29, 280, 24, 120, 360, 850, 1025, 1200, 150,snow,3);
//    Square spotted = new Special("Spotted By Predator", 30, 0);
//    Habitat gorilla = new Habitat("Cross River Gorilla Habitat", 31, 300, 26, 130, 390, 900, 1100, 1275, 200,jungle,1);
//    Habitat orangutan = new Habitat("Orangutan Habitat", 32, 300, 26, 130, 390, 900, 1100, 1275, 200,jungle,2);
//    Square wildCard5 = new WildCardSquare("Wild Card", 33);
//    Habitat elephant = new Habitat("Asian Elephant Habitat", 34, 320, 28, 150, 450, 1000, 1200, 1400, 200,jungle,3);
//    Square duke = new RiverSquare("Duke River", 35);
//    Square wildCard6 = new WildCardSquare("Wild Card", 36);
//    Habitat whale = new Habitat("Blue Whale Habitat", 37, 400, 50, 200, 600, 1400, 1700, 2000, 200,marine,1);
//    Square hotel = new Special("Brink Hotel",38, 150);
//    Habitat turtle = new Habitat("Sea Turtle Habitat", 39, 350, 35, 175, 500, 1100, 1300, 1500, 200,marine,2);
//
//    WildCard advJag = new moveWildCard("Advance to Jaguar", true, false, jaguar);
//    WildCard advWhale = new moveWildCard("Advance to Blue Whale", true, false, whale);
//    WildCard advRiver = new moveWildCard("Advance to the Nearest River", true, true,null);
//    WildCard advTravel = new moveWildCard("Advance to Travel Square", true, false, travel);
//    WildCard back3 = new moveWildCard("Go Back 3 Squares", false, false, null);
//    WildCard caught = new moveWildCard("Caught by Predator, advance to Hiding in Safari", true, false, safari);
//    WildCard escape = new EscapeCard("Escape Safari Card");
//    WildCard grant = new receiveMatWildCard("Received a Grant", false, false, 200);
//    WildCard maint = new payUpWildCard("Assessed for Maintenance", true, 0);
//    WildCard breed = new receiveMatWildCard("Successful Breeding", true, false, 0);
//    WildCard chairman = new payUpWildCard("Elected As Chairman", false, 50);
//    WildCard food = new payUpWildCard("Food Bills", false, 100);
//    WildCard refund = new receiveMatWildCard("Conservation Fee Refund", false, false, 200);
//    WildCard consv = new receiveMatWildCard("Conservation Scheme", false, true, 0);
//
//    Piece david = new Piece("Sir David Attenborough",0); //testing pos =10
//    Piece irwin = new Piece("Steve Irwin",0);
//    Piece greta = new Piece("Greta Thunberg",0);
//    Piece steve = new Piece("Steve Backshall",0);
//    Piece jane = new Piece("Jane Goodall",0);
//    Piece john = new Piece("John Muir",0);
//    Piece theo = new Piece("Theodore Roosevelt",0);
//    Piece theo2 = new Piece("Theodore Roosevelt v2",0);

    @Before
    public void setUp() {
        newSquare = new Travel("test", 0);
        newWildCard = new WildCard("WildCard") {
            @Override
            public void execute(Player player) {

            }
        };
        newWildCard2 = new WildCard("WildCard2") {
            @Override
            public void execute(Player player) {

            }
        };
        Board.wildCards.clear();
    }

    @Test
    public void addSquare() {
        ArrayList<Square> expectedSquares = new ArrayList<>();
        expectedSquares.add(newSquare);
        Board.addSquare(newSquare);

        ArrayList<Square> actualSquares = Board.getSquares();

        assertEquals(expectedSquares, actualSquares);
    }

    @Test
    public void addWildCard() {
        ArrayList<WildCard> expectedCards = new ArrayList<>();
        expectedCards.add(newWildCard);
        Board.addWildCard(newWildCard);

        ArrayList<WildCard> actualCards = Board.getWildCards();

        assertEquals(expectedCards, actualCards);
    }

    @Test
    public void draw() {
        ArrayList<WildCard> expectedCards = new ArrayList<>();
        expectedCards.add(newWildCard);
        expectedCards.add(newWildCard2);

        WildCard expectedCardDrawn = expectedCards.get(expectedCards.size()-1);
        expectedCards.remove(expectedCards.size()-1);
        expectedCards.add(0, expectedCardDrawn);

        Board.addWildCard(newWildCard);
        Board.addWildCard(newWildCard2);
        Board.draw();

        ArrayList<WildCard> actualCards = Board.getWildCards();

        assertEquals(expectedCards, actualCards);
    }

    @Test
    public void removeWildCard() {
        ArrayList<WildCard> expectedCards = new ArrayList<>();
        expectedCards.add(newWildCard);

        Board.addWildCard(newWildCard);
        Board.addWildCard(newWildCard2);
        Board.removeWildCard(newWildCard2);

        ArrayList<WildCard> actualCards = Board.getWildCards();

        assertEquals(expectedCards, actualCards);
    }

    @Test
    public void setupBoard() {
//        ArrayList<Square> expectedSquares = new ArrayList<>();
//        ArrayList<WildCard> expectedWildCards = new ArrayList<WildCard>();
//        ArrayList<Piece> expectedPieces = new ArrayList<Piece>();
//        ArrayList<Biome> expectedBiomes = new ArrayList<Biome>();
//
//        expectedSquares.add(travel);
//        expectedSquares.add(brownBear);
//        expectedSquares.add(wildCard1);
//        expectedSquares.add(jaguar);
//        expectedSquares.add(conservation);
//        expectedSquares.add(zile);
//        expectedSquares.add(crane);
//        expectedSquares.add(wildCard2);
//        expectedSquares.add(parrot);
//        expectedSquares.add(duck);
//        expectedSquares.add(safari);
//        expectedSquares.add(egret);
//        expectedSquares.add(electric);
//        expectedSquares.add(rail);
//        expectedSquares.add(shiner);
//        expectedSquares.add(hatsu);
//        expectedSquares.add(bat);
//        expectedSquares.add(wildCard3);
//        expectedSquares.add(salamander);
//        expectedSquares.add(eel);
//        expectedSquares.add(bftb);
//        expectedSquares.add(leopard);
//        expectedSquares.add(wildCard4);
//        expectedSquares.add(rhino);
//        expectedSquares.add(tiger);
//        expectedSquares.add(trinity);
//        expectedSquares.add(bear);
//        expectedSquares.add(fox);
//        expectedSquares.add(water);
//        expectedSquares.add(wolf);
//        expectedSquares.add(spotted);
//        expectedSquares.add(gorilla);
//        expectedSquares.add(orangutan);
//        expectedSquares.add(wildCard5);
//        expectedSquares.add(elephant);
//        expectedSquares.add(duke);
//        expectedSquares.add(wildCard6);
//        expectedSquares.add(whale);
//        expectedSquares.add(hotel);
//        expectedSquares.add(turtle);
//
//        expectedWildCards.add(advJag);
//        expectedWildCards.add(advWhale);
//        expectedWildCards.add(advRiver);
//        expectedWildCards.add(advTravel);
//        expectedWildCards.add(back3);
//        expectedWildCards.add(caught);
//        expectedWildCards.add(escape);
//        expectedWildCards.add(grant);
//        expectedWildCards.add(maint);
//        expectedWildCards.add(breed);
//        expectedWildCards.add(chairman);
//        expectedWildCards.add(food);
//        expectedWildCards.add(refund);
//        expectedWildCards.add(consv);
//
//        expectedPieces.add(david);
//        expectedPieces.add(irwin);
//        expectedPieces.add(greta);
//        expectedPieces.add(steve);
//        expectedPieces.add(jane);
//        expectedPieces.add(john);
//        expectedPieces.add(theo);
//        expectedPieces.add(theo2);
//
//        expectedBiomes.add(cave);
//        expectedBiomes.add(wetlands);
//        expectedBiomes.add(sky);
//        expectedBiomes.add(forest);
//        expectedBiomes.add(marine);
//        expectedBiomes.add(jungle);
//        expectedBiomes.add(snow);
//        expectedBiomes.add(exotic);
//
//        Board.setupBoard();
//
//        ArrayList<Square> actualSquares = Board.getSquares();
//        ArrayList<WildCard> actualWildCards = Board.getWildCards();
//        ArrayList<Piece> actualPieces = Board.getPieces();
//        ArrayList<Biome> actualBiomes = Board.getBiomes();
//
//        assertEquals(expectedSquares, actualSquares);
//        assertEquals(expectedWildCards, actualWildCards);
//        assertEquals(expectedPieces, actualPieces);
//        assertEquals(expectedBiomes, actualBiomes);

    }

    @After
    public void tearDown() {
        newSquare = null;
        newWildCard = null;
        newWildCard2 = null;
    }
}