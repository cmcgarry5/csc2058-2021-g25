import java.util.ArrayList;

public class Inventory {
    private int materials;
    private ArrayList<Biome> biomes;
    private ArrayList<WildCard> wildCards;

    public Inventory() {
        this.biomes = new ArrayList<Biome>();
        this.wildCards = new ArrayList<WildCard>();
        this.materials = 1500;

        //wildCards.add(new EscapeCard("Escape Safari Card")); //testing escape from safari
    }

    public int getMaterials() {
        return materials;
    }
    public void setMaterials(int amount) {
        this.materials = amount;
    }

    public ArrayList<WildCard> getWildCard() {
        return wildCards;
    }

    public void addWildCard(WildCard wildCard) {
        wildCards.add(wildCard);
    }

    public ArrayList<Biome> getBiomes() {
        return biomes;
    }

    public String getBiomesInfo() { // UNFINISHED
        System.out.println("Biome Info");
        for (int i = 0; i < biomes.size(); i++) {
            System.out.println("\n" + biomes.get(i).getName() + "\n");

            for (int j = 0; j < biomes.get(i).getHabitats().size(); j++) {
                System.out.println(biomes.get(i).getHabitats().get(j) + " ");
            }
        }

        return null; // uncomplete
    }

    public void returnToBoard() {
        for (int i = 0; i < this.biomes.size(); i++) {
            for (int j = 0; j < this.biomes.get(i).getHabitats().size(); j++) {
                this.biomes.get(i).getHabitats().get(j).resetHabitat(); // reset zoos and park
                BackFromTheBrink.board.addAnimalHabitat(this.biomes.get(i).getHabitats().get(j));
            }
            this.biomes.get(i).resetHabitats();
        }
        for (int i = 0; i < this.wildCards.size(); i++) {
            if (this.wildCards.get(i).getName() == "Escape Safari Card") { // Only one card can be stored
                BackFromTheBrink.board.wildCards.add(this.wildCards.get(i));
            }
        }
        this.wildCards = null;
    }

    public void forfeitToPlayer(Player squareOwner) {
        int bankrupt_player_num_wildCards = this.getWildCard().size();
        ArrayList<WildCard> bankrupt_player_wildCards = this.getWildCard();
        int bankrupt_player_num_biomes = this.getBiomes().size();
        ArrayList<Biome> bankrupt_player_biomes = this.getBiomes();

        for (int i = 0; i < bankrupt_player_num_wildCards; i++) {
            squareOwner.getInventory().addWildCard(bankrupt_player_wildCards.get(i));
        }
        this.wildCards = null;
        for (int i = 0; i < bankrupt_player_num_biomes; i++) {
            squareOwner.getInventory().addBiome(bankrupt_player_biomes.get(i));
            for (int j = 0; j < bankrupt_player_biomes.get(i).getNumberOfHabitats(); j++) {
                squareOwner.getInventory().addHabitat(bankrupt_player_biomes.get(i), bankrupt_player_biomes.get(i).getHabitats().get(j));
                bankrupt_player_biomes.get(i).getHabitats().get(j).setOwner(squareOwner);
                this.biomes.get(i).getHabitats().get(j).resetHabitat(); // reset zoos and park for bankrupt player
            }
            this.biomes.get(i).resetHabitats(); // resets habitats for bankrupt player
        }
    }

    public void addBiome(Biome biome) {
        biomes.add(biome);
//        System.out.println("Biome added");
//        for (int i = 0; i < biomes.size(); i++) {
//            System.out.println(biomes.get(i).getName());
//        }
    }

    public void addHabitat(Biome biome, Habitat habitat) {
        for(int i = 0; i < biomes.size(); i++) {
            if (biomes.get(i) == biome) {
                biomes.get(i).addAnimalHabitat(habitat);
            }
        }
        if(!biomes.contains(biome)) {
            biome.addAnimalHabitat(habitat);
            biomes.add(biome);
        }
    }

    public void increasePlayerMaterials(int qty) {
        this.materials = this.materials + qty;
        //System.out.println("Materials successfully added!");
        //System.out.println("You now have: " + this.materials);
    }

    public void deductPlayerMaterials(int qty) {
        int diff = getMaterials() - qty;
        if (this.materials >= diff) {
            this.materials = this.materials - qty;
            //System.out.println("Materials successfully deducted!");
            //System.out.println("You now have: " + this.materials);
        } else {
            //System.out.println("You do not have enough materials!");
        }


    }

    public boolean checkPlayerMaterials(int qty) {
        if (materials >= qty) {
            //System.out.println("Sufficient materials!");
            return true;
        } else {
            //System.out.println("Insufficient materials!");
            return false;
        }
    }

//    public void removeCard() {
//        if(wildCards.size()>0){
//            wildCards.remove(0);
//        }
////        for (int i = 0; i < wildCards.size(); i++) {
////            if (wildCards.get(i).getName() == wildcard.getName()) {
////
////            }
////        }
//        System.out.println("Wild Card has been successfully removed.");
//    }
//
////	public void removeMaterials(int qty) { // Class Diagram???????????????
////
////	}

    public void updateInfo() {
        System.out.println("Materials: " + materials + "\n");

        System.out.println("Biomes" + "\n");
        for (int i = 0; i < biomes.size(); i++) {
            System.out.println(biomes.get(i).getName() + " ");
        }

        System.out.println("WildCards" + "\n");
        for (int i = 0; i < wildCards.size(); i++) {
            System.out.println(wildCards.get(i).getName() + " ");
        }
    }

    public boolean hasCompleteBiome(){

        for(Biome b: biomes){
            if(b.isAllOwned()){
                return true;
            }
        }
        return false;
    }

    public boolean hasWildCard() {
        if(wildCards.size() >= 1){
            return true;
        }
        return false;
    }

    public void returnWildCardToBoard() {
        if(hasWildCard()){
            Board.addWildCard(wildCards.remove(0)); //remove wild card from inventory and add back to board
        }
    }

    public Biome getBiome(int id) {

        Biome biome = null;

        for(Biome b : biomes){
            if(b.getID() == id){
                biome =  b;
            }
        }
        return biome;
    }

    public Habitat getHabitat(Biome currentBiome, int habitatID) {

        Habitat habitat = null;

            for(Habitat h : currentBiome.getHabitats()){
                if(h.getID() == habitatID){
                    habitat =  h;
                }
            }

        return habitat;
    }
}
