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
         String piece = "Piece: " + "\n" + player.getPiece().getName() + "\n" + "Position" +player.getPiece().getPos();
         String status = "Status: " + "\n" + player.isInSafari();
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
        int biomeIndex = 1;
        for (int i = 0; i < player.getInventory().getBiomes().size(); i++) {
            biomes += biomeIndex + ". " + player.getInventory().getBiomes().get(i).getBiomeName();
            biomes+= "\n";
            biomeIndex++;
            int habitatIndex = 1;
            for (int j = 0; j < player.getInventory().getBiomes().get(i).getAnimalHabitats().size(); j++) {
                biomes += "\n";
                biomes += habitatIndex + ". " + player.getInventory().getBiomes().get(i).getAnimalHabitats().get(j).getName();
                habitatIndex++;
            }
        }
        return biomes;
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
