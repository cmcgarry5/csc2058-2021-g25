public class BackFromTheBrinkSquare extends Square{
	
	private int requiredMaterials;
	
	public BackFromTheBrinkSquare(int requiredMaterials) {
		super();
		this.requiredMaterials = requiredMaterials;
	}
	
	public int getRequiredMaterials() {
		return this.requiredMaterials;
	}
	
	public void execute(Player player) {
		/// implementation if player has enough materials and has a biome, player is prompted if they want to buy the square
	BackFromTheBrink.setBftbWon();
	}

}

