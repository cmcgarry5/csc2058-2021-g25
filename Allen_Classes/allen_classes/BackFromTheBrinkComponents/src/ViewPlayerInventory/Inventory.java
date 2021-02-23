package ViewPlayerInventory;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<AnimalHabitat> habitats;
	private ArrayList<WildCard> wildCards;
	private int materials;

	public Inventory() {

		habitats = new ArrayList<AnimalHabitat>();
		wildCards = new ArrayList<WildCard>();
		
	}

	protected void setMaterials(int qty) {
		this.materials = qty;
	}

	protected boolean loseMaterials(int qty) {

		if (materials - qty > 0) {
			materials -= qty;
			return true;
		} else
			return false;
	}

	public boolean addHabitat(AnimalHabitat aH) {

		return habitats.add(aH);
	}

	public boolean displayAnimalHabitats() {

		if (habitats.size() == 0) {
			System.out.println("Has not invested in any Habitats to save yet!\n");
			return false;
		} else {

			for (int i = 0; i < habitats.size(); i++) {
				System.out.println("\t" + i + ". " + habitats.get(i).getAnimalHabitatName());
			}
			System.out.println(" ");
			return true;
		}

	}

	public int getNumberHabitats() {
		return habitats.size();
	}

	public AnimalHabitat getHabitat(int pos) {

		return habitats.get(pos);
	}

	protected boolean removeHabitat(AnimalHabitat selling) {
		return habitats.remove(selling);
	}
	
	public boolean addWildCards(WildCard name) {

		return wildCards.add(name);
	}


	public boolean displayWildCards() {

		if (habitats.size() == 0) {
			System.out.println("No wild cards in inventory!\n");
			return false;
		} else {

			for (int i = 0; i < wildCards.size(); i++) {
				System.out.println("\t" + i + ". " + wildCards.get(i).getWildCardName());
			}
			System.out.println(" ");
			return true;
		}

	}

	protected boolean gainMaterials(int value) {
		this.materials += value;
		return true;
	}

	public int getBalance() {
		return materials;
	}

	public void getInventory() {
		displayAnimalHabitats();
		displayWildCards();
		getBalance();
	}

}
