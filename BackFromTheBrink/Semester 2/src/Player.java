import java.util.Scanner;

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

    public boolean isOutOfMaterials() {
        return outOfMaterials;
    }

    public boolean isInSafari() {
        return inSafari;
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

    public void deductMaterials(int amount) {
        this.inventory.deductPlayerMaterials(amount);
    }

    public void increasePlayerMaterials(int amount) {
        this.inventory.increasePlayerMaterials(amount);
    }

    public void useWildCard(Player player) {
        int size = player.getInventory().getWildCard().size();
        boolean hasCard = false;
        WildCard card = null;
        for (int i = 0; i < size; i++) {
            if (player.getInventory().getWildCard().get(i).getName().equals("Escape Safari Card")) {
                hasCard = true;
                card = player.getInventory().getWildCard().get(i);
            } else {
                hasCard = false;
            }
        }

        if (hasCard) {
            System.out.println("Are you sure you want to use your Escape Safari Wild Card? (y/n)");
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();

            if (response.toLowerCase().equals("y")) {
                player.getInventory().removeCard(card);
            }
            else {
                System.out.println("operation cancelled.");
            }
        } else {
            System.out.println("You do not own the Escape Safari Wildcard...");
        }
    }

}
