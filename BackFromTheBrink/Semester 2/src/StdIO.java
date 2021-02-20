import java.io.*;
import java.util.ArrayList;

public class StdIO {
    public String printAllPlayers(ArrayList<Player> playerList) {
        String completeList = "";
        int playerIndex = 1;
        for(int i = 0; i < playerList.size(); i++) {
            completeList += playerIndex + ". " + printPlayer(playerList.get(i)) + "\n";
            playerIndex++;
        }
        return completeList;
    }

     public String printPlayer(Player player) {
         String name = player.getName();
         String inventory = "Inventory: ";
         String materials = "Materials: " + player.getInventory().getMaterials();
         String biomes = "Biomes and Habitats: ";
         for (int i = 0; i < player.getInventory().getBiomes().size(); i++) {
             biomes +=  player.getInventory().getBiomes().get(i).getBiomeName();
                biomes+= "\n";
             for (int j = 0; j < player.getInventory().getBiomes().get(i).getAnimalHabitats().size(); j++) {
                 biomes += "\n";
                 biomes += player.getInventory().getBiomes().get(i).getAnimalHabitats().get(j).getName();
             }
         }
         String wildcards = "Wildcards: ";
         for(WildCard wildCard: player.getInventory().getWildCard()) {
             wildcards += "\n";
            wildcards += wildCard.getName();
         }
         String piece = "Piece: " + "\n" + player.getPiece().getName() + "\n" + "Square: " + BackFromTheBrink.board.getSquare(player.getPiece().getPos()).getName() + "\n" + "Position: " + player.getPiece().getPos();
         String status = "In Safari: " + "\n";
         if (player.isInSafari()){
             status += "Yes";
         }
         else{
             status += "No";
         }
         return name + "\n" + inventory + "\n" + materials + "\n" + biomes + "\n" + wildcards + "\n" + piece + "\n" + status;
     }

    public String printInventory(Player player) {
        String name = "Player: " + player.getName();
        String biomes = "Biomes and Habitats: ";
        for (int i = 0; i < player.getInventory().getBiomes().size(); i++) {
            biomes +=  player.getInventory().getBiomes().get(i).getBiomeName();
            biomes+= "\n";
            for (int j = 0; j < player.getInventory().getBiomes().get(i).getAnimalHabitats().size(); j++) {
                biomes += "\n";
                biomes += player.getInventory().getBiomes().get(i).getAnimalHabitats().get(j).getName();
            }
        }
        String wildcards = "Wildcards: ";
        for(WildCard wildCard: player.getInventory().getWildCard()) {
            wildcards += "\n";
            wildcards += wildCard.getName();
        }
        return biomes + "\n" + wildcards;
    }

    public String printBiomes(Player player) {
        String name = "Player: " + player.getName();
        String biomes = "Biomes and Habitats: ";
        for (int i = 0; i < player.getInventory().getBiomes().size(); i++) {
            biomes += i + ". " + player.getInventory().getBiomes().get(i).getBiomeName();
            biomes+= "\n";
            int habitatIndex = 1;
            printHabitats(player.getInventory().getBiomes().get(i));
        }
        return biomes;
    }

    public String printHabitats(Biome biome) {
        String print = "";
        int habitatIndex = 1;
        Habitat currentHabitat = null;
        for(int i =0; i < biome.getHabitats().size(); i++) {
            currentHabitat = biome.getHabitats().get(i);
            print += habitatIndex + ". Name: " + currentHabitat.getName() + "\n";
            print += "Cost: " + currentHabitat.getCost() + "\n";
            print += "Number of Zoos built: " + currentHabitat.getNumberOfZoos() + "\n";
            print += "Has National Park: " + currentHabitat.getNumberOfZoos() + "\n";
            print += "Initial Fee: " + currentHabitat.getFee() + "\n";
            print += "1 Zoo Fee: " + currentHabitat.getFee1Zoo() + "\n";
            print += "2 Zoo Fee: " + currentHabitat.getFee2Zoo() + "\n";
            print += "3 Zoo Fee: " + currentHabitat.getFee3Zoo() + "\n";
            print += "4 Zoo Fee: " + currentHabitat.getFee4Zoo() + "\n";
            print += "National Park Fee: " + currentHabitat.getFeePark() + "\n";
            print += "Build Cost: " + currentHabitat.getBuildCost() + "\n";
            habitatIndex++;
        }
        return print;
    }

    public String printDrawnWildCard(WildCard wildcard, Player player){
        String print = "";
        print += player.getName() + " has drawn " + wildcard.getName() + " wildcard";
        return print;
    }

    public String printPlayerDecreasedMaterials(Player player, int amt){
        String print = "";
        print += player.getName()+ "'s materials have been decreased by: " + amt;
        return print;
    }

    public String printPlayerIncreasedMaterials(Player player, int amt){
        String print = "";
        print += player.getName()+ "'s materials have been increased by: " + amt;
        return print;
    }

    //Take string input from player
    public String read() {
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
    public int readInt() {
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
}
