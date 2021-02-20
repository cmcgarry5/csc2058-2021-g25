import java.util.ArrayList;

public class receiveMatWildCard extends WildCard {

    private int payment;
    private int paymentBreeding;
    private int paymentConservation;
    private boolean isBreedingSuccessful;
    private boolean isConservationScheme;

    public receiveMatWildCard(String cardName, boolean isBr, boolean isCon, int toPay) {
        super(cardName);
        setPayment(toPay);
        setBreedSucc(isBr);
        setConSch(isCon);
    }

    public void execute(Player player) {
        if(getIsBreedAmt()){
            ArrayList<Biome> biomesOwned = player.getInventory().getBiomes();
            int countHabitats = 0;
            for(int i = 0; i < biomesOwned.size(); i++){
                Biome currentBiome = biomesOwned.get(i);
                countHabitats += currentBiome.getNumberOwnedHabitats();
            }
            setPayBreed(countHabitats * 100);
            player.getInventory().increasePlayerMaterials(getPayBreedAmt());
            System.out.println(StdIO.printPlayerIncreasedMaterials(player, getPayBreedAmt()));
        }
        else if (getIsConSch()){
            int countPlayers = BackFromTheBrink.players.size();
            setPayCon((countPlayers-1)*50);

            for(int i = 0; i < countPlayers; i++){
                Player currentPlayer = BackFromTheBrink.players.get(i);
                if (currentPlayer != player){
                    currentPlayer.getInventory().deductPlayerMaterials(getPayConAmt());
                    System.out.println(StdIO.printPlayerDecreasedMaterials(currentPlayer, 50));

                }
            }

            player.getInventory().increasePlayerMaterials(getPayConAmt());
            System.out.println(StdIO.printPlayerIncreasedMaterials(player, getPayConAmt()));
        }
        else {
            player.getInventory().increasePlayerMaterials(getPayAmt());
            System.out.println(StdIO.printPlayerIncreasedMaterials(player, getPayAmt()));
        }
    }

    private void setPayment(int toPay) {
        this.payment = toPay;
    }

    private void setPayBreed(int toPay) {
        this.paymentBreeding = toPay;
    }

    private void setPayCon(int toPay) {
        this.paymentConservation = toPay;
    }

    private void setBreedSucc(boolean bool) {
        this.isBreedingSuccessful = bool;
    }

    private void setConSch(boolean bool) {
        this.isConservationScheme = bool;
    }

    public int getPayAmt() {
        return this.payment;
    }

    public int getPayBreedAmt() {
        return this.paymentBreeding;
    }

    public int getPayConAmt() {
        return this.paymentConservation;
    }

    public boolean getIsBreedAmt(){
        return this.isBreedingSuccessful;
    }

    public boolean getIsConSch(){
        return this.isConservationScheme;
    }
}
