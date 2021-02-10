public class EscapeCard extends WildCard{

    public EscapeCard(String cardName) {
        super(cardName);
    }

    public void execute(Player player) {
        if(player.getInventory().getWildCard().size() > 0){
            Dice dice = new Dice();
            int moveVal = dice.getRollValue();
            player.getPiece().move(moveVal);
        }
    }
}