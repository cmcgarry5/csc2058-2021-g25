public class Travel {
    private int amountGain = 200;

    public void execute(Player player)
    {
        player.increasePlayerMaterials(amountGain);
    }
}
