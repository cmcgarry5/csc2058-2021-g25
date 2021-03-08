import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EscapeCardTest {

    static Board board;
    static Player testPlayer;
    WildCard card = new EscapeCard("Escape Safari Card");

    @Before
    public void setUp() {
        testPlayer = new Player("test");
        Board.setupBoard();

        testPlayer.getInventory().addWildCard(card);
        testPlayer.setPiece(Board.pieces.get(1));
        testPlayer.getPiece().setPos(1);
        testPlayer.setPiece(Board.pieces.get(2));
        testPlayer.getPiece().setPos(2);
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }

    @Test
    public void execute() {
        int prevPosition = testPlayer.getPiece().getPos();
        card.execute(testPlayer);
        int actualPosition = testPlayer.getPiece().getPos();

        assertNotEquals(prevPosition, actualPosition);
    }
}