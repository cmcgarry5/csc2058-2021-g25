public class Travel extends Square {
    private final static int AMOUNT_GAIN = 200;

    public Travel(String name, int position) {
        super(name, position);

    }

    @Override
    public boolean isOwned() {
        return false;
    }

    public void execute(Player player)
    {
        System.out.println(StdIO.printSquareLandedOn(player, this.getName()) + " and has gained ⚒200");
        System.out.println(StdIO.showMaterialsIncreased(player, AMOUNT_GAIN));
        player.increasePlayerMaterials(AMOUNT_GAIN);
        StdIO.printTravelSquare(player, AMOUNT_GAIN);
    }

    //If player has passed travel square and not landed on it this method is called
    public static void passedTravelSquare(Player player) {
        System.out.println(StdIO.printTravelSquare(player, AMOUNT_GAIN));
        System.out.println(StdIO.showMaterialsIncreased(player, AMOUNT_GAIN));
        player.increasePlayerMaterials(AMOUNT_GAIN);
        player.getPiece().setPassedTravelSquare(true);
    }

}
