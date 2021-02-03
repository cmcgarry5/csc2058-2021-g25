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
		/// implementation if player has enough materials and has a biome, player is prompted if they want to buy the square
	BackFromTheBrink.setBftbWon();
	}

}

