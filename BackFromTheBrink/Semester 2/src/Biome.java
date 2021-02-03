import java.util.ArrayList;

public  class Biome {

    ArrayList<Habitat> habitats = new ArrayList<Habitat>();
    private String name;

    public Biome(String name, ArrayList habitats) {
        name = name;
        habitats = habitats;
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