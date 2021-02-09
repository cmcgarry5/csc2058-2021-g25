import java.util.Scanner;

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
		System.out.println("You have landed on the Back From the Brink Square! Would you like to buy it? (y/n)");
		Scanner sc = new Scanner(System.in);
		String response = sc.nextLine();
		if (response.equals("y") && player.getInventory().getBiomes().size() > 0 && player.getInventory().getMaterials() >= this.REQUIRED_MATERIALS) {
			BackFromTheBrink.setBftbWon();
		} else {
			System.out.println("You do not have enough materials!!");
		}
	}

}

