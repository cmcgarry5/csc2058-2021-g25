import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HabitatTest {

    static Board board;
    static Player testPlayer;
    Biome cave = new Biome("Cave Biome", 3);
    Habitat bat = new Habitat("Grey Bat Habitat", 16, 160, 14, 70, 200, 550, 700, 900, 100,cave);
    Habitat salamander = new Habitat("Blind Salamander Habitat", 18, 160, 14, 70, 200, 550, 700, 950, 100,cave);
    Habitat eel = new Habitat("Blind Cave Eel Habitat", 19, 200, 16, 80, 220, 600, 800, 1000, 100,cave);

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
    }

    @Test
    public void setPark() {
    }

    @Test
    public void getCost() {
    }

    @Test
    public void getFee() {
    }

    @Test
    public void getNumberOfZoos() {
    }

    @Test
    public void getFee1Zoo() {
    }

    @Test
    public void getFee2Zoo() {
    }

    @Test
    public void getFee3Zoo() {
    }

    @Test
    public void getFee4Zoo() {
    }

    @Test
    public void getFeePark() {
    }

    @Test
    public void getOwner() {
    }

    @Test
    public void getBuildCost() {
    }

    @Test
    public void addZoo() {
    }

    @Test
    public void removeZoo() {
    }

    @Test
    public void addNationalPark() {
    }

    @Test
    public void hasNationalPark() {
    }

    @Test
    public void getHabitatInfo() {
    }

    @Test
    public void getBiome() {
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
    }

    @Test
    public void getLandingOnFee() {
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}