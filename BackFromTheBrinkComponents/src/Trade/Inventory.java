package Trade;

import BuildZoo.Biome;

import java.util.ArrayList;

public class Inventory {
private ArrayList<Biome> biomes;
private ArrayList<AnimalHabitat> habitats;
private int materials;

public Inventory() {

    biomes = new ArrayList<Biome>();
    habitats = new ArrayList<AnimalHabitat>();

}

public boolean addBiome(String nameSet) {
	biomes.add(new Biome(nameSet));
	return true;
}

public boolean setBiomes(ArrayList<Biome> biomes) {
	this.biomes = biomes;
	return true;
}

public ArrayList<Biome> getBiomes() {
	return biomes;
}


protected void setMaterials(int qty){
    this.materials = qty;
}

protected boolean loseMaterials(int qty){

	if(materials - qty > 0){
		materials -= qty;
		return true;
	}
	else return false;
}



public boolean addHabitat(AnimalHabitat aH){
    return habitats.add(aH);
}

public boolean displayAnimalHabitats(){

	if(habitats.size() == 0) return false;

	for(int i = 0; i<habitats.size(); i++){
		System.out.println(i + ". " + habitats.get(i).getAnimalHabitatName());
	}
	return true;

}

public int getNumberHabitats() {
		return habitats.size(); }

public AnimalHabitat getHabitat(int pos) {

	return habitats.get(pos);
}

protected boolean removeHabitat(AnimalHabitat selling) {
		return habitats.remove(selling);
}

protected boolean gainMaterials(int value) {
		this.materials += value;
		return true;
}

public int getBalance() {
	return materials;
	}
}
