import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassedTravelSquareTest {
    static Board board;
    static Player testPlayer;

    @Before
    public void setUp() {
        testPlayer = new Player("test");
        testPlayer.getInventory().setMaterials(1500);
        Board.setupBoard();
    }

    @Test
    public void PassedTravelSquareTest() {
        int expectedMaterials = 1700;
        testPlayer.setPiece(Board.pieces.get(1));
        Travel.passedTravelSquare(testPlayer);
        int actualMaterials = testPlayer.getInventory().getMaterials();

        Assert.assertEquals("Materials: ", expectedMaterials, actualMaterials);
        Assert.assertTrue(testPlayer.getPiece().hasPassedTravelSquare());
    }
//    public void checkPassedTravelSquareHit() {
//        Player testPlayer = new Player("test");
//        Board board = new Board();
//        Board.setupBoard();
//        testPlayer.getInventory().setMaterials(1500);
//        int expectedMaterials = testPlayer.getInventory().getMaterials() + ((Travel)board.getSquare((0))).getAmountGain();
//        testPlayer.setPiece(Board.pieces.get(1));
//        testPlayer.getPiece().setPos(38);
//        System.out.println(StdIO.printPlayer(testPlayer));
//        testPlayer.getPiece().move(4);
//        if(board.getSquare(testPlayer.getPiece().getPos()) instanceof Travel){
//            ((Travel)board.getSquare(testPlayer.getPiece().getPos())).execute(testPlayer);
//        }
//        if(!testPlayer.getPiece().hasPassedTravelSquare() && testPlayer.getPiece().getPos() != 0) {
//            Travel.passedTravelSquare(testPlayer);
//        }
//        int actualMaterials = testPlayer.getInventory().getMaterials();
//        System.out.println(StdIO.printPlayer(testPlayer));
//
//        Assert.assertEquals("Materials: ", expectedMaterials, actualMaterials);
//    }

//    @Test
//    public void checkLandedOnTravelSquare() {
//        Player testPlayer = new Player("test");
//        Board board = new Board();
//        Board.setupBoard();
//        testPlayer.setPiece(Board.pieces.get(1));
//        int expectedMaterials =  testPlayer.getInventory().getMaterials() + ((Travel)board.getSquare((0))).getAmountGain();
//        //postion for travel square
//        testPlayer.getPiece().setPos(38);
//        System.out.println(StdIO.printPlayer(testPlayer));
//        testPlayer.getPiece().move(2);
//        if(board.getSquare(testPlayer.getPiece().getPos()) instanceof Travel){
//            ((Travel)board.getSquare(testPlayer.getPiece().getPos())).execute(testPlayer);
//        }
//        int actualMaterials = testPlayer.getInventory().getMaterials();
//        System.out.println(StdIO.printPlayer(testPlayer));
//
//        Assert.assertEquals("Materials: ", expectedMaterials, actualMaterials);
//    }

    @Test
    public void TravelExecuteTest() {
        int expectedMaterials = 1700;
        testPlayer.setPiece(Board.pieces.get(1));
        ((Travel)board.getSquare(testPlayer.getPiece().getPos())).execute(testPlayer);
        int actualMaterials = testPlayer.getInventory().getMaterials();

        Assert.assertEquals("Materials: ", expectedMaterials, actualMaterials);
    }

    @After
    public void tearDown() {
        testPlayer = null;
        board = null;
    }
}
