package v1;

public class Player {
	
	private static int nextID = 1; 
	
	private int id;
	private String name;
	
	//private Inventory inventory;
	
	
	public Player(String name) {
		this.name = name;
		this.id = getNextID();
		//this.inventory = new Inventory();
		
	}
	
	public Player(Player p) {
		this.name = p.name;
		this.id = p.id;
	}
	
	public static int getNextID() {
		int id = nextID;
		nextID++;
		return id;
		
	}
	
	public String getName() {
		return name;
	}

}


