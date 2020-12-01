package Trade;

import MoveAroundBoard.Piece;

public class Player {

    private static int playerNum = 1;

    private int pNum;
	private String name;
	private Piece piece;
	private Inventory inventory;


	Player(String nameSet){

	    setName(nameSet);
	    pNum = getNextPlayerNum();
	    inventory = new Inventory();

	}

	private void setName(String nameSet) {
		this.name = nameSet;
	}

    private int getNextPlayerNum(){
        int pNum = playerNum;
        playerNum++;

        return pNum;
    }
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public String getName() {
		return name;
	}
	
	public Piece getPiece() {
		return this.piece;
	}

	public int getPlayerNum(){
	    return pNum;
    }

    public void setBalance(int qty){
		this.inventory.setMaterials(qty);
	}

	public Inventory getInventory() {
		return inventory;
	}







}
