import java.io.*;
import java.util.ArrayList;

public class StdIO {
//    public String printAllPlayers(ArrayList<Player> playerList) {
//        String completeList = "";
//        int playerIndex = 1;
//        for(int i = 0; i < playerList.size(); i++) {
//            completeList += playerIndex + ". " + printPlayer(playerList.get(i)) + "\n";
//            playerIndex++;
//        }
//        return completeList;
//    }

    public static String printPlayersTrade(ArrayList<Player> playerList, Player player) {
        String completeList = "";
        int playerIndex = 1;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i) != player) {
                completeList += playerIndex + ". " + printPlayer(playerList.get(i)) + "\n";
                playerIndex++;
            }
        }
        return completeList;
    }

     public static String printPlayer(Player player) {
         player.setRanking(player.calculateRank());
         String name = "Nickname: " + player.getName();
         String inventory = "--------Inventory--------";
         String materials = "Materials: " + "⚒" + player.getInventory().getMaterials();
         String biomes = "Biomes and Habitats: ";
         if(player.getInventory().getBiomes().size() == 0){
             biomes+="You currently dont own any Habitats";
         }
         for (int i = 0; i < player.getInventory().getBiomes().size(); i++) {
             biomes+= "\n";
             biomes +=  "ID: " + player.getInventory().getBiomes().get(i).getID() + " - "+ player.getInventory().getBiomes().get(i).getName();
                //biomes+= "\n";
             for (int j = 0; j < player.getInventory().getBiomes().get(i).getHabitats().size(); j++) {
                 biomes += "\n\t";
                 biomes += "ID: " + player.getInventory().getBiomes().get(i).getHabitats().get(j).getID() + " - "+ player.getInventory().getBiomes().get(i).getHabitats().get(j).getName();
             }
         }
         String wildcards = "Wildcards: ";
         if(player.getInventory().getWildCard().size()==0){
             wildcards+="You currently dont have an Wildcards in your inventory";
         }
         for(WildCard wildCard: player.getInventory().getWildCard()) {
             wildcards += "\n\t";
            wildcards += wildCard.getName();
         }
         String position = "--------Position---------";
         String rank = "";
         if (BackFromTheBrink.ranking(player) == 1) {
             rank = "1st";
         } else if (BackFromTheBrink.ranking(player) == 2) {
             rank = "2nd";
         } else if (BackFromTheBrink.ranking(player) == 3) {
             rank = "3rd";
         } else if (BackFromTheBrink.ranking(player) > 3 && BackFromTheBrink.ranking(player) <= 8) {
             rank = BackFromTheBrink.ranking(player) + "th";
         }
//         String piece = "Piece: " + player.getPiece().getName() + "\n" + "Square: " + BackFromTheBrink.board.getSquare(player.getPiece().getPos()).getName() + "\n" + "Position: " + player.getPiece().getPos();
         String piece = "Piece: " + player.getPiece().getName() + "\n" + "Square: " + BackFromTheBrink.board.getSquare(player.getPiece().getPos()).getName() + "\n" + "Ranking: " + rank;
         String status = "In Safari: ";
         if (player.isInSafari()){
             status += "Yes";
         }
         else{
             status += "No";
         }
         return name + "\n" + inventory + "\n" + materials + "\n" + biomes + "\n" + wildcards + "\n" + position + "\n" + piece + "\n" + status + "\n";
     }

    public static String printInventory(Player player) {
        String name = "Player: " + player.getName();
        String biomes = "Biomes and Habitats: ";
        if(player.getInventory().getBiomes().size() == 0){
            biomes+="You currently dont own any Habitats";
        }
        for (int i = 0; i < player.getInventory().getBiomes().size(); i++) {
            biomes +=  player.getInventory().getBiomes().get(i).getName();
            //biomes+= "\n";
            for (int j = 0; j < player.getInventory().getBiomes().get(i).getHabitats().size(); j++) {
                biomes += "\n\t";
                biomes += player.getInventory().getBiomes().get(i).getHabitats().get(j).getName();
            }
        }
        String wildcards = "Wildcards: ";
        if(player.getInventory().getWildCard().size()==0){
            wildcards+="You currently dont have an Wildcards in your inventory";
        }
        for(WildCard wildCard: player.getInventory().getWildCard()) {
            wildcards += "\n";
            wildcards += wildCard.getName();
        }
        return biomes + "\n" + wildcards;
    }

    public static String printBiomes(Player player) {
        String name = "Player: " + player.getName();
        String biomes = "Biomes and Habitats: ";
        for (int i = 0; i < player.getInventory().getBiomes().size(); i++) {
            biomes += i + ". " + player.getInventory().getBiomes().get(i).getName();
            biomes+= "\n";
            int habitatIndex = 1;
            printHabitats(player.getInventory().getBiomes().get(i));
        }
        return biomes;
    }

    public static String printHabitats(Biome biome) {
        String print = "";
        int habitatIndex = 1;
        Habitat currentHabitat = null;
        for(int i =0; i < biome.getHabitats().size(); i++) {
            currentHabitat = biome.getHabitats().get(i);
            print += habitatIndex + ". Name: " + currentHabitat.getName() + "\n";
            print += "Cost: ⚒" + currentHabitat.getCost() + "\n";
            print += "Number of Zoos built: " + currentHabitat.getNumberOfZoos() + "\n";
            print += "Has National Park: " + currentHabitat.hasNationalPark() + "\n";
            print += "Initial Fee: ⚒" + currentHabitat.getFee() + "\n";
            print += "1 Zoo Fee: ⚒" + currentHabitat.getFee1Zoo() + "\n";
            print += "2 Zoo Fee: ⚒" + currentHabitat.getFee2Zoo() + "\n";
            print += "3 Zoo Fee: ⚒" + currentHabitat.getFee3Zoo() + "\n";
            print += "4 Zoo Fee: ⚒" + currentHabitat.getFee4Zoo() + "\n";
            print += "National Park Fee: ⚒" + currentHabitat.getFeePark() + "\n";
            print += "Build Cost: ⚒" + currentHabitat.getBuildCost() + "\n";
            habitatIndex++;
        }
        return print;
    }

    public static String printDrawnWildCard(WildCard wildcard, Player player){
        String print = "";
        print += player.getName() + " has drawn " + wildcard.getName() + " wildcard";
        return print;
    }

    public static String printPlayerDecreasedMaterials(Player player, int amt){
        String print = "";
        print += player.getName() + "'s materials have been decreased by: ⚒" + amt;
        return print;
    }

    public static String printPlayerIncreasedMaterials(Player player, int amt){
        String print = "";
        print += player.getName() + "'s materials have been increased by: ⚒" + amt;
        return print;
    }

    public static String printTravelSquare(Player player, int amt) {
        String print = "";
        print += player.getName() + " has passed the TRAVEL SQUARE and their materials have been increased by: ⚒" + amt;
        return print;
    }

    public static String printSquareLandedOn(Player player, String name) {
        String print = "";
        print += player.getName() + " has landed on " + name + "!";
        return print;
    }

    public static String printHabitatLandedOn(Player player, String name, Biome biome) {
        String print = "";
        print += player.getName() + " has landed on " + name + " in the " + biome.getName() + "!";
        return print;
    }

    public static String printSafariSquare(Player player) {
        String print = "";
        print += "You go sightseeing around the Safari in search for exotic animals!";
        return print;
    }

    public static String showMaterialsIncreased(Player player, int amt) {
        String print = "";
        int newAmount = player.getInventory().getMaterials();
        int prevMaterials = player.getInventory().getMaterials() - amt;
        print += "\n"+ player.getName() +" now has ⚒" + newAmount + " from a previous ⚒" + prevMaterials;
        return print;
    }

    public static String showMaterialsDeducted(Player player, int amt) {
        String print = "";
        int newAmount = player.getInventory().getMaterials();
        int prevMaterials = player.getInventory().getMaterials() + amt;
        print += "\n"+ player.getName() +" now only has ⚒" + newAmount + " from a previous ⚒" + prevMaterials;
        return print;
    }

    public static String printRiverSquare(Player player, int amt, String name) {
        String print = "";
        print += "You must use up ⚒" + amt + " to cross " + name + "!";
        print += showMaterialsDeducted(player, amt);
        return print;
    }

    public static String printPayFee(Player player, int amt) {
        String print = "";
        print += "You must pay a fee of ⚒" + amt + "!" + "\n";
        print += showMaterialsDeducted(player, amt);
        return print;
    }

    public static String printOwnedHabitatPay(Player player, int amt, Habitat habitat) {
        String print = "\n";
        //print += "You have landed on " + habitat.getName() + " in the " + habitat.getBiome().getName() + "\n";
        if(habitat.hasNationalPark()) {
            print+= "This habitat has a National Park" + "\n";
        } else {
            print+= "This habitat has " + habitat.getNumberOfZoos() + " zoos\n";
        }
        print += player.getName() + " must pay an investment fee of " + amt + " materials to " + habitat.getOwner().getName() + "\n";
        print += showMaterialsDeducted(player, amt);
        print += showMaterialsIncreased(habitat.getOwner(), amt);

        return print;
    }

    public static String printBiomeAdded(Player player, String biomeName, int owned, int size, String habitatName) {
        String print = "";
        print += player.getName() + " has invested into the " + habitatName + " and now owns " + owned + " out of " + size + " habitats in the " + biomeName;
        return print;
    }

    //Take string input from player
    public static String read() {
        System.out.println("\nPlayer Input:");
        System.out.println(">");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String value = null;
        try{
            value = input.readLine();
        }
        catch (IOException ex) { ex.printStackTrace(); }
        return value;
    }

    //read int from player
    public static int readInt() {
        System.out.println("\nPlayer Input:");
        System.out.println(">");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String value = null;
        int intValue = 0;
        try{
            value = input.readLine();
            value = value.replaceAll("\\s", "");
            try {
                intValue= Integer.parseInt(value);
            }catch (NumberFormatException e) {
                System.out.println("Invalid Input! Not an Integer!");
            }
        }
        catch (IOException ex) { ex.printStackTrace(); }
        return intValue;
    }

    public static String PrintCompleteBiomes(Player player){
        String biomes = "Your completed Biomes:\n\n";
        biomes += "Biome ID -  Biome Name\n";
        biomes += "\t Habitat ID - Habitat Name - Number of Zoos built - Cost to build a Zoo\n";
        for (int i = 0; i < player.getInventory().getBiomes().size(); i++) {
            biomes+= "\n";
            if(player.getInventory().getBiomes().get(i).isAllOwned()){
                biomes +=  "ID: " + player.getInventory().getBiomes().get(i).getID() + " - "+ player.getInventory().getBiomes().get(i).getName();
                //biomes+= "\n";
                for (int j = 0; j < player.getInventory().getBiomes().get(i).getHabitats().size(); j++) {
                    biomes += "\n\t";
                    biomes += "ID: " + player.getInventory().getBiomes().get(i).getHabitats().get(j).getID() + " - "+ player.getInventory().getBiomes().get(i).getHabitats().get(j).getName() + " - " + player.getInventory().getBiomes().get(i).getHabitats().get(j).getNumberOfZoos() + " - ⚒" + player.getInventory().getBiomes().get(i).getHabitats().get(j).getBuildCost();
                }
            }

        }

        return biomes;

    }
}
