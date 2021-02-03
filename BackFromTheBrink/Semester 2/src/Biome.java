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

    public String getBiomeName(){
        return name;
    }

    public ArrayList<Habitat> getAnimalHabitats(){
        return habitats;
    }
}