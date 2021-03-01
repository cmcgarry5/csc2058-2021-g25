public class Special extends Square {

    private int fee;

    public Special(String name, int position, int fee) {
        super(name, position);
        this.fee = fee;
    }

    @Override
    public boolean isOwned() {
        return false;
    }

    public int getFee() {
//        switch (feeType) {
//            //River 200
//            //Electricity 150
//            //Water 150
//            //Hotel 150
//            //Conservation fee 200
//            case 1: return 200;
//            case 2: return 150;
//            case 3: return 150;
//            case 4: return 200;
//            case 5: return 200;
//            default: return 0;
//        }

        return fee;
    }

    //Use the method below as execute(player, getFee(3))
    public void execute(Player player) {
        System.out.println(StdIO.printSquareLandedOn(player, this.getName()));
        System.out.println(StdIO.printPayFee(player, fee));
        player.deductMaterials(fee);
    }

}
