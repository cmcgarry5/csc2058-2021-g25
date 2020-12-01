package BuildZoo;

public class AnimalHabitat {
	private String name;
	private int numberOfZoos;
	private boolean nationalPark;
	
	
	public AnimalHabitat(String habitatName) {
		this.nationalPark = false;
		this.numberOfZoos = 0;
		this.name = habitatName;
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
	
}
