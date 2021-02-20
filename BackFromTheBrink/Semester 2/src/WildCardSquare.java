public class WildCardSquare extends Square{

	private StdIO IO = new StdIO();

	public WildCardSquare(String name, int position) {
		super(name, position);
	}

	@Override
	public boolean isOwned() {
		return false;
	}


	public void execute(Player player) {
		WildCard wildCardDrawn = BackFromTheBrink.board.draw();
		System.out.println(IO.printDrawnWildCard(wildCardDrawn, player));
		wildCardDrawn.execute(player);
	}

}

