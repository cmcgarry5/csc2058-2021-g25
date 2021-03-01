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
    public void getMaterials() {
    }

    @Test
    public void setMaterials() {
    }

    @Test
    public void getWildCard() {
    }

    @Test
    public void addWildCard() {
    }

    @Test
    public void getBiomes() {
    }

    @Test
    public void getBiomesInfo() {
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
        //ArrayList<Habitat> actualHabitats = testPlayer2.getInventory().getBiome(1).getHabitats();
        Player actualOwner = bat.getOwner();

        assertEquals(expectedWildCards, actualWildCards);
        assertEquals(expectedBiomes, actualBiomes);
        assertEquals(expectedOwner, actualOwner);
        //assertEquals(expectedHabitats, actualHabitats);
    }

    @Test
    public void addBiome() {
    }

    @Test
    public void addHabitat() {
    }

    @Test
    public void increasePlayerMaterials() {
    }

    @Test
    public void deductPlayerMaterials() {
    }

    @Test
    public void checkPlayerMaterials() {
    }

    @Test
    public void updateInfo() {
    }

    @Test
    public void hasCompleteBiome() {
    }

    @Test
    public void hasWildCard() {
    }

    @Test
    public void returnWildCardToBoard() {
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}