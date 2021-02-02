public class Travel extends Square {
    private final int AMOUNT_GAIN = 200;

    public Travel(String name, int position) {
        super(name, position);

    }

    public void execute(Player player)
    {
        player.increasePlayerMaterials(AMOUNT_GAIN);
    }
}
