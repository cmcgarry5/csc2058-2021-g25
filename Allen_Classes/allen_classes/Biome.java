package Conor_Classes;

import java.util.ArrayList;

public class Biome {
	
    Player player1 = new Player("xyz");
	
    private String biomeName;
    private int numberOfHabitats;
    private Player ownedBy = player1;
    private static ArrayList<Habitat> habitats;

    public Biome(String biomeName, int numberOfHabitats, ArrayList<Habitat> habitats) {
        setBiomeName(biomeName);
        setNumberOfHabitats(numberOfHabitats);
        setHabitats(habitats);
    }
    
    public void execute(Player player) {
    	
              if(isOwned()) {
        	     System.out.println("You own this biome");
              }
              
              else if(!isOwned()) {
            	  /*loop to check if any other players own biome
            	   * if yes, print "biome is owned by: player x"
            	   * if no, print "biome is not owned"
            	  */
              }
              else {
            	  //
              }
        	 
    }
    
    public boolean isOwned() {
    	boolean isOwned = false;
    	
    		if (Inventory.getHabitats().contains(Biome.habitats)) {
    	        isOwned = true;
             }
			return isOwned;
    	
    	
    }	

    public void setBiomeName(String nameSet) {
        this.biomeName = nameSet;
    }
    
    public void setNumberOfHabitats(int num) {
    	this.numberOfHabitats = num;
    }
    
    public void setHabitats(ArrayList<Habitat> nameSet) {
        this.habitats = nameSet;
    }
    

    public String getBiomeName() {
        return this.biomeName;
    }
    
    public ArrayList<Habitat> getHabitats(){
    	return this.habitats;
    }
    
    public int getNumberOfHabitats() {
    	return this.numberOfHabitats;
    }

    	
 

}
