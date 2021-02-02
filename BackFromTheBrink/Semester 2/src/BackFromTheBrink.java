import java.util.*;

public class BackFromTheBrink {
    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Player> outOfGame = new ArrayList<Player>();
    private static boolean bftbWon = false;

    public static void main(String[] args) {
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
            players.get();
            //returns 1 int
            int totalRoll = 0;
            int first = getDiceRoll();
            int second = getDiceRoll();
            totalRoll += first + second;
            if (first == second) {
                getDiceRoll();
                getDiceRoll();
            }
            moveAroundBoard(totalRoll);
            //request input
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt;
            while (option != 9) {
                turnOptions(input);
            }
        }
    }

    public static void turnOptions(int option) {
        switch(option) {
            case 1: //all the methods needed
        }
    }
}
