package v1;

public class BackFromTheBrinkSquare extends Square{
	
	private int requiredMaterials;
	
	public BackFromTheBrinkSquare(int requiredMaterials) {
		this.requiredMaterials = requiredMaterials;
		
	}
	
	public int getRequiredMaterials() {
		return this.requiredMaterials;
	}
	
	public void execute(Player player) {
		/// implementation
	}

}

class Square{} // delete line after classes merged
