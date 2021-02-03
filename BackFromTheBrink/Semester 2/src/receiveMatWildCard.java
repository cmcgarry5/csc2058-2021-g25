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
            //To be completed
            int countHabitats = 0;
            setPayBreed(countHabitats * 100);
            player.getInventory().increasePlayerMaterials(getPayBreedAmt());
        }
        else if (getIsConSch()){
            int countPlayers = BackFromTheBrink.players.size();
            setPayCon(countPlayers*50);
            player.getInventory().increasePlayerMaterials(getPayConAmt());

            for(int i = 0; i < countPlayers; i++){
                Player currentPlayer = BackFromTheBrink.players.get(i);
                if (currentPlayer != player){
                    currentPlayer.getInventory().deductPlayerMaterials(getPayConAmt());
                }
            }
        }
        else {
            player.getInventory().increasePlayerMaterials(getPayAmt());
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
