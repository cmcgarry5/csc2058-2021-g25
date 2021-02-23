import org.junit.Test;

import java.util.ArrayList;
public class PayOwnedHabitatFeeTest {
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
    static Player testPlayer1 = new Player("test1");

    @Test
    public void checkPayOwnedHabitatFee() {
        Board.setupBoard();
        testPlayer.setPiece(Board.pieces.get(1));
    }

}
