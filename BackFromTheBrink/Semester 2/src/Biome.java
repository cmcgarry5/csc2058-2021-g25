import java.util.ArrayList;

public  class Biome {

    private ArrayList<Habitat> habitats = new ArrayList<Habitat>();
    private String name;
    private int numberOfHabitats;
    //private Player ownedBy = player1; dont think we need this as this is held in a persons inventtory


    public Biome(String biomeName, int numberOfHabitats, ArrayList<Habitat> habitats) {
        setBiomeName(biomeName);
        setNumberOfHabitats(numberOfHabitats);
        setHabitats(habitats);
    }

// broken
//    public boolean isOwned() {
//        boolean isOwned = false;
//
//        if (Inventory.getHabitats().contains(Biome.habitats)) {
//            isOwned = true;
//        }
//        return isOwned;
//    }

    public void setBiomeName(String nameSet) {
        this.name = nameSet;
    }

    public void setNumberOfHabitats(int num) {
        this.numberOfHabitats = num;
    }

    public void setHabitats(ArrayList<Habitat> nameSet) {
        this.habitats = nameSet;
    }

    public void addAnimalHabitat(Habitat habitat){
        habitats.add(habitat);
    }

    public boolean removeAnimalHabitat(Habitat habitat){
        if(habitats.remove(habitat)){
            return true;
        }
        return false;
    }

    public String displayAnimalHabitats() {
        System.out.println("Habitats");
        for (int i = 0; i < habitats.size(); i++) {
            System.out.println(habitats.get(i).getName() + " ");
        }

        return null; // uncomplete
    }

    public int getNumberHabitats() {
        return habitats.size();
    }

    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }

    public String getName() {
        return name;
    }

    public void removeHabitat(Habitat habitat) {
        for (int i = 0; i < habitats.size(); i++) {
            if (habitats.get(i).getName() == habitat.getName()) {
                habitats.remove(i);
            }
        }
        System.out.println("Habitat has been successfully removed.");
        for (int i = 0; i < habitats.size(); i++) {
            System.out.println(habitats.get(i).getName() + " ");
        }
    }

    public String getBiomeName(){
        return name;
    }

    public ArrayList<Habitat> getAnimalHabitats(){
        return habitats;
    }
}