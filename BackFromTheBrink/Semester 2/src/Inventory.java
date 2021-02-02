import java.util.ArrayList;

public class Inventory {
    private int materials;
    private ArrayList<Biome> biomes;
    private ArrayList<WildCard> wildCards;
    private ArrayList<Habitat> habitats;

    public Inventory() {

    }

    public int getMaterials() {
        return materials;
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
            System.out.println("\n" + biomes.get(i).getBiomeName() + "\n");

            for (int j = 0; j < biomes.get(i).getAnimalHabitats().size(); j++) {
                System.out.println(biomes.get(i).getAnimalHabitats().get(j) + " ");
            }
        }
    }

    public void addBiome(Biome biome) {
        biomes.add(biome);
        System.out.println("Biome added");
        for (int i = 0; i < biomes.size(); i++) {
            System.out.println(biomes.get(i).getBiomeName());
        }
    }

    public void increasePlayerMaterials(int qty) {
        this.materials = this.materials + qty;
        System.out.println("Materials successfully added!");
        System.out.println("You now have: " + this.materials);
    }

    public void deductPlayerMaterials(int qty) {
        this.materials = this.materials - qty;
        System.out.println("Materials successfully deducted!");
        System.out.println("You now have: " + this.materials);
    }

    public String displayAnimalHabitats() {
        System.out.println("Habitats");
        for (int i = 0; i < habitats.size(); i++) {
            System.out.println(habitats.get(i).getHabitatName() + " ");
        }
    }

    public void removeHabitat(Habitat habitat) {
        for (int i = 0; i < habitats.size(); i++) {
            if (habitats.get(i).getHabitatName = habitat.getHabitatName) {
                habitats.remove(i);
            }
        }
        System.out.println("Habitat has been successfully removed.");
        for (int i = 0; i < habitats.size(); i++) {
            System.out.println(habitats.get(i).getHabitatName() + " ");
        }
    }

    public boolean checkPlayerMaterials(int qty) {
        if (materials >= qty) {
            System.out.println("Sufficient materials!");
            return true;
        } else {
            System.out.println("Insufficient materials!");
            return false;
        }
    }

    public int getNumberHabitats() {
        return habitats.size();
    }

    public void removeCard(WildCard wildcard) {
        for (int i = 0; i < wildCards.size(); i++) {
            if (wildCards.get(i).getName() == wildcard.getName()) {
                wildCards.remove(i);
            }
        }
        System.out.println("Habitat has been successfully removed.");
        for (int i = 0; i < wildCards.size(); i++) {
            System.out.println(wildCards.get(i).getName() + " ");
        }
    }

//	public void removeMaterials(int qty) { // Class Diagram???????????????
//		
//	}

    public void updateInfo() {
        System.out.println("Materials: " + materials + "\n");

        System.out.println("Biomes" + "\n");
        for (int i = 0; i < biomes.size(); i++) {
            System.out.println(biomes.get(i).getBiomeName() + " ");
        }

        System.out.println("WildCards" + "\n");
        for (int i = 0; i < wildCards.size(); i++) {
            System.out.println(wildCards.get(i).getName() + " ");
        }

        System.out.println("Habitats" + "\n");
        for (int i = 0; i < habitats.size(); i++) {
            System.out.println(habitats.get(i).getHabitatName() + " ");
        }
    }
}
