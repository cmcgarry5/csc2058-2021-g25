public class Travel extends Square {
    private final int AMOUNT_GAIN = 200;

    public Travel(String name, int position) {
        super(name, position);

    }

    @Override
    public boolean isOwned() {
        return false;
    }

    public void execute(Player player)
    {
        player.increasePlayerMaterials(AMOUNT_GAIN);
    }
}
