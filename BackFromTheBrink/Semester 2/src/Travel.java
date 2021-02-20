public class Travel extends Square {
    private final int AMOUNT_GAIN = 200;
    private static StdIO IO = new StdIO();

    public Travel(String name, int position) {
        super(name, position);

    }

    @Override
    public boolean isOwned() {
        return false;
    }

    public void execute(Player player)
    {
        System.out.println(IO.printSquareLandedOn(player, this.getName()));
        player.increasePlayerMaterials(AMOUNT_GAIN);
        IO.printTravelSquare(player, AMOUNT_GAIN);
    }
}
