import java.util.*;

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
        int countZoo = 0;
        int countPark = 0;

        if(getIsMaintenance()){
            ArrayList<Biome> biomesOwned = player.getInventory().getBiomes();
            for(int i = 0; i < biomesOwned.size(); i++){
                Biome currentBiome = biomesOwned.get(i);
                for (int j = 0; j < currentBiome.getNumberHabitats()-1; j++){
                    if (currentBiome.getHabitats().get(j).hasNationalPark() != true){
                        countZoo += currentBiome.getHabitats().get(j).getNumberOfZoos();
                    }
                    else{
                        countPark += 1;
                    }
                }
            }
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
