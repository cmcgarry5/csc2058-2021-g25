public class SpottedByPredator extends Square{
Square hiding = new Square("HIDING", 10);
    public SpottedByPredator(String newName, int nextPos) {
        super(newName, nextPos);
        System.out.println("Oh no! a predator has spotted you!\nGo into hiding!");
    	//player.getPiece().move(hiding);
    }
}

