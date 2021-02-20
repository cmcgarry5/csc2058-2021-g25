public class BackFromTheBrinkSquare extends Square{

	private StdIO IO;
	private final int REQUIRED_MATERIALS;

	public BackFromTheBrinkSquare(String name, int pos, int requiredMaterials) {
		super(name, pos);
		this.REQUIRED_MATERIALS = requiredMaterials;
	}
	
	public int getRequiredMaterials() {
		return this.REQUIRED_MATERIALS;
	}
	
	public void execute(Player player) {
		// implementation if player has enough materials and has a biome, player is prompted if they want to buy the square
//		System.out.println(IO.printSquareLandedOn(player, this.getName()));
		System.out.println(IO.printSquareLandedOn(player, this.getName()));
		if (player.getInventory().getMaterials() >= REQUIRED_MATERIALS) {
			System.out.println("Would you like to buy it? (y/n)");
			String response = IO.read();
			if (response.equals("y") && player.getInventory().getBiomes().size() > 0 && player.getInventory().getMaterials() >= this.REQUIRED_MATERIALS) {
				BackFromTheBrink.setBftbWon();
			}
		} else {
			System.out.println("You do not have enough materials to buy the BFTB square!");
		}
	}

	@Override
	public boolean isOwned() {
		return false;
	}
}

