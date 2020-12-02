package Trade;

public class AnimalHabitat{
	private String name;
	private int numberOfZoos;
	private boolean nationalPark;
	private Biome biome;
	
	
	public AnimalHabitat(String habitatName, Biome biome) {
		this.nationalPark = false;
		this.numberOfZoos = 0;
		this.name = habitatName;
		this.biome = biome;
	}
	
	public String getAnimalHabitatName() {
		return name;
	}
	
	public int getNumberOfZoos() {
		return numberOfZoos;
	}
	
	public boolean addZoo() {
		numberOfZoos++;
		return true;
	}
	
	public boolean hasNationalPark() {
		return nationalPark;
	}
	
	public boolean addNationalPark() {
		nationalPark = true;
		return nationalPark;
				
	}

	public String getBiomeOfHabitat(){
		return biome.getName();
	}
	
}
