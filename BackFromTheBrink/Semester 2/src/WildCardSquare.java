public class WildCardSquare extends Square{

	public WildCardSquare(String name, int position) {
		super(name, position);
	}

	@Override
	public boolean isOwned() {
		return false;
	}


	public void execute(Player player) {
		WildCard wildCardDrawn = BackFromTheBrink.board.draw();
		wildCardDrawn.execute(player);
	}

}

