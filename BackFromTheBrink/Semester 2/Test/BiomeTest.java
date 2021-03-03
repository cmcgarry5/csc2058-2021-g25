import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BiomeTest {

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
    public void setBiomeName() {
        cave.setBiomeName("newCave");
        String actualBiomeName = cave.getName();

        assertEquals("newCave", actualBiomeName);
    }

    @Test
    public void setNumberOfHabitats() {
        cave.setNumberOfHabitats(100);
        int actualNumHabitats = cave.getNumberOfHabitats();

        assertEquals(100, actualNumHabitats);
    }

    @Test
    public void addAnimalHabitat() {
        ArrayList<Habitat> expectedHabitats;
        expectedHabitats = cave.getHabitats();
        Habitat centipede = new Habitat("Centipede Habitat", 50, 200, 16, 80, 220, 600, 800, 1000, 100, cave, 4);
        cave.addAnimalHabitat(centipede);

        expectedHabitats.add(centipede);
        ArrayList<Habitat> actualHabitats = cave.getHabitats();

        assertEquals(expectedHabitats, actualHabitats);
    }

    @Test
    public void removeHabitat() {
        cave.addAnimalHabitat(bat);
        cave.addAnimalHabitat(salamander);
        cave.addAnimalHabitat(eel);
        ArrayList<Habitat> expectedHabitats;
        expectedHabitats = cave.getHabitats();
        cave.removeHabitat(eel);

        expectedHabitats.remove(expectedHabitats.size()-1);
        ArrayList<Habitat> actualHabitats = cave.getHabitats();

        assertEquals(expectedHabitats, actualHabitats);
    }

    @Test
    public void isAllOwned() {
        cave.setNumberOfHabitats(cave.getNumberOwnedHabitats());

        boolean actualOwned = cave.isAllOwned();

        assertTrue(actualOwned);
    }

    @Test
    public void resetHabitats() {
        ArrayList<Habitat> expectedHabitats = new ArrayList<>();
        cave.addAnimalHabitat(bat);
        cave.addAnimalHabitat(salamander);
        cave.addAnimalHabitat(eel);
        cave.resetHabitats();

        ArrayList<Habitat> actualHabitats = cave.getHabitats();

        assertEquals(expectedHabitats, actualHabitats);
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}