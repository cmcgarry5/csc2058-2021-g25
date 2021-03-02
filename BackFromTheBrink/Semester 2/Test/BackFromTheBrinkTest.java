import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BackFromTheBrinkTest {

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
        Player testPlayer2 = new Player("test2");
        testPlayer.setPiece(Board.pieces.get(1));
        testPlayer.getPiece().setPos(1);
        ArrayList<Player> expectedOutOfGame = new ArrayList<>();
        ArrayList<Player> expectedPlayers = new ArrayList<>();
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
        BackFromTheBrink.players.add(testPlayer);
        BackFromTheBrink.bankrupt(testPlayer, testPlayer2);

        expectedOutOfGame.add(testPlayer);

        assertEquals(expectedPlayers, BackFromTheBrink.players);
        assertEquals(expectedOutOfGame, BackFromTheBrink.outOfGame);
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