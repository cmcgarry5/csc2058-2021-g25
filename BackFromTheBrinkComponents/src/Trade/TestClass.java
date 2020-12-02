package Trade;


import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    static Scanner sc = new Scanner(System.in);

	static ArrayList<Player> players = new ArrayList<Player>();
	static Player player1 = new Player("John");
    static Player player2 = new Player("Bob");
    static Player player3 = new Player("Harry");
    static Player player4 = new Player("Tom");

    static Player currentPlayer = player1;

    static Biome forest = new Biome("Forest", 2);
    static Biome jungle = new Biome("Jungle", 3);

    static AnimalHabitat jaguar = new AnimalHabitat("Jaguar", forest);
    static AnimalHabitat brownBear = new AnimalHabitat("Brown Bear", forest);
    static AnimalHabitat elephant = new AnimalHabitat("Asian Elephant", jungle);
    static AnimalHabitat orangutan = new AnimalHabitat("Orangutan", jungle);
    static AnimalHabitat gorilla = new AnimalHabitat("Cross River Gorilla", jungle);

    public static void main(String[] args) {

        System.out.println("\n**** FUNCTION TO DISPLAY PLAYER INFORMATION ****\n");

		players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        currentPlayer.setBalance(2000);
        currentPlayer.getInventory().addHabitat(elephant);

        player3.getInventory().addHabitat(jaguar);
        player3.getInventory().addHabitat(brownBear);
        player3.getInventory().addHabitat(gorilla);

        player4.getInventory().addHabitat(orangutan);


        int menuChoice;
        do {
            System.out.println("Options: (1) End Turn (2) Build Zoo (3) Trade");
            menuChoice = sc.nextInt();

            if (menuChoice == 1 || menuChoice == 2 || menuChoice == 3) break;
            else System.out.println("Not a valid option choice");
        }
        while(true);

        System.out.println("All players and their owned Animal Habitats: \n");
        for(int i = 0; i< players.size();i++){
            if(players.get(i).getName() != currentPlayer.getName()){
                System.out.println(players.get(i).getName());

                players.get(i).getInventory().displayAnimalHabitats();
            }
        }


        //
        System.out.println("Who would you like to trade with?");

        Player sellingPlayer = null;
        boolean found = false;

        for(int i = 0; i<players.size(); i++){
            if(players.get(i).getName() != currentPlayer.getName()){
                System.out.println(players.get(i).getPlayerNum() + ". " + players.get(i).getName());



            }
        }
        while (!found)
        {
            System.out.print("\nEnter player's number: ");
            int sPlayerNum = sc.nextInt();
            for (Player p: players)
            {
                if (p.getPlayerNum() == sPlayerNum && sPlayerNum != currentPlayer.getPlayerNum())
                {
                    sellingPlayer = p;
                    found = true;
                }
            }
            if(!found) System.out.println("You can not trade with this player. Also remember you cant trade with yourself!");
        }


        // current player choose which habitat they want to invest from the other player
        System.out.println("Select one of " + sellingPlayer.getName() + "'s Animal Habitats:");
        AnimalHabitat selling = selectAnimalHabitats(sellingPlayer);

        // current player enters how much they want to pay for it
        System.out.println("How much do you want to pay for the Habitat?");
        int value = getTradeValue();


        // ask selling player to confirm/ decline the trade
        System.out.println("Game play passed to " + sellingPlayer.getName()+ "\n");
        System.out.println(sellingPlayer.getName() + " would you like to trade " + selling.getAnimalHabitatName() + " to " + currentPlayer.getName() + " for " + value + " materials?");

        String sellingPlayerAns;

        sc.nextLine();

        while(true){
            System.out.println("\nTo confirm enter y, to decline enter n");
            sellingPlayerAns = sc.nextLine();

            if(sellingPlayerAns.toLowerCase().equals("y") || sellingPlayerAns.toLowerCase().equals("n")){
                break;
            }
        }

        System.out.println("Play returned back to " + currentPlayer.getName());

        // if confirmed update player information
        if(sellingPlayerAns.toLowerCase().equals("y")){

            System.out.println("Your trade has been accepted by " + sellingPlayer.getName());

            //deduct materials from currentPlayer
            if (currentPlayer.getInventory().loseMaterials(value)) {
                // Add Animal habitat to currentPlayer
                currentPlayer.getInventory().addHabitat(selling);

                System.out.println(currentPlayer.getName() + " has invested in " + selling.getAnimalHabitatName() + " from " + sellingPlayer.getName());
                System.out.println(currentPlayer.getName() + " now has a balance of " + currentPlayer.getInventory().getBalance() + " following a change of - " + value + " materials");

                //Remove Animal Habitat from Selling Player
                sellingPlayer.getInventory().removeHabitat(selling);
                //Add materials to Selling Player
                sellingPlayer.getInventory().gainMaterials(value);
            }

        }
        else System.out.println("Your trade has been declined by " + sellingPlayer.getName());

    }

    public static int getTradeValue(){

        while(true){
            int value = sc.nextInt();

            if (value >= 0){
                return value;
            }
            else System.out.println("Not valid");
        }
    }

    public static AnimalHabitat selectAnimalHabitats(Player p){
        //Display all Animal Habitats belonging to player
        if(!p.getInventory().displayAnimalHabitats()) return null;

        AnimalHabitat sellingHabitat = null;
        boolean hFound = false;

        while (!hFound)
        {
            System.out.print("\nEnter the animal habitats number: ");
            int sHabitatNum = sc.nextInt();

            if (sHabitatNum >= 0 && sHabitatNum < p.getInventory().getNumberHabitats())
            {
                sellingHabitat = p.getInventory().getHabitat(sHabitatNum);
                hFound = true;
            }

            if(!hFound) System.out.println("Not a valid Animal Habitat to trade for!");

        }
        return sellingHabitat;
    }

}
