package BuildZoo;

import java.util.ArrayList;

public class Biome {
    private String biomeName;
    private ArrayList<AnimalHabitat> animalHabitats = new ArrayList<>();

    public Biome(String nameSet) { setName(nameSet); }

    private void setName(String nameSet) {
        this.biomeName = nameSet;
    }
    
    public String getName() {
        return biomeName;
    }
    
    public boolean addAnimalHabitat(String habitatName) {
    	animalHabitats.add(new AnimalHabitat(habitatName));
    	return true;
    }
    
    public ArrayList<AnimalHabitat> getAnimalHabitats() {
    	return animalHabitats;
    }
}
