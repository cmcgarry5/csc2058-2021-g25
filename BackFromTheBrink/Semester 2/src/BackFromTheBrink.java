import java.util.*;

public class BackFromTheBrink {

    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Player> outOfGame = new ArrayList<Player>();
    //static boolean begun = false;
    private static boolean bftbWon = false;
    //private static StdIO StdIO;
    static Board board;

    static Dice di = new Dice();

    static final String[] inSafariOptions = {"Try to Roll a double.", "Pay 50 materials to escape.", "Forfeit Game"};
    static Menu InSafariMenu = new Menu("In Safari Options:",inSafariOptions);

    static final String[] turnOptions = {"End turn", "Build on Habitat", "Initiate a trade", "Forfeit Game"};
    static Menu turnOptionsMenu = new Menu("Additional Turn Options:",turnOptions);

    public static void main(String[] args) {

        board = new Board();
        //StdIO = new StdIO();

        board.setupBoard();

        players = PlayerRegistration.BeginRegistration();
        //begun = true;

        // first player owns all habitats - testing
//        Player p1 = players.get(0);
//
//        for(Biome b : Board.biomes){
//            for(Habitat h: b.getHabitats()){
//                h.setOwner(p1);
//            }
//            p1.getInventory().addBiome(b);
//        }



        System.out.println("\nEach player starts with 1500 materials. \nIt is your aim to invest in Endangered habitats and save them by building zoo's and National Parks to help save them! \nThe first player to own a Biome of Habitats, have a total of x materials and land on the Back From the Brink Square will win! \nLet's Play!\n");

        while(getPlayersInGame(players) > 1 || !getBftbWon()) {
            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                playerTurnHandler(currentPlayer);
            }

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

    public static void playerTurnHandler(Player currentPlayer) {

            if (currentPlayer.isOutOfMaterials()){
                return;
            }

            System.out.println(currentPlayer.getName() + ", it's your turn!\n");

            //message to let player know their state at the start of their turn.

            System.out.println(StdIO.printPlayer(currentPlayer));

            if(currentPlayer.isInSafari()){

                currentPlayer.incrementRound();

                System.out.println("You are hiding in the Safari.");


                if(currentPlayer.getRoundsInSafari() == 3){

                    System.out.println("You haven't been able to roll a double in your previous two rounds.\nYou must now pay 50 materials to get rescued!");
                    currentPlayer.payFee(50);
                    //currentPlayer.setInSafari(false);

                    // ability to roll and move
                    System.out.println("You are no longer hiding in the safari.");
                    playerTurnHandler(currentPlayer);
                    return;

                }

                else{

                    if(currentPlayer.getInventory().hasWildCard()){

                        System.out.println("\nYou have a wildcard. Do you want to use it to escape from the safari immediately? (y/n) ");

                        String input;
                        do{
                            input = StdIO.read();
                        }
                        while(!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")));


                        if(input.equalsIgnoreCase("y")){
                            currentPlayer.useWildCard();

                            // roll and move
                            playerTurnHandler(currentPlayer);
                            return;
                        }
                        else{ //display menu if the user doesnt want to use their wildcard
                            displayInSafariOptionsMenu(currentPlayer);
                        }
                    }
                    else{ // display the menu if they user doesnt have a wildcard
                        displayInSafariOptionsMenu(currentPlayer);
                    }
                }
            }
            else {

                rollAndMove(currentPlayer, true);


                if (di.getIsDouble()) {
                    rollAndMove(currentPlayer, false);
                }

                if(!di.getIsSecondDouble()){

                    int option;
                    do{
                        turnOptionsMenu.display();
                        do{

                            option = StdIO.readInt();

                        }while(option <= 0|| option > turnOptionsMenu.getNumOptions());

                        ProcessTurnOption(option, currentPlayer);
                    }
                    while(option == 2 || option == 3);
                }


            }
            //Display current player info
            StdIO.printPlayer(currentPlayer);

            di.nextPlayer(); // reset Double "memory" of dice
        }


    private static void rollAndMove(Player currentPlayer, boolean firstRoll) {

        int rollValue = di.getRollValue();

        if(firstRoll){ //only executed on first roll
            move(currentPlayer, rollValue);
        }
        else{
            if (di.getIsSecondDouble()) {
                // go to safari
                currentPlayer.setInSafari(true);
                // move player to the spotted in the safari square
                System.out.println("\nUnlucky, you rolled two doubles in a row! ");
                System.out.println(currentPlayer.getName() + " is now being hunted by a deadly predator and is stuck in hiding in the safari!");
                currentPlayer.getPiece().move(Board.getSquare(10));
            }
            else{
                move(currentPlayer, rollValue);
            }
        }
    }

    private static void move(Player currentPlayer, int rollValue){

        //move around board
        Square currentSquare = currentPlayer.getPiece().move(rollValue);
        //check if player has passed travel and is not on travel square
        if(currentPlayer.getPiece().hasPassedTravelSquare() && currentPlayer.getPiece().getPos() != 0) {
            Travel.passedTravelSquare(currentPlayer);
        }
        currentSquare.execute(currentPlayer);

    }

    static void displayInSafariOptionsMenu(Player currentPlayer) {

        int option;
        do{
            InSafariMenu.display();
            option = StdIO.readInt();

        }
        while(option <= 0 || option> InSafariMenu.getNumOptions());

        ProcessInSafariOption(option, currentPlayer);
    }

    public static void ProcessInSafariOption(int option, Player currentPlayer) {
        switch(option) {
            case 1: tryDouble(currentPlayer);
            break;
            case 2: currentPlayer.payFee(50);
                System.out.println("You are no longer hiding in the safari.");
                playerTurnHandler(currentPlayer);
                break;
            case 4: forfeitGame(currentPlayer);
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

    private static void tryDouble(Player currentPlayer) {
        di.nextPlayer();
        int rollValue = di.getRollValue();
        if(di.getIsDouble()) {
            System.out.println("You rolled a double! You luckily escaped from the predator and escaped! \n");
            currentPlayer.setInSafari(false);
            move(currentPlayer, rollValue);
            //currentPlayer.getPiece().move(rollValue).execute(currentPlayer);
            //currentSquare.execute(currentPlayer);
            //playerTurnHandler(currentPlayer);
        }
        else {
            System.out.println("Unlucky, " + currentPlayer.getName() + ", the predator is still lurking nearby...\n");
        }
        di.nextPlayer();
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

        System.out.println(StdIO.printPlayer(bankruptPlayer));
        players.remove(bankruptPlayer);
        outOfGame.add(bankruptPlayer);
    }

    public static int ranking(Player player) {
        ArrayList<Player> rankings = new ArrayList<>();
        for (Player p : players) {
            rankings.add(p);
        }
        int rank = -1;
        int size = rankings.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (rankings.get(j).getRanking() < rankings.get(j+1).getRanking()) {
                    Player temp = rankings.get(j);
                    rankings.set(j, rankings.get(j+1));
                    rankings.set(j+1, temp);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (player == rankings.get(i)) {
                rank = i+1;
                break;
            } else {
                rank = -1;
            }
        }
        return rank;
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

            System.out.println(StdIO.PrintCompleteBiomes(currentPlayer));
//            for(int i = 0; i < currentPlayer.getInventory().getBiomes().size(); i++) {
//                Biome currentBiome = currentPlayer.getInventory().getBiomes().get(i);
//                //if player owns same number of  habitats as maximum number of habitats that a biome can have print them
//                if(currentBiome.isAllOwned()) {
//                    System.out.println(i + ". " + StdIO.printHabitats(currentBiome));
//                }
//            }

            //Ask player which biome they want to build a zoo
            System.out.println("\n\nWhich biome would you like to build a zoo on?");
            int ID = StdIO.readInt();
            Biome currentBiome = currentPlayer.getInventory().getBiome(ID);

//            System.out.println(currentBiome.getName());
//            System.out.println(currentBiome.getNumberOfHabitats());
//            System.out.println(currentBiome.getNumberOwnedHabitats());


            //Ask player which habitat they would like to build on and display cost (checkers for equal distribution)
            System.out.println("Which habitat would you like to build a zoo on?");
            int habitatID = StdIO.readInt();
            Habitat currentHabitat = currentPlayer.getInventory().getHabitat(currentBiome, habitatID);

            System.out.println(currentHabitat.getName());

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
                    return;
                }
            }

            if(zooCheck) {
                currentPlayer.deductMaterials(currentHabitat.getBuildCost());
                currentHabitat.addZoo();

                System.out.println("Successfully Built a zoo on " + currentHabitat.getName());
                System.out.println(StdIO.showMaterialsDeducted(currentPlayer,currentHabitat.getBuildCost()));

                //System.out.println(StdIO.printHabitats(currentBiome));
            }


        } else {
            System.out.println("You do not own any biomes therefore you can't build any zoos!");
            return;
        }
    }

    public static void trade(Player currentPlayer) {
        //print or display all players
        System.out.println(StdIO.printPlayersTrade(players, currentPlayer));
        //request user input to select player they want to trade with
        System.out.println("Select Player you want to trade with");
        int input = StdIO.readInt()-1;
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
        System.out.println(StdIO.printPlayer(selectedPlayer));
        //trade verification
        System.out.println("Are you sure you want to trade with this player? Type y for yes, n for no");
        //request user input
        String verification = StdIO.read().toLowerCase();
        if (verification.equals("y")){
            //ask user which biome they want to buy from
            System.out.println("Select the biome you would like to buy from");
            for(int i = 0; i < selectedPlayer.getInventory().getBiomes().size(); i++) {
                System.out.println(StdIO.printBiomes(selectedPlayer));
            }
            //request user input
            input = StdIO.readInt()-1;
            if(input >= selectedPlayer.getInventory().getBiomes().size() || input < 0) {
                System.out.println("This biome does not exist!");
                return;
            }
            Biome selectedBiome = selectedPlayer.getInventory().getBiomes().get(input);
            //request which habitat they want to buy from
            System.out.println("Which Habitat would you like to buy?");
            StdIO.printHabitats(selectedBiome);
            input = StdIO.readInt()-1;
            Habitat selectedHabitat = selectedBiome.getHabitats().get(input);
            //request user how much they want to pay for habitat
            System.out.println("How much would you like to pay for it?");
            int amount = StdIO.readInt();
            //request user2 if they want to accept
            System.out.println("Pass the remote controller to " + selectedPlayer.getName());
            String tradeRequest = "";
            tradeRequest += currentPlayer.getName() + " has requested to buy " + selectedHabitat.getName() +
                    " in the " + selectedBiome.getName() + " biome for " + amount;
            System.out.println(tradeRequest);
            System.out.println("\n\nWould you like to accept this trade? y for yes, n for no ");
            verification = StdIO.read();
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
