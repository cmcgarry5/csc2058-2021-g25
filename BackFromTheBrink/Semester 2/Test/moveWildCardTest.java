import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class moveWildCardTest {

//    @Before
//    public void setUp() {
//
//    }
//
//    @After
//    public void tearDown() {
//        testPlayer = null;
//        board = null;
//    }

    @Test
    public void execute() {
        Player testPlayer = new Player("test");
        Board.setupBoard();

        WildCard card = new moveWildCard("Advance to Jaguar", true, false, BackFromTheBrink.board.getSquare(3));
        testPlayer.getInventory().addWildCard(card);
        testPlayer.setPiece(Board.pieces.get(1));
        testPlayer.getPiece().setPos(1);
        testPlayer.setPiece(Board.pieces.get(2));
        testPlayer.getPiece().setPos(2);

        int expectedPosition = 3;
        card.execute(testPlayer);
        int actualPosition = testPlayer.getPiece().getPos();

        assertEquals(expectedPosition, actualPosition);
    }
}