public class receiveMatWildCard extends WildCard {

    private int payment;
    private int paymentBreeding;
    private int paymentConservation;
    private boolean isBreedingSuccessful;
    private boolean isConservationScheme;

    public receiveMatWildCard(String cardName, boolean isBr, boolean isCon, int toPay) {
        super(cardName);
        setPayment(toPay);
        setBreedingSuccessful(isBr);
        setConservationScheme(isCon);
    }

    public void execute(Player player) {
        if(getIsBreedingSucc()){
            //To be completed
            int countHabitats = 0;
            setPaymentBreeding(countHabitats * 100);
            player.getInventory().increasePlayerMaterials(getPaymentBreedingAmount());
        }
        else if (getIsConservationSch()){
            int countPlayers = BackFromTheBrink.players.size();
            setPaymentBreeding(countPlayers*50);
            player.getInventory().increasePlayerMaterials(getPaymentConservationAmount());

            for(int i = 0; i < countPlayers; i++){
                Player currentPlayer = BackFromTheBrink.players.get(i);
                if (currentPlayer != player){
                    currentPlayer.getInventory().deductPlayerMaterials(getPaymentConservationAmount());
                }
            }
        }
        else {
            player.getInventory().increasePlayerMaterials(getPaymentAmount());
        }
    }

    private void setPayment(int toPay) {
        this.payment = toPay;
    }

    private void setPaymentBreeding(int toPay) {
        this.paymentBreeding = toPay;
    }

    private void setPaymentConservation(int toPay) {
        this.paymentConservation = toPay;
    }

    private void setBreedingSuccessful(boolean bool) {
        this.isBreedingSuccessful = bool;
    }

    private void setConservationScheme(boolean bool) {
        this.isConservationScheme = bool;
    }

    public int getPaymentAmount() {
        return this.payment;
    }

    public int getPaymentBreedingAmount() {
        return this.paymentBreeding;
    }

    public int getPaymentConservationAmount() {
        return this.paymentConservation;
    }

    public boolean getIsBreedingSucc(){
        return this.isBreedingSuccessful;
    }

    public boolean getIsConservationSch(){
        return this.isConservationScheme;
    }
}
