package ViewPlayerInventory;

import java.util.ArrayList;

public class TestClass {

	static Player p1 = new Player("Liam");
	static Player p2 = new Player("Lance");
	static Player p3 = new Player("Ross");

	static ArrayList<AnimalHabitat> habitats = new ArrayList<AnimalHabitat>();
	static ArrayList<WildCard> wildCards = new ArrayList<WildCard>();

	static WildCard w1 = new WildCard("Hunting Squad");
	static WildCard w2 = new WildCard("Safari Trip");
	static AnimalHabitat h1 = new AnimalHabitat("Desesrt");
	static AnimalHabitat h2 = new AnimalHabitat("Jungle");

	public static void main(String[] args) {

		System.out.println("Player Name :" + p1.getName());

		// Cards are added to the users inventory
		wildCards.add(w1);
		wildCards.add(w2);
		habitats.add(h1);
		habitats.add(h2);
		// player name is displayed before their inventory
		p1.setWildCard(wildCards);
		p1.setAnimalHabitat(habitats);

		// System prints out players wild cards

		System.out.println("Your Wild Cards : ");
		for (int i = 0; i < wildCards.size(); i++) {
			System.out.println(wildCards.get(i).getWildCardName());
		}

		// System prints out players Habitats
		System.out.println("Your Habitats : ");
		for (int i = 0; i < habitats.size(); i++) {
			System.out.println(habitats.get(i).getAnimalHabitatName());
		}
	}

}
