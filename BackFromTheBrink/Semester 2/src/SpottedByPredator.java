public class SpottedByPredator extends Square{

    private static StdIO IO = new StdIO();

    public SpottedByPredator(String newName, int nextPos) {
        super(newName, nextPos);
        System.out.println("Oh no! a predator has spotted you!\nGo into hiding!");
    	//player.getPiece().move(hiding);
    }

    @Override
    public boolean isOwned() {
        return false;
    }

    public void execute(Player player) {
        player.getPiece().move(10);
        System.out.println(player.getName() + "is now being hunted by a deadly predator and is stuck in hiding in the safari!");
    }
}

