import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HabitatTest {

    static Board board;
    static Player testPlayer;
    Biome cave = new Biome("Cave Biome", 3);
    Habitat bat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100,cave, 1);
    Habitat salamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100,cave, 2);
    Habitat eel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100,cave, 3);

    @Before
    public void setUp() {
        testPlayer = new Player("test");
        Board.setupBoard();
    }

    @Test
    public void execute() {
    }

    @Test
    public void setOwner() {
        bat.setOwner(testPlayer);
        Player actualOwner = bat.getOwner();

        assertEquals(testPlayer, actualOwner);
    }

    @Test
    public void setPark() {
        bat.setPark(true);
        boolean actualPark = bat.hasNationalPark();

        assertTrue(actualPark);
    }

    @Test
    public void addZoo() {
        int expectedNumZoos = bat.getNumberOfZoos()+1;
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);
        bat.setOwner(testPlayer);
        salamander.setOwner(testPlayer);
        eel.setOwner(testPlayer);
        bat.addZoo();
        int actualNumZoos = bat.getNumberOfZoos();

        assertEquals(expectedNumZoos, actualNumZoos);
    }

    @Test
    public void removeZoo() {
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);
        bat.setOwner(testPlayer);
        salamander.setOwner(testPlayer);
        eel.setOwner(testPlayer);
        bat.addZoo();
        bat.addZoo();
        int expectedNumZoos = bat.getNumberOfZoos()-1;
        bat.removeZoo();

        int actualNumZoos = bat.getNumberOfZoos();

        assertEquals(expectedNumZoos, actualNumZoos);
    }

    @Test
    public void addNationalPark() {
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);
        bat.setOwner(testPlayer);
        salamander.setOwner(testPlayer);
        eel.setOwner(testPlayer);
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addNationalPark();

        boolean actualPark = bat.hasNationalPark();

        assertTrue(actualPark);
    }

    @Test
    public void resetHabitat() {
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);
        bat.setOwner(testPlayer);
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addNationalPark();
        int expectedNumZoos = 0;

        bat.resetHabitat();
        Player actualOwner = bat.getOwner();
        boolean actualNationalPark = bat.hasNationalPark();
        int actualNumZoos = bat.getNumberOfZoos();

        assertEquals("owner", null, actualOwner);
        assertEquals("numZoos", expectedNumZoos, actualNumZoos);
        assertFalse("National Park", actualNationalPark);
    }

    @Test
    public void isOwned() {
        bat.setOwner(testPlayer);

        boolean actualOwner = bat.isOwned();

        assertTrue(actualOwner);
    }

    @Test
    public void getLandingOnFee() {
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer.getInventory().addHabitat(cave, eel);
        bat.setOwner(testPlayer);
        salamander.setOwner(testPlayer);
        eel.setOwner(testPlayer);
        bat.addZoo();

        int expectedFee = bat.getFee1Zoo();
        int actualFee = bat.getLandingOnFee();

        assertEquals(expectedFee, actualFee);
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}