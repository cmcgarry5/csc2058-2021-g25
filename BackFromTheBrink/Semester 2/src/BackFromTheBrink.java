import java.util.*;

public class BackFromTheBrink {

    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Player> outOfGame = new ArrayList<Player>();
    private static boolean bftbWon = false;
    private static StdIO IO;
    static Board board;

    static Dice di = new Dice();

    static final String inSafariOptions[] = {"Try to Roll a double.", "Pay 50 materials to escape.", "Use a wildcard."};
    static Menu InSafariMenu = new Menu("In Safari Options:",inSafariOptions);

    static final String turnOptions[] = {"End turn", "Build on square", "Initiate a trade"};
    static Menu turnOptionsMenu = new Menu("Additional Turn Options:",turnOptions);

    public static void main(String[] args) {

        board = new Board();
        IO = new StdIO();

        board.setupBoard();

        players = PlayerRegistration.BeginRegistration();

        System.out.println("Lets Begin.....\n");

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
            Player currentPlayer = players.get(i);
            //check if player is in jail/safari
            System.out.println(currentPlayer.getName() + ", it is your turn!");

            //message to let player know their state at the start of their turn.

            if(currentPlayer.isInSafari()){
                //print out options

                System.out.println("You are hiding in the Safari.");

                int option;
                do{
                    InSafariMenu.display();
                    option = IO.readInt();

                }
                while(option <= 0 || option> InSafariMenu.getNumOptions());

                ProcessInSafariOption(option, currentPlayer);
            }
            else {

                //System.out.println("Roll the Dice to move around the board:");
                di.nextPlayer(); // reset Double "memory" of dice
                int rollValue = di.getRollValue();

                //move around board
                //moveAroundBoard(rollValue);
                currentPlayer.getPiece().move(rollValue);


                if (di.getIsDouble()) {
                    int rollValue2 = di.getRollValue();
                    // move around board
                    //moveAroundBoard(rollValue);
                    currentPlayer.getPiece().move(rollValue);
                }

                if (di.getIsSecondDouble()) {
                    // go to jail
                    currentPlayer.setInSafari(true);
                    // move player to the spotted in the safari square
                    currentPlayer.getPiece().move(board.getSquare(30));
                }

                //print out all options available
                //request input
                int option;
                do{
                    turnOptionsMenu.display();
                    do{

                        option = IO.readInt();

                    }while(option <= 0|| option > turnOptionsMenu.getNumOptions());

                    ProcessTurnOption(option, currentPlayer);

                }
                while(option != 1);

            }
        }
    }

    public static void ProcessInSafariOption(int option, Player currentPlayer) {
        switch(option) {
            case 1: di.tryDouble(currentPlayer);
            break;
            case 2: currentPlayer.deductMaterials(50);
            break;
            case 3: currentPlayer.useWildCard(currentPlayer);
            break;
        }
    }

    public static void ProcessTurnOption(int option, Player currentPlayer) {
        switch(option) {
            case 1: break;
            case 2: buildOnSquare();
            break;
            case 3: trade(currentPlayer);
            break;
        }
    }

    private static void buildOnSquare() {

        System.out.println("Building on owned square....");
    }

    public static void trade(Player currentPlayer) {
        //print or display all players
        IO.printAllPlayers(players);
        //request user input to select player they want to trade with
        int input = IO.readInt()-1;
        //print selected players habitats
        if(input >= players.size() || input < 0) {
            System.out.println("This player does not exist!");
            return;
        }
        Player selectedPlayer = players.get(input);
        IO.printPlayer(selectedPlayer);
        //trade verification
        System.out.println("Are you sure you want to trade with this player? Type y for yes, n for no");
        //request user input
        String verification = IO.read().toLowerCase();
        if (verification.equals("y")){
            //ask user which biome they want to buy from
            System.out.println("Select the biome you would like to buy from");
            for(int i = 0; i < selectedPlayer.getInventory().getBiomes().size(); i++) {
                IO.printBiomes(selectedPlayer);
            }
            //request user input
            input = IO.readInt()-1;
            if(input >= selectedPlayer.getInventory().getBiomes().size() || input < 0) {
                System.out.println("This biome does not exist!");
                return;
            }
            Biome selectedBiome = selectedPlayer.getInventory().getBiomes().get(input);
            //request which habitat they want to buy from
            System.out.println("Which Habitat would you like to buy?");
            input = IO.readInt()-1;
            Habitat selectedHabitat = selectedBiome.getAnimalHabitats().get(input);
            //request user how much they want to pay for habitat
            System.out.println("How much would you like to pay for it?");
            int amount = IO.readInt();
            //request user2 if they want to accept
            System.out.println("Pass the remote controller to " + selectedPlayer.getName());
            String tradeRequest = "";
            tradeRequest += currentPlayer.getName() + " has requested to buy " + selectedHabitat.getName() +
                    " in the " + selectedBiome.getName() + " biome for " + amount;
            System.out.println("Would you like to accept this trade? y for yes, n for no ");
            verification = IO.read();
            //transaction body
            if (verification.equals("y")) {
                selectedPlayer.increasePlayerMaterials(amount);
                currentPlayer.deductMaterials(amount);
                selectedBiome.removeAnimalHabitat(selectedHabitat);
                currentPlayer.getInventory().addHabitat(selectedBiome,selectedHabitat);
            }
        } else {
            System.out.println("Trade Cancelled");
            return;
        }
    }

}
