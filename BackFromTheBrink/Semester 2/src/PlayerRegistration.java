import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PlayerRegistration {

    static Dice dice = new Dice();

    static class ListPlayersPlayer {
        ArrayList<Player> players;
        Player highestPlayer;
        int highestScore;

        ListPlayersPlayer(ArrayList<Player> players, Player highestPlayer, int highestScore)
        {
            this.players = players;
            this.highestPlayer = highestPlayer;
            this.highestScore = highestScore;
        }
    }

    public static ArrayList<Player> BeginRegistration() {

        Scanner sc =  new Scanner(System.in);

        ArrayList<Player> listPlayers = new ArrayList<Player>();

		System.out.println("Welcome to Back to the Brink...");

		int numPlayers;
		do{
		    numPlayers = enterNumPlayers();
        }
		while(numPlayers<=1 || numPlayers>8);


		for(int i=0; i<numPlayers; i++) {

        listPlayers.add(enterPlayerName(listPlayers, i));

        }

		System.out.println("To begin game all players must roll the dice to see who starts first!");

        ArrayList<Integer> playerScores = new ArrayList<Integer>();

		for (int i = 0; i<numPlayers; i++) {

            System.out.println("Roll the dice, " + listPlayers.get(i).getName() + " by entering 'r' :");
            String roll = sc.nextLine();

        if(roll.toLowerCase().equals("r")) {
            int rollValue = dice.getRollValue();
            playerScores.add(rollValue);
            }
        }

        ListPlayersPlayer firstRoll = ListPlayersSameScore(listPlayers, playerScores);

		//System.out.println(firstRoll.highestPlayer.getName());

        Player highestScoring = firstRoll.highestPlayer;

        //System.out.println("Highest Scoring player: " + highestScoring.getName());
        int highestScore = firstRoll.highestScore;

        ArrayList<Player> rolledSameScore;

		if(firstRoll.players == null) {
            rolledSameScore = new ArrayList<Player>();
        }
		else {
            //@SuppressWarnings("unchecked")
            rolledSameScore = (ArrayList<Player>)firstRoll.players.clone();
        }

        // if players roll the same number ask them to roll again
		while(rolledSameScore.size() != 1) {
            System.out.println("The players who rolled the same score must roll again!\n");

            ArrayList<Integer> newScores = new ArrayList<Integer>();

            for (int i = 0; i<rolledSameScore.size(); i++) {
                System.out.println("Roll the dice, " + rolledSameScore.get(i).getName() + " by entering 'r' :");
                String roll = sc.nextLine();

                if(roll.equals("r")) {
                    int rollValue = dice.getRollValue();
                    newScores.add(rollValue);
                }
            }

            ListPlayersPlayer repeatRoll = ListPlayersSameScore(rolledSameScore, newScores);

            highestScoring = repeatRoll.highestPlayer;
            highestScore = repeatRoll.highestScore;
            rolledSameScore = repeatRoll.players;
        }

        // once the starting player has been decided order arraylist beginning with highest scoring player
		if(rolledSameScore.size() == 1) {
            ArrayList<Player> orderOfPlay = new ArrayList<Player>();


            //getting index of highest scoring player
            int index = -1;
            for(int i = 0; i<listPlayers.size();i++) {
                if(listPlayers.get(i).getName() == highestScoring.getName()) {
                    index = i;
                }
            }

            //add highest scoring first then add the rest of the players in the same order as previous
            for(int i = index; i<listPlayers.size(); i++) {
                orderOfPlay.add(listPlayers.get(i));
            }

            for(int i=0; i<index;i++) {
                orderOfPlay.add(listPlayers.get(i));
            }

            System.out.println(highestScoring.getName() + " has scored the highest with " + highestScore);

            System.out.println("\nThe order of player is as followed: \n");

            for (int i = 0; i<orderOfPlay.size(); i++) {
                System.out.println((i+1) + ". "+ orderOfPlay.get(i).getName());
            }

            listPlayers.clear();
            listPlayers.addAll(orderOfPlay);

            PlayerChoosePiece(listPlayers);
        }

		return listPlayers;
    }

    private static void PlayerChoosePiece(ArrayList<Player> listPlayers) {

        Scanner sc =  new Scanner(System.in);

        for(Player player : listPlayers){
            do{
                printAvailablePieces();

                System.out.println("Enter the number of the piece you would like, " + player.getName() + ":");
                int option = sc.nextInt();

                if(option >0 && option <=8){
                    if(!Board.pieces.get(option-1).getTaken()){
                        player.setPiece(Board.pieces.get(option-1));
                        Board.pieces.get(option-1).setTaken(true);
                        break;

                    }
                    else{
                        System.out.println("Piece already taken, please pick another");
                    }
                }
                else{
                    System.out.println("Invalid selection");
                }
            }
            while(true);
        }
    }

    private static void printAvailablePieces(){
        System.out.println("\nList of Pieces to choose from: ");
        for(Piece piece: Board.pieces){
            if(!piece.getTaken()){
                System.out.println(piece.getID() + ". " + piece.getName());
            }
        }
    }

    /**
     * Method to work out which player has rolled the highest score.
     * If two or more users roll the highest score they are all added to an arraylist to roll again.
     * @param listPlayers - list of players
     * @param playerScores - list of rolled scores in respective order
     * @return class of type ListPlayersPlayer(to be able to return 3 different variables from the method - ArrayList, Player, Score)
     */

    public static ListPlayersPlayer ListPlayersSameScore(ArrayList<Player> listPlayers, ArrayList<Integer> playerScores){

        Player highestScoring = null;
        int highestScore = 0;

        ArrayList<Player> rolledSameScore = new ArrayList<Player>();

        for(int i = 0; i< listPlayers.size(); i++) {

            if(playerScores.get(i) > highestScore) {
                highestScore = playerScores.get(i);
                highestScoring = listPlayers.get(i);
                // if new high score clear array and add new player to it
                rolledSameScore.clear();
                rolledSameScore.add(listPlayers.get(i));

            }
            // if another player rolls the same highscore add them to the arraylist too
            else if(playerScores.get(i) == highestScore) {
                rolledSameScore.add(listPlayers.get(i));
            }
        }
        //System.out.println(highestScoring.getName());
        //System.out.println(highestScore);
        return new ListPlayersPlayer(rolledSameScore, highestScoring, highestScore);


    }
    /**
     * Enter number of players to take part in the game
     * @return number of players enter by user
     */

    public static int enterNumPlayers() {

        System.out.println("Enter the number of players (2-8)");
        int numPlayers = 0;
        Scanner sc =  new Scanner(System.in);
        try {
            numPlayers = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input. Must be of type Integer.");
        }

        return numPlayers;

    }

    /**
     * Ask the user for their name, if name in invalid or already taken the user will be asked again
     * @param listPlayers - list of players so far who have entered their name
     * @param i - the player number
     * @return
     */
    public static Player enterPlayerName(ArrayList<Player> listPlayers, int i) {
        Scanner sc =  new Scanner(System.in);

        boolean validName = false;
        Player player = null;
        do {

            System.out.println("Enter Player " + (i+1) + "'s name: ");

            String name;
            if(sc.hasNextLine()) {
                name = sc.nextLine().trim();

                if (name == "") {
                    System.out.println("Nickname must not be empty!");
                }
                // check to make sure name if not already chosen
                else if(isNotNameTaken(listPlayers, name)) {
                    player = new Player(name);

                    validName = true;

                }
                else {
                    System.out.println("Nickname has already been taken, please enter another nickname!");
                }

            }
            else {
                System.out.println("Not a valid nickname, try again!");
            }

        }
        while(validName == false);

        return player;


    }

    /**
     * Method to check if nickname has already been taken
     * @param listOfPlayers
     * @param name
     * @return returning true if name is okay to use, false if name is already taken
     */
    public static boolean isNotNameTaken(ArrayList<Player> listOfPlayers, String name) {

        for(int i = 0; i < listOfPlayers.size();i++) {
            if(listOfPlayers.get(i).getName().equals(name)){
                return false;
            }
        }
        return true;

    }




}
