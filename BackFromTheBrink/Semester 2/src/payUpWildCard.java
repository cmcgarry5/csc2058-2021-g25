public class payUpWildCard extends WildCard{

    private int feeToPayZoosAndParks;
    private int feeToPay;
    private boolean isMaintenance;

    public payUpWildCard(String cardName, boolean isMaint, int fee) {
        super(cardName);
        setFeeToPay(fee);
        setMaintenance(isMaint);
    }

    public void execute(Player player){
        if(getIsMaintenance()){
            //To be completed - biome needed
            int countZoo = 0;
            int countPark = 0;
            setFeeToPayZoosAndParks((40*countZoo) + (75*countPark));
            player.getInventory().deductPlayerMaterials(getFeeZoosAndParksAmount());
            return;
        }

        player.getInventory().deductPlayerMaterials(getFeeAmount());
    }

    private void setMaintenance(boolean bool){
        this.isMaintenance = bool;
    }

    private void setFeeToPay(int fee){
        this.feeToPay = fee;
    }

    private void setFeeToPayZoosAndParks(int fee){
        this.feeToPayZoosAndParks = fee;
    }

    public int getFeeAmount(){
        return this.feeToPay;
    }

    public int getFeeZoosAndParksAmount(){
        return this.feeToPayZoosAndParks;
    }

    public boolean getIsMaintenance(){
        return this.isMaintenance;
    }
}
