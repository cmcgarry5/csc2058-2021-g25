public class RiverSquare extends Square{
    private final int COST = 200;

    public RiverSquare(String name, int position) {
        super(name, position);
    }

    @Override
    public boolean isOwned() {
        return false;
    }


    public void execute(Player player) {
        System.out.println(StdIO.printSquareLandedOn(player, this.getName()));
        System.out.println(StdIO.printRiverSquare(player, this.COST, this.getName()));
        player.deductMaterials(COST);
    }

    public int getCOST() {
        return this.COST;
    }
}
