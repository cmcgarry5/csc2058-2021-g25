import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
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
        ArrayList<Player> expectedPlayerRankings = new ArrayList<>();
        Player testplayer1 = new Player("test1");
        Player testplayer2 = new Player("test2"); // we want this one
        Player testplayer3 = new Player("test3");
        Player testplayer4 = new Player("test4");

        testplayer1.setRanking(4000);
        testplayer2.setRanking(5000);
        testplayer3.setRanking(1000);
        testplayer4.setRanking(8000);

        BackFromTheBrink.players.add(testplayer1);
        BackFromTheBrink.players.add(testplayer2);
        BackFromTheBrink.players.add(testplayer3);
        BackFromTheBrink.players.add(testplayer4);

        expectedPlayerRankings.add(testplayer4);
        expectedPlayerRankings.add(testplayer2);
        expectedPlayerRankings.add(testplayer1);
        expectedPlayerRankings.add(testplayer3);

        int expectedPlayerRank = 2; // 2nd place

        //ArrayList<Player> actualPlayerRankings = BackFromTheBrink.players;
        int actualPlayerRank = BackFromTheBrink.ranking(testplayer2);

        //assertEquals(expectedPlayerRankings, actualPlayerRankings);
        assertEquals(expectedPlayerRank, actualPlayerRank);

    }

    @Test
    public void winningCelebrations() {
        Player testplayer1 = new Player("test1");
        Player testplayer2 = new Player("test2");
        Player testplayer3 = new Player("test3");
        Player testplayer4 = new Player("test4");

        BackFromTheBrink.playerRankings.add(testplayer1);
        BackFromTheBrink.playerRankings.add(testplayer2);
        BackFromTheBrink.playerRankings.add(testplayer3);
        BackFromTheBrink.playerRankings.add(testplayer4);

        BackFromTheBrink.winningCelebrations();
    }

    @Test
    public void trade() {
        Player testPlayer2 = new Player("test2");
        testPlayer.setPiece(Board.pieces.get(1));
        testPlayer.getPiece().setPos(1);
        testPlayer2.setPiece(Board.pieces.get(2));
        testPlayer2.getPiece().setPos(2);
        testPlayer.getInventory().addHabitat(cave, bat);
        testPlayer.getInventory().addHabitat(cave, salamander);
        testPlayer2.getInventory().addHabitat(cave, eel);
        bat.setOwner(testPlayer);
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addZoo();
        bat.addNationalPark();
        BackFromTheBrink.players.add(testPlayer);
        BackFromTheBrink.players.add(testPlayer2);
        BackFromTheBrink.trade(testPlayer);
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}