import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackFromTheBrinkTest {

    static Board board;
    static Player testPlayer;

    @Before
    public void setUp() {
        testPlayer = new Player("test");
        Board.setupBoard();
    }

    @Test
    public void main() {
    }

    @Test
    public void getPlayersInGame() {
    }

    @Test
    public void setBftbWon() {
    }

    @Test
    public void getBftbWon() {
    }

    @Test
    public void playerTurnHandler() {
    }

    @Test
    public void displayInSafariOptionsMenu() {
    }

    @Test
    public void processInSafariOption() {
    }

    @Test
    public void processTurnOption() {
    }

    @Test
    public void buyHabitat() {
    }

    @Test
    public void bankrupt() {
//        int pos = 1;
//        testPlayer.getInventory().addBiome();
//        Habitat currentHabitat = (Habitat)(BackFromTheBrink.board.getSquare(pos));
    }

    @Test
    public void ranking() {
    }

    @Test
    public void trade() {
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}