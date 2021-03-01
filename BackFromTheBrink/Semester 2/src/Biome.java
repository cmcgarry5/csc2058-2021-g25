import java.util.ArrayList;

public  class Biome {

    private ArrayList<Habitat> habitats = new ArrayList<Habitat>();
    private String name;
    private int id;

    private static int nextID = 1;
    private int numberOfHabitats;
    //private Player ownedBy = player1; dont think we need this as this is held in a persons inventtory


    public Biome(String biomeName, int numberOfHabitats) {
        setBiomeName(biomeName);
        setNumberOfHabitats(numberOfHabitats);
        id = nextID++;
    }

    public Biome(int id, String biomeName, int numberOfHabitats){
        setBiomeName(biomeName);
        setNumberOfHabitats(numberOfHabitats);
        this.id = id;
    }

    public void setBiomeName(String nameSet) {
        this.name = nameSet;
    }

    public void setNumberOfHabitats(int num) {
        this.numberOfHabitats = num;
    }

    public void addAnimalHabitat(Habitat habitat){
        habitats.add(habitat);
    }


    public int getNumberOfHabitats() {
        return numberOfHabitats;
    }

    public int getNumberOwnedHabitats() {
        return habitats.size();
    }

    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }

    public String getName() {
        return name;
    }

    public Habitat removeHabitat(Habitat habitat) {
        Habitat hab = null;

        for (int i = 0; i < habitats.size(); i++) {
            if (habitats.get(i).getName() == habitat.getName()) {
                hab = habitats.remove(i);
            }
        }
        System.out.println("Habitat has been successfully removed.");
        for (int i = 0; i < habitats.size(); i++) {
            System.out.println(habitats.get(i).getName() + " ");
        }

        return hab;
    }

    public boolean isAllOwned(){
        if (numberOfHabitats == getNumberOwnedHabitats()){
            return true;
        }
        else {
            return false;
        }
    }

    public void resetHabitats() {
        habitats.clear();
    }

    public int getID() {
        return id;
    }
}