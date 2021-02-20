public class BackFromTheBrinkSquare extends Square{

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
		System.out.println(StdIO.printSquareLandedOn(player, this.getName()));
		if (player.getInventory().getMaterials() >= this.REQUIRED_MATERIALS && player.getInventory().hasCompleteBiome()) {
			System.out.println("Would you like to buy it? (y/n)");
			String response = StdIO.read();
			if (response.equals("y")) {
				BackFromTheBrink.setBftbWon();
			} else {
				System.out.println("Operation cancelled.");
			}
		} else {
			System.out.println("Unfortunately you do not meet the requirements to buy the BFTB square.");
			System.out.println("You need to own at least one biome and have a minimum of 1000 materials!");
		}
	}

	@Override
	public boolean isOwned() {
		return false;
	}
}

