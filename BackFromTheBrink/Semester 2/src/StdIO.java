import java.io.*;

public class StdIO {
     public String printVar(Player player) {
         //name
         //inventory
            //mats
            //biomes
            //habitats
            //wildcards
         //piece
         //insafari status
         String name = "Name: " + player.getName();
         String inventory = "Inventory: ";
         String materials = "Materials: " + player.getInventory().getMaterials();
         String biomes = "Biomes and Habitats: " + player.getInventory().getBiomes().;
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
    public String printVar(Inventory inventory) {
        return "";
    }
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
}
