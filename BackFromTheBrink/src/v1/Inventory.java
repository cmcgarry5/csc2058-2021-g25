package v1;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Sqaure> collectionOfSquare;
	private ArrayList<WildCard> collectionOfWildCards;
	
	private Resource materials; 
	
	public Inventory() {
		this.collectionOfSquare = new ArrayList<Sqaure>();
		this.collectionOfWildCards = new ArrayList<WildCard>();

		this.materials = new Resource(200);
		
	}
	
	public int getBalance() {
		return materials.getBalance();
	}

}
