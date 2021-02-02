public class WildCardSquare extends Square{

	public WildCardSquare(String name, int position) {
		super(name, position);
	}

	public void execute(Player player, int function) {
		switch(function) {
			case 1: //Advance to Jaguar
				player.getPiece().move();
				break;
			case 2: //Advance to Blue Whale
				player.getPiece().move();
				break;
			case 3: //Advance to nearest river
				player.getPiece().move();
				break;
			case 4: //Advance to Travel Square
				player.getPiece().move();
				break;
			case 5: //Go back 3 square
				player.getPiece().move(-3);
				break;
			case 6: //Hide in safari
				player.getPiece().move()
			case 7: //receive escape from safari card
				player.getInventory().addWildCard();
			case 8: //Conservation grant +200 materials
				player.get
			case 9: //grounds maintenance, 40 per zoo, 75 per park
			case 10: //breeding program, 100 for each owned habitat
			case 11: //elected chairman pay 50
			case 12: //end of the month, pay 100
			case 13: //conservation fee refund collect 200
			case 14: //collect 50 off every player
			case 15: //use escape from safari card
		}
	}
}
