import java.util.*;

public class BackFromTheBrink {

    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Player> outOfGame = new ArrayList<Player>();
    private static boolean bftbWon = false;
    static Board board;

    static Dice di = new Dice();

    public static void main(String[] args) {

       board = new Board();

        players = PlayerRegistration.BeginRegistration();
        board.setupBoard();

        while(getPlayersInGame(players) > 1 || !getBftbWon()) {
            playerTurnHandler();
        }
        //win condition
    }

    public static int getPlayersInGame(ArrayList<Player> players) {
        int number = 0;
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).isOutOfMaterials()){
                number++;
            }
        }
        return number;
    }

    public static void setBftbWon() {
        bftbWon = true;
    }

    public static boolean getBftbWon() {
       return bftbWon;
    }

    public static void playerTurnHandler() {
        //print statements
        for (int i = 0; i < players.size(); i++) {
            Scanner sc = new Scanner(System.in);
            //check if player is in jail/safari
            if(players.get(i).isInSafari()){
                //print out options
                int option = sc.nextInt();
                inSafariOptions(option);
            }
            else {

                di.nextPlayer(); // reset Double "memory" of dice
                int rollValue = di.getRollValue();

                //move around board
                //moveAroundBoard(rollValue);
                players.get(i).getPiece().move(rollValue);


                if (di.getIsDouble()) {
                    int rollValue2 = di.getRollValue();
                    // move around board
                    //moveAroundBoard(rollValue);
                    players.get(i).getPiece().move(rollValue);
                }

                if (di.getIsSecondDouble()) {
                    // go to jail
                    players.get(i).setInSafari(true);
                    // move player to the spotted in the safari sqaure
                    players.get(i).getPiece().move(board.getSquare(30));
                }

                //print out all options available
                //request input
                int option = sc.nextInt();
                while (option != 9) {
                    turnOptions(option);
                }
            }
        }
    }

    public static void inSafariOptions(int option) {
        switch(option) {
            case 1: //Roll dice and try get a double
            case 2: //Pay fee
            case 3: //Use wildcard
        }
    }

    public static void turnOptions(int option) {
        switch(option) {
            case 1: //end turn
            case 2: //build zoo()
            case 3: //trade()
        }
    }
}
