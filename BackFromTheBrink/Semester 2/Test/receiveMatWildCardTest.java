import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class receiveMatWildCardTest {

    static Board board;
    static Player testPlayer;
    WildCard card = new receiveMatWildCard("Received a Grant", false, false, 200);
    WildCard card2 = new receiveMatWildCard("Successful Breeding", true, false, 0);
    WildCard card3 = new receiveMatWildCard("Conservation Scheme", false, true, 0);

    Biome cave = new Biome(1, "Cave Biome", 3);
    Habitat bat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100,cave, 1);
    Habitat salamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100,cave, 2);
    Habitat eel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100,cave, 3);

    @Before
    public void setUp() {
        testPlayer = new Player("test");
        BackFromTheBrink.players.add(testPlayer);
        testPlayer.getInventory().setMaterials(2000);
        Board.setupBoard();

    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }

    @Test
    public void executeNorm() {
        int expectedMaterials = testPlayer.getInventory().getMaterials() + 200;
        card.execute(testPlayer);
        int actualMaterials = testPlayer.getInventory().getMaterials();

        assertEquals(expectedMaterials, actualMaterials);
    }

    @Test
    public void executeBreed() {
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);

        bat.setOwner(testPlayer);
        salamander.setOwner(testPlayer);
        eel.setOwner(testPlayer);

        int expectedMaterials = testPlayer.getInventory().getMaterials() + 300;
        card2.execute(testPlayer);
        int actualMaterials = testPlayer.getInventory().getMaterials();

        assertEquals(expectedMaterials, actualMaterials);
    }

    @Test
    public void executeConsch() {
        Player testPlayer1 = new Player("test1");
        Player testPlayer2 = new Player("test2");
        Player testPlayer3 = new Player("test3");
        Player testPlayer4 = new Player("test4");

        BackFromTheBrink.players.add(testPlayer1);
        BackFromTheBrink.players.add(testPlayer2);
        BackFromTheBrink.players.add(testPlayer3);
        BackFromTheBrink.players.add(testPlayer4);

        int expectedMaterials = testPlayer.getInventory().getMaterials() + 200;
        card3.execute(testPlayer);
        int actualMaterials = testPlayer.getInventory().getMaterials();

        assertEquals(expectedMaterials, actualMaterials);

    }
}