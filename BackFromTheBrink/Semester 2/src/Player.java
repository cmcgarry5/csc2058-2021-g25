import java.util.Scanner;

public class Player {
    private String name;
    private Inventory inventory;
    private Piece piece;
    private boolean outOfMaterials;
    private int ranking;
    private boolean inSafari;
    private int roundsInSafari = 0;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.outOfMaterials = false;
        this.ranking = calculateRank();
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

    public int getRanking() {return ranking;}

    public void setRanking(int score) {this.ranking = score;}

    public void setInSafari(boolean inSafari) {

        if(!inSafari){
            roundsInSafari = 0; //once they escape from safari set their rounds back to 0
        }
        this.inSafari = inSafari;
    }

    public void deductMaterials(int amount) {
        this.inventory.deductPlayerMaterials(amount);
    }

    public void increasePlayerMaterials(int amount) {
        this.inventory.increasePlayerMaterials(amount);
    }

    public void useWildCard() {
        setInSafari(false);
        getInventory().returnWildCardToBoard();
        System.out.println("You have been saved by the safari rescue team!");


//        int size = player.getInventory().getWildCard().size();
//        boolean hasCard = false;
//        WildCard card = null;
//        for (int i = 0; i < size; i++) {
//            if (player.getInventory().getWildCard().get(i).getName().equals("Escape Safari Card")) {
//                hasCard = true;
//                card = player.getInventory().getWildCard().get(i);
//            } else {
//                hasCard = false;
//            }
//        }

//            Scanner sc = new Scanner(System.in);
//            String response = "";
//            do {
//                System.out.println("Are you sure you want to use your Escape Safari Wild Card? (y/n)");
//                response = sc.nextLine();
//            } while (!response.toLowerCase().equals("y") || !response.toLowerCase().equals("n"));
//
//            if (response.toLowerCase().equals("y")) {
//                player.setInSafari(false);
//                player.getInventory().removeCard(card);
//                System.out.println("You have been saved by the safari rescue team!");
//                String roll = "";
//                do {
//                    System.out.println("Roll the dice, " + player.getName() + " by entering 'r' :");
//                    roll = sc.nextLine();
//                } while (!roll.toLowerCase().equals("r"));
//
//                if (roll.toLowerCase().equals("r")) {
//                    int rollValue = BackFromTheBrink.di.getRollValue();
//                    player.getPiece().move(rollValue);
//                    //System.out.println("You have successfully moved to " + BackFromTheBrink.board.getSquare(player.getPiece().getPos()));
//                    BackFromTheBrink.di.nextPlayer();
//                }
//            }
//            else {
//                System.out.println("operation cancelled.");
//            }
        //}
//        else {
//            System.out.println("You do not own an Escape Safari Wildcard...");
//        }
    }

    public void payFee(int amount) {

        if (this.getInventory().checkPlayerMaterials(amount)) {

                this.getInventory().deductPlayerMaterials(amount);
                //System.out.println("Successfully paid fee!");
                setInSafari(false);
//                int rollValue = BackFromTheBrink.di.getRollValue();
//                player.getPiece().move(rollValue);
//                System.out.println(StdIO.printSquareLandedOn(player,BackFromTheBrink.board.getSquare(player.getPiece().getPos()).getName()) + "\n");
//                //System.out.println("You have successfully moved to " + BackFromTheBrink.board.getSquare(player.getPiece().getPos()));
//                BackFromTheBrink.di.nextPlayer();

        } else {
            System.out.println("You do not have sufficient materials to pay the fee...");
        }
    }

    public int calculateRank() {
        int numBiomes = this.getInventory().getBiomes().size();
        int numHabitats = 0;
        int numZoos = 0;
        for (int j = 0; j < this.getInventory().getBiomes().size(); j++) {
            numHabitats = this.getInventory().getBiomes().get(j).getNumberOwnedHabitats();
            for (int k = 0; k < numHabitats; k++) {
                if (this.getInventory().getBiomes().get(j).getHabitats().get(k).hasNationalPark()) {
                    numZoos = this.getInventory().getBiomes().get(j).getHabitats().get(k).getNumberOfZoos()+1;
                } else {
                    numZoos = this.getInventory().getBiomes().get(j).getHabitats().get(k).getNumberOfZoos();
                }
            }
        }
        return this.getInventory().getMaterials() + (numBiomes*1000) + (numHabitats*1000) + (numZoos*1000);
    }

    public void incrementRound() {
        roundsInSafari++;
    }

    public int getRoundsInSafari(){
        return roundsInSafari;
    }
}
