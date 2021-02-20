import java.util.*;

public class BackFromTheBrink {

    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Player> outOfGame = new ArrayList<Player>();
    private static boolean bftbWon = false;
    private static StdIO IO;
    static Board board;

    static Dice di = new Dice();

    static final String[] inSafariOptions = {"Try to Roll a double.", "Pay 50 materials to escape.", "Use a wildcard."};
    static Menu InSafariMenu = new Menu("In Safari Options:",inSafariOptions);

    static final String[] turnOptions = {"End turn", "Build on Habitat", "Initiate a trade", "Forfeit Game"};
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

    public static void runSquareAction(Square currentSquare, Player currentPlayer){
        if(currentSquare instanceof Habitat){
            ((Habitat) currentSquare).execute(currentPlayer);
        }
        else if(currentSquare instanceof WildCardSquare){
            ((WildCardSquare) currentSquare).execute(currentPlayer);
        }

        else if(currentSquare instanceof Travel){
            // do
        }
        else if(currentSquare instanceof SpottedByPredator){
            ((SpottedByPredator) currentSquare).execute(currentPlayer);
        }
        else if(currentSquare instanceof BackFromTheBrinkSquare){
            ((BackFromTheBrinkSquare) currentSquare).execute(currentPlayer);
        }
        else if(currentSquare instanceof Special){
            ((Special) currentSquare).execute(currentPlayer, ((Special) currentSquare).getFee());
        }
        else if(currentSquare instanceof SafariSquare) {
            ((SafariSquare) currentSquare).execute(currentPlayer);
        }
    }

    public static void playerTurnHandler() {
        //print statements
        for (int i = 0; i < players.size(); i++) {

            Player currentPlayer = players.get(i);

            if (currentPlayer.isOutOfMaterials()){
                continue;
            }
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
                Square currentSquare = currentPlayer.getPiece().move(rollValue);

                // to be put in method or square class
                runSquareAction(currentSquare, currentPlayer);


                if (di.getIsDouble()) {
                    int rollValue2 = di.getRollValue();
                    // move around board
                    //moveAroundBoard(rollValue);
                    System.out.println("You rolled a double! Watch out! If you roll another double again you will get spotted by a predator!");
                    Square currentSquareDouble = currentPlayer.getPiece().move(rollValue2);
                    runSquareAction(currentSquareDouble, currentPlayer);

                }

                if (di.getIsSecondDouble()) {
                    // go to jail
                    currentPlayer.setInSafari(true);
                    // move player to the spotted in the safari square
                    System.out.println("Unlucky, you rolled two doubles in a row!");
                    currentPlayer.getPiece().move(Board.getSquare(30));
                }

                //Display current player info
                IO.printPlayer(currentPlayer);

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
                while(option == 2 || option == 3);
            }
        }
    }

    public static void ProcessInSafariOption(int option, Player currentPlayer) {
        switch(option) {
            case 1: di.tryDouble(currentPlayer);
            break;
            case 2: currentPlayer.payFee(currentPlayer, 50);
            break;
            case 3: currentPlayer.useWildCard(currentPlayer);
            break;
        }
    }

    public static void ProcessTurnOption(int option, Player currentPlayer) {
        switch(option) {
            case 1: break;
            case 2: buildZoo(currentPlayer);
            break;
            case 3: trade(currentPlayer);
            break;
            case 4: forfeitGame(currentPlayer);
            break;
        }
    }

    private static void forfeitGame(Player currentPlayer) {

        System.out.println(currentPlayer.getName() + " has forfeited the game!");
        System.out.println("All of the players habitats are now available to be invested in if landed upon!\n");

        currentPlayer.setOutOfMaterials(true);
        currentPlayer.getInventory().returnToBoard();
    }

    public static void buyHabitat(int position, Player player) { // NOT FINISHED!!!!!!!!!!!!!!! :)
        Habitat currentHabitat = (Habitat) (board.getSquare(position));
        int playerMaterials = player.getInventory().getMaterials();
        if (playerMaterials >= currentHabitat.getCost()) {
            player.getInventory().deductPlayerMaterials(currentHabitat.getCost());
            //player.getInventory().addHabitat();
        }
    }

    public static void bankrupt(Player bankruptPlayer, Player squareOwner) {
        int currentPosition = bankruptPlayer.getPiece().getPos();


        Habitat currentHabitat = (Habitat)(board.getSquare(currentPosition));
        if (currentHabitat.getOwner() == null) {
            bankruptPlayer.getInventory().returnToBoard();
        }
        else if (currentHabitat.getOwner() == squareOwner) {
            bankruptPlayer.getInventory().forfeitToPlayer(squareOwner);
        }

        System.out.println(IO.printPlayer(bankruptPlayer));
        players.remove(bankruptPlayer);
        outOfGame.add(bankruptPlayer);
    }

    private static void buildZoo(Player currentPlayer) {
        boolean ownsBiome = false;
        for(Biome biome: currentPlayer.getInventory().getBiomes()) {
            if(biome.isAllOwned()) {
                ownsBiome = true;
            }
        }
        //if they at least own one biome for loop will execute
        if(ownsBiome) {
            //display all owned biomes and habitats and zoos in that biome
            for(int i = 0; i < currentPlayer.getInventory().getBiomes().size(); i++) {
                Biome currentBiome = currentPlayer.getInventory().getBiomes().get(i);
                //if player owns same number of  habitats as maximum number of habitats that a biome can have print them
                if(currentBiome.isAllOwned()) {
                    System.out.println(i + ". " + IO.printHabitats(currentBiome));
                }
            }

            //Ask player which biome they want to build a zoo
            System.out.println("Which biome would you like to build a zoo on?");
            int biomeIndex = IO.readInt();
            Biome currentBiome = currentPlayer.getInventory().getBiomes().get(biomeIndex);

            //Ask player which habitat they would like to build on and display cost (checkers for equal distribution)
            System.out.println("Which habitat would you like to build a zoo on?");
            int habitatIndex = IO.readInt();
            Habitat currentHabitat = currentBiome.getHabitats().get(habitatIndex);

            //if current habitat is less than or equal to the rest of the habitats player can build
            boolean zooCheck = false;
            for(int i = 0; i < currentBiome.getHabitats().size();i++) {
                //Skips current habitat
                if(currentHabitat == currentBiome.getHabitats().get(i)) {
                    continue;
                }
                if (currentHabitat.getNumberOfZoos() <= currentBiome.getHabitats().get(i).getNumberOfZoos()) {
                    zooCheck = true;
                } else {
                    System.out.println("You cannot build a zoo here, all habitats must have an equal amount of zoos first!");
                    break;
                }
            }

            if(zooCheck) {
                currentPlayer.deductMaterials(currentHabitat.getBuildCost());
                currentHabitat.addZoo();
            }
            System.out.println("Successfully Built a zoo on " + currentHabitat.getName());
            IO.printHabitats(currentBiome);
        } else {
            System.out.println("You do not own any biomes therefore you can't build any zoos!");
            return;
        }
    }

    public static void trade(Player currentPlayer) {
        //print or display all players
        System.out.println(IO.printPlayersTrade(players, currentPlayer));
        //request user input to select player they want to trade with
        System.out.println("Select Player you want to trade with");
        int input = IO.readInt()-1;
        //print selected players habitats
        if(input >= players.size() || input < 0) {
            System.out.println("This player does not exist!");
            return;
        }
        Player selectedPlayer = players.get(input);
        //ensure player is selecting a player other than themselves
//        if(selectedPlayer.getName() == currentPlayer.getName()) {
//        	System.out.println("You cannot trade with yourself!");
//        	return;
//        }
        System.out.println(IO.printPlayer(selectedPlayer));
        //trade verification
        System.out.println("Are you sure you want to trade with this player? Type y for yes, n for no");
        //request user input
        String verification = IO.read().toLowerCase();
        if (verification.equals("y")){
            //ask user which biome they want to buy from
            System.out.println("Select the biome you would like to buy from");
            for(int i = 0; i < selectedPlayer.getInventory().getBiomes().size(); i++) {
                System.out.println(IO.printBiomes(selectedPlayer));
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
            IO.printHabitats(selectedBiome);
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
                selectedBiome.removeHabitat(selectedHabitat);
                currentPlayer.getInventory().addHabitat(selectedBiome,selectedHabitat);
            }
        } else {
            System.out.println("Trade Cancelled");
            return;
        }
    }
}
