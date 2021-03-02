import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class InventoryTest {

    static Board board;
    static Player testPlayer;
    Biome cave = new Biome(1, "Cave Biome", 3);
    Habitat bat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100,cave, 1);
    Habitat salamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100,cave, 2);
    Habitat eel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100,cave, 3);
    WildCard card = new EscapeCard("Escape Safari Card");

    @Before
    public void setUp() {
        testPlayer = new Player("test");
        Board.setupBoard();
    }

    @Test
    public void setMaterials() {
        testPlayer.getInventory().setMaterials(2000);

        int actualMaterials = testPlayer.getInventory().getMaterials();

        assertEquals(2000, actualMaterials);
    }

    @Test
    public void addWildCard() {
        testPlayer.getInventory().addWildCard(card);
        ArrayList<WildCard> expectedWildCards = new ArrayList<>();
        expectedWildCards.add(card);

        ArrayList<WildCard> actualWildCards = testPlayer.getInventory().getWildCard();

        assertEquals(expectedWildCards, actualWildCards);
    }

    @Test
    public void returnToBoard() {
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);
        bat.setOwner(testPlayer);
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addNationalPark();
        Board.removeWildCard(card);
        testPlayer.getInventory().addWildCard(card);
        testPlayer.getInventory().returnToBoard();

        ArrayList<WildCard> actualWildCards = testPlayer.getInventory().getWildCard();

        assertEquals(null, actualWildCards);
    }

    @Test
    public void forfeitToPlayer() {
        Player testPlayer2 = new Player("test2");
        ArrayList<WildCard> expectedWildCards = new ArrayList<>();
        ArrayList<Biome> expectedBiomes = new ArrayList<>();
        ArrayList<Habitat> expectedHabitats = new ArrayList<>();
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);
        bat.setOwner(testPlayer);
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addNationalPark();
        Board.removeWildCard(card);
        testPlayer.getInventory().addWildCard(card);
        testPlayer.getInventory().forfeitToPlayer(testPlayer2);

        expectedWildCards.add(card);
        expectedBiomes.add(cave);
        expectedHabitats.add(bat);
        expectedHabitats.add(salamander);
        expectedHabitats.add(eel);
        Player expectedOwner = testPlayer2;

        ArrayList<WildCard> actualWildCards = testPlayer2.getInventory().getWildCard();
        ArrayList<Biome> actualBiomes = testPlayer2.getInventory().getBiomes();
        ArrayList<Habitat> actualHabitats = testPlayer2.getInventory().getBiome(1).getHabitats();
        Player actualOwner = bat.getOwner();

        assertEquals(expectedWildCards, actualWildCards);
        assertEquals(expectedBiomes, actualBiomes);
        assertEquals(expectedOwner, actualOwner);
        assertEquals(expectedHabitats, actualHabitats);
    }

    @Test
    public void addBiome() {
        testPlayer.getInventory().addBiome(cave);
        ArrayList<Biome> expectedBiomes = new ArrayList<>();
        expectedBiomes.add(cave);

        ArrayList<Biome> actualBiomes = testPlayer.getInventory().getBiomes();

        assertEquals(expectedBiomes, actualBiomes);
    }

    @Test
    public void addHabitat() {
        testPlayer.getInventory().addHabitat(cave, bat);

        ArrayList<Habitat> expectedHabitats = new ArrayList<>();
        ArrayList<Habitat> actualHabitats = testPlayer.getInventory().getBiome(1).getHabitats();

        expectedHabitats.add(bat);
        assertEquals(expectedHabitats, actualHabitats);
    }

    @Test
    public void increasePlayerMaterials() {
        int expectedMaterials = testPlayer.getInventory().getMaterials() + 100;
        testPlayer.getInventory().increasePlayerMaterials(100);
        int actualMaterials = testPlayer.getInventory().getMaterials();

        assertEquals(expectedMaterials, actualMaterials);
    }

    @Test
    public void deductPlayerMaterials() {
        int expectedMaterials = testPlayer.getInventory().getMaterials() - 100;
        testPlayer.getInventory().deductPlayerMaterials(100);
        int actualMaterials = testPlayer.getInventory().getMaterials();

        assertEquals(expectedMaterials, actualMaterials);
    }

    @Test
    public void checkPlayerMaterials() {
        testPlayer.getInventory().setMaterials(2000);
        boolean actualCheckPlayerMaterials = testPlayer.getInventory().checkPlayerMaterials(1500);

        assertTrue(actualCheckPlayerMaterials);
    }

    @Test
    public void hasCompleteBiome() {
        testPlayer.getInventory().addBiome(cave);
        cave.setNumberOfHabitats(2);
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);

        boolean actualHasCompleteBiome = testPlayer.getInventory().getBiome(1).isAllOwned();

        assertTrue(actualHasCompleteBiome);
    }

    @Test
    public void hasWildCard() {
        testPlayer.getInventory().addWildCard(card);
        boolean actualWildCard = testPlayer.getInventory().hasWildCard();

        assertTrue(actualWildCard);
    }

    @Test
    public void returnWildCardToBoard() {
        Board.wildCards.clear();
        testPlayer.getInventory().addWildCard(card);
        testPlayer.getInventory().returnWildCardToBoard();
        ArrayList<WildCard> expectedBoardWildCards = new ArrayList<>();
        expectedBoardWildCards.add(card);

        ArrayList<WildCard> actualBoardWildCards = Board.wildCards;

        assertEquals(expectedBoardWildCards, actualBoardWildCards);
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}