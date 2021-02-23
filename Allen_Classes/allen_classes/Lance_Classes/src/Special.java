public class Special {
    public int getFee(int feeType) {
        switch (feeType) {
            //River 200
            //Electricity 150
            //Water 150
            //Hotel 150
            //Conservation fee 200
            case 1: return 200;
            case 2: return 150;
            case 3: return 150;
            case 4: return 200;
            case 5: return 200;
            default: return 0;
        }
    }

    //Use the method below as execute(player, getFee(3))
    public void execute(Player player, int amount) {
        player.deductMaterials(amount);
    }

}
