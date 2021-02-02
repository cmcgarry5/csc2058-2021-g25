import java.util.*;

public class BackFromTheBrink {

    public static class SpottedByPredator extends Square{

        public SpottedByPredator(String newName, int nextPos) {
            super(newName, nextPos);
        }
    }
    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Player> outOfGame = new ArrayList<Player>();
    private static boolean bftbWon = false;
    static Board board;

    static Dice di = new Dice();

    public static void main(String[] args) {

       board = new Board();

        Square spottedInSafari = new SpottedByPredator("SpottedByPredator", 30);
        board.addSquare(spottedInSafari);

        while(getPlayersInGame(players) > 1 || !getBftbWon()) {
            playerTurnHandler();
        }
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
            //check if player is in jail/safari
            if(players.get(i).isInSafari()){
                // execute in safari options

            }

            di.nextPlayer(); // reset Double "memory" of dice
            int rollValue = di.getRollValue();

            //move around board
            //moveAroundBoard(rollValue);
            players.get(i).getPiece().move(rollValue);


            if(di.getIsDouble()){
                int rollValue2 = di.getRollValue();
                // move around board
                //moveAroundBoard(rollValue);
                players.get(i).getPiece().move(rollValue);
            }

            if(di.getIsSecondDouble()){
                // go to jail
                players.get(i).setInSafari(true);
                // move player to the spotted in the safari sqaure
                players.get(i).getPiece().move(board.getSquare(30));
            }

            //request input
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            while (option != 9) {
                turnOptions(option);
            }
        }
    }

    public static void turnOptions(int option) {
        switch(option) {
            case 1: //all the methods needed
        }
    }
}
