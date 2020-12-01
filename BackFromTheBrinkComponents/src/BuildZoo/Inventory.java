package BuildZoo;

import java.util.ArrayList;

public class Inventory {
private ArrayList<Biome> biomes;

public Inventory() {
	biomes = new ArrayList<Biome>();
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
}
