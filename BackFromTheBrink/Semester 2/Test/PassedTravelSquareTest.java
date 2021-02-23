import org.junit.Test;

import java.util.ArrayList;

public class PassedTravelSquareTest {

    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Player> outOfGame = new ArrayList<Player>();
    private static boolean bftbWon = false;
    //private static StdIO StdIO;
    static Board board;

    static Dice di = new Dice();

    static final String[] inSafariOptions = {"Try to Roll a double.", "Pay 50 materials to escape.", "Use a wildcard.", "Forfeit Game"};
    static Menu InSafariMenu = new Menu("In Safari Options:",inSafariOptions);

    static final String[] turnOptions = {"End turn", "Build on Habitat", "Initiate a trade", "Forfeit Game"};
    static Menu turnOptionsMenu = new Menu("Additional Turn Options:",turnOptions);

    static Player testPlayer = new Player("test");

    @Test
    public void checkPassedTravelSquareHit() {
        Board.setupBoard();
        testPlayer.setPiece(Board.pieces.get(1));

        testPlayer.getPiece().setPos(38);
        System.out.println(StdIO.printPlayer(testPlayer));
        testPlayer.getPiece().move(4);
        if(board.getSquare(testPlayer.getPiece().getPos()) instanceof Travel){
            ((Travel)board.getSquare(testPlayer.getPiece().getPos())).execute(testPlayer);
        }
        if(testPlayer.getPiece().hasPassedTravelSquare() && testPlayer.getPiece().getPos() != 0) {
            Travel.passedTravelSquare(testPlayer);
        }
        System.out.println(StdIO.printPlayer(testPlayer));
    }

    @Test
    public void checkLandedOnTravelSquare() {
        Board.setupBoard();
        testPlayer.setPiece(Board.pieces.get(1));

        //postion for travel square
        testPlayer.getPiece().setPos(38);
        System.out.println(StdIO.printPlayer(testPlayer));
        testPlayer.getPiece().move(2);
        if(board.getSquare(testPlayer.getPiece().getPos()) instanceof Travel){
            ((Travel)board.getSquare(testPlayer.getPiece().getPos())).execute(testPlayer);
        }
        System.out.println(StdIO.printPlayer(testPlayer));
    }
}
