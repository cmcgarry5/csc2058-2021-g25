public class RiverSquare extends Square{
    private StdIO IO = new StdIO();
    private final int COST = 200;

    public RiverSquare(String name, int position) {
        super(name, position);
    }

    @Override
    public boolean isOwned() {
        return false;
    }


    public void execute(Player player, int amount) {
        System.out.println(IO.printSquareLandedOn(player, this.getName()));
        System.out.println(IO.printRiverSquare(player, this.COST, this.getName()));
        player.deductMaterials(amount);
    }

    public int getCOST() {
        return this.COST;
    }
}
