public class SpottedByPredator extends Square{

    public SpottedByPredator(String newName, int nextPos) {
        super(newName, nextPos);
        System.out.println("Oh no! a predator has spotted you!\nGo into hiding!");
    	//player.getPiece().move(hiding);
    }

    @Override
    public boolean isOwned() {
        return false;
    }
}

