public class Player {
    private String name;
    private Inventory inventory;
    private Piece piece;
    private boolean outOfMaterials;
    private boolean inSafari;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.outOfMaterials = true;
        this.inSafari = true;
    }

    public Player(Player p) {
        this.name = p.name;
        this.piece= p.piece;
        this.inventory = p.inventory;
    }

    private void checkMaterials() {

    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setOutOfMaterials(boolean outOfMaterials) {
        this.outOfMaterials = outOfMaterials;
    }

    public void setInSafari(boolean inSafari) {
        this.inSafari = inSafari;
    }

    public void trade(Player player) {
        //
    }

    public void deductMaterials(int amount) {
        this.inventory.removeMaterials(amount);
    }

    public void increasePlayerMaterials(int amount) {
        this.inventory.increasePlayerMaterials(amount);
    }

}
