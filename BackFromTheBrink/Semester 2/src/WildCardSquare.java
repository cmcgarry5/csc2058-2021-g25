public class WildCardSquare extends Square{

	public WildCardSquare(String name, int position) {
		super(name, position);
	}

	@Override
	public boolean isOwned() {
		return false;
	}


	public void execute(Player player) {
		System.out.println(StdIO.printSquareLandedOn(player, this.getName()));
		WildCard wildCardDrawn = BackFromTheBrink.board.draw();
		System.out.println(StdIO.printDrawnWildCard(wildCardDrawn, player));
		wildCardDrawn.execute(player);
	}

}

