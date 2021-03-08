import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PieceTest {
    static Board board;
    static Player testPlayer;
    static Piece testPiece = new Piece("Test Piece", 0);

    @Before
    public void setUp() {
        testPlayer = new Player("test");
        Board.setupBoard();
        testPlayer.setPiece(testPiece);
    }

    @Test
    public void move() {
        testPlayer.getPiece().move(3);

        int resultPos = testPlayer.getPiece().getPos();

        assertEquals(3, resultPos);
    }

    @Test
    public void setName() {
        testPlayer.getPiece().setName("New Test Name");
        String resultName = testPlayer.getPiece().getName();
        assertEquals("New Test Name", resultName);
    }

    @Test
    public void setTaken() {
        testPlayer.getPiece().setTaken(true);
        boolean resultTaken = testPlayer.getPiece().getTaken();
        assertEquals(true, resultTaken);
    }

    @Test
    public void setPassedTravelSquare() {
        testPlayer.getPiece().setPassedTravelSquare(true);
        boolean resultSetPassedTravelSquare = testPlayer.getPiece().hasPassedTravelSquare();
        assertEquals(true, resultSetPassedTravelSquare);
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}
