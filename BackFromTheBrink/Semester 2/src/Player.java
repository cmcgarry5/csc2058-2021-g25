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
        if (this.inventory.getMaterials() == 0) {
            BackFromTheBrink.bankrupt(this, Board.getHabitat(this.getPiece().getPos()).getOwner());
        }
    }

    public void increasePlayerMaterials(int amount) {
        this.inventory.increasePlayerMaterials(amount);
    }

    public void useWildCard() {
        setInSafari(false);
        getInventory().returnWildCardToBoard();
        System.out.println("You have been saved by the safari rescue team!");
    }

    public void payFee(int amount) {

        if (this.getInventory().checkPlayerMaterials(amount)) {
                this.getInventory().deductPlayerMaterials(amount);
                setInSafari(false);
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