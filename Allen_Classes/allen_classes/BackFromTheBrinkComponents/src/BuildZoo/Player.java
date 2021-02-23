package BuildZoo;

import java.util.ArrayList;

public class Player {

    private String name;
    private int material;
    private Inventory inventory;

    public Player(String nameSet){
        setName(nameSet);
        inventory = new Inventory();
    }

    private void setName(String nameSet) {
        this.name = nameSet;
    }


    public String getName() {
        return name;
    }
    
    public Inventory getInventory() {
    	return inventory;
    }

    public void setMaterial(int materials) {this.material = materials;}

    public int getMaterial() {return this.material;}

    public void setBiomes(ArrayList<Biome> biome) {this.inventory.setBiomes(biome);}

    public ArrayList<Biome> getBiomes() {return this.inventory.getBiomes();}
    
    public boolean checkPlayerResources(int amount) {
    	if (material >= amount) {
    		material -= amount;
    		return true;
    	} else {
    		return false;
    	}
    }

}
