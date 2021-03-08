import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class payUpWildCardTest {

    static Board board;
    static Player testPlayer;
    WildCard card = new payUpWildCard("Elected As Chairman", false, 50);
    WildCard card2 = new payUpWildCard("Assessed for Maintenance", true, 0);

    Biome cave = new Biome(1, "Cave Biome", 3);
    Habitat bat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100,cave, 1);
    Habitat salamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100,cave, 2);
    Habitat eel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100,cave, 3);

    @Before
    public void setUp() {
        testPlayer = new Player("test");
        testPlayer.getInventory().setMaterials(2000);
        Board.setupBoard();

    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }


    @Test
    public void executeNotMaint() {
    int expectedMaterials = testPlayer.getInventory().getMaterials() - 50;
    card.execute(testPlayer);
    int actualMaterials = testPlayer.getInventory().getMaterials();

    assertEquals(expectedMaterials, actualMaterials);
    }

    @Test
    public void executeMaint() {
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);

        bat.setOwner(testPlayer);
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();

        int expectedMaterials = testPlayer.getInventory().getMaterials() - 160;
        card2.execute(testPlayer);
        int actualMaterials = testPlayer.getInventory().getMaterials();


        assertEquals(expectedMaterials, actualMaterials);
    }

}