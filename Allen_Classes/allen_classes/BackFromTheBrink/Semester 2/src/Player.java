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
        this.outOfMaterials = false;
        this.inSafari = false;
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
                System.out.println("You have been saved by the safari rescue team!");
                System.out.println("Roll the dice, " + player.getName() + " by entering 'r' :");
                String roll = sc.nextLine();
                String reRoll = "";

                while (!roll.toLowerCase().equals("r") || !reRoll.toLowerCase().equals("r")) {
                    System.out.println("Invalid input. You must roll the dice to continue... Please press 'r' to roll.");
                    reRoll = sc.nextLine();
                }

                if (roll.toLowerCase().equals("r") || reRoll.toLowerCase().equals("r")) {
                    int rollValue = BackFromTheBrink.di.getRollValue();
                    player.getPiece().move(rollValue);
                    System.out.println("You have successfully moved to " + BackFromTheBrink.board.getSquare(player.getPiece().getPos()));
                    BackFromTheBrink.di.nextPlayer();
                }
            }
            else {
                System.out.println("operation cancelled.");
            }
        } else {
            System.out.println("You do not own an Escape Safari Wildcard...");
        }
    }

    public void payFee(Player player, int amount) {
        boolean eligible = player.getInventory().checkPlayerMaterials(amount);
        if (eligible) {
            System.out.println("You have sufficient materials! Are you sure you want to pay the fee? (y/n)");
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();

            if (response.toLowerCase().equals("y")) {
                player.getInventory().deductPlayerMaterials(amount);
                System.out.println("Successfully paid fee!");
                System.out.println("Roll the dice, " + player.getName() + " by entering 'r' :");
                String roll = sc.nextLine();
                String reRoll = "";

                while (!roll.toLowerCase().equals("r") || !reRoll.toLowerCase().equals("r")) {
                    System.out.println("Invalid input. You must roll the dice to continue... Please press 'r' to roll.");
                    reRoll = sc.nextLine();
                }

                if (roll.toLowerCase().equals("r") || reRoll.toLowerCase().equals("r")) {
                    int rollValue = BackFromTheBrink.di.getRollValue();
                    player.getPiece().move(rollValue);
                    System.out.println("You have successfully moved to " + BackFromTheBrink.board.getSquare(player.getPiece().getPos()));
                    BackFromTheBrink.di.nextPlayer();
                }
            } else {
                System.out.println("operation cancelled.");
            }
        } else {
            System.out.println("You do not have sufficient materials to pay the fee...");
        }
    }

}