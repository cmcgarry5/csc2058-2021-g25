import java.util.*;

public class BackFromTheBrink {
    static ArrayList<Player> players = new ArrayList<Player>();

    public static void main(String[] args) {
        while(numberOfPlayerStillAlive > 1 || !backForTheBrinkSquareBought) {
            playerTurnHandler();
        }
    }

    public static void playerTurnHandler() {
        //print statements
        for (int i = 0; i < players.size(); i++) {
            //check if player is in jail/safari
            checkInSafari(player);
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
