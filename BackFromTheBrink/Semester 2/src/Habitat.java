import java.util.ArrayList;

public class Habitat extends Square{
	private StdIO IO = new StdIO();
	private int cost;
	private int fee;
	private int numZoos;
	private int fee1Zoo;
	private int fee2Zoo;
	private int fee3Zoo;
	private int fee4Zoo;
	private int feePark;
	private Player ownedBy;
	private int buildCost;
	private boolean nationalPark;

	private Biome biome;
	
	public Habitat(String name, int pos, int cost, int fee, int fee1Zoo, int fee2Zoo, int fee3Zoo, int fee4Zoo, int feePark, int buildCost, Biome Biome) {
		super(name, pos);

		setCost(cost);
		setFee(fee);
		setFee1Zoo(fee1Zoo);
		setFee2Zoo(fee2Zoo);
		setFee3Zoo(fee3Zoo);
		setFee4Zoo(fee4Zoo);
		setFeePark(feePark);
		setBuildCost(buildCost);
		setBiome(Biome);

		ownedBy = null;
		
	}

	private void setBiome(Biome biome) {
		this.biome = biome;
	}

	public void execute(Player player) {
		if (ownedBy == null) {
			System.out.println("\nDo you want to invest in this Habitat? \nCost: "+ getCost() + " y/n\n");
			
			String answer = IO.read();

			if (answer.equals("y")) {
				if (player.getInventory().checkPlayerMaterials(cost)) {
					player.getInventory().deductPlayerMaterials(cost);
					setOwner(player);
					Habitat habitatBought = this;
					Biome copiedBiome = biome;
					ArrayList<Habitat> copiedHabitats = copiedBiome.getHabitats();
					for(int i = 0; i < player.getInventory().getBiomes().size(); i++){
						if(player.getInventory().getBiomes().get(i) == biome){
							player.getInventory().getBiomes().get(i).addAnimalHabitat(habitatBought);
						}
						else{
							for (int j = 0; j < copiedHabitats.size(); j++){
								copiedBiome.removeHabitat(copiedHabitats.get(j));
							}
							player.getInventory().addBiome(copiedBiome);
							player.getInventory().getBiomes().get(i).addAnimalHabitat(habitatBought);
						}
					}

				}
			}
			else if (answer.equals("n")) {
				return;
			}

		}
		else if(player != ownedBy) {
			if(hasNationalPark()) {
				if(player.getInventory().checkPlayerMaterials(feePark)) {
					player.deductMaterials(feePark);
				} else {
					player.setOutOfMaterials(true);
					return;
				}
			} else  {
				switch(getNumberOfZoos()) {
					case 0:
						if(player.getInventory().checkPlayerMaterials(getFee())) {
							player.deductMaterials(getFee());
						} else {
							player.setOutOfMaterials(true);
							return;
						}
						break;
					case 1:
						if(player.getInventory().checkPlayerMaterials(getFee1Zoo())) {
							player.deductMaterials(getFee1Zoo());
						} else {
							player.setOutOfMaterials(true);
							return;
						}
						break;
					case 2:
						if(player.getInventory().checkPlayerMaterials(getFee2Zoo())) {
							player.deductMaterials(getFee2Zoo());
						} else {
							player.setOutOfMaterials(true);
							return;
						}
						break;
					case 3:
						if(player.getInventory().checkPlayerMaterials(getFee3Zoo())) {
							player.deductMaterials(getFee3Zoo());
						} else {
							player.setOutOfMaterials(true);
							return;
						}
						break;
					case 4:
						if(player.getInventory().checkPlayerMaterials(getFee4Zoo())) {
							player.deductMaterials(getFee4Zoo());
						} else {
							player.setOutOfMaterials(true);
							return;
						}
						break;
				}
			}
		}
	}
	
	private void setFee(int qty) {
		this.fee = qty;
	}
	
	private void setCost(int qty) {
		this.cost = qty;
	}
	
	private void setBuildCost(int qty) {
		this.buildCost  = qty;
	}
	
	private void setNumZoos(int qty) {
		this.numZoos = qty;
	}
	
	private void setFee1Zoo(int qty) {
		this.fee1Zoo = qty;
	}
	
	private void setFee2Zoo(int qty) {
		this.fee2Zoo = qty;
	}

	private void setFee3Zoo(int qty) {
		this.fee3Zoo = qty;
	}
	
	private void setFee4Zoo(int qty) {
		this.fee4Zoo = qty;
	}
	
	private void setFeePark(int qty) {
		this.feePark = qty;
	}
	
	public void setOwner(Player player) {
		ownedBy = player;
	}
	
	public void setPark(boolean bool) {
		this.nationalPark = bool;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public int getFee() {
		return this.fee;
	}
	
	public int getNumberOfZoos() {
		return this.numZoos;
	}
	
	public int getFee1Zoo() {
		return this.fee1Zoo;
	}
	
	public int getFee2Zoo() {
		return this.fee2Zoo;
	}
	
	public int getFee3Zoo() {
		return this.fee3Zoo;
	}
	
	public int getFee4Zoo() {
		return this.fee4Zoo;
	}
	
	public int getFeePark() {
		return this.feePark;
	}
	
	public Player getOwner() {
		return this.ownedBy;
	}
	
	public int getBuildCost() {
		return this.buildCost;
	}

	
	public void addZoo() {
		if(biome.getNumberOfHabitats() == biome.getNumberOwnedHabitats()){
			setNumZoos(getNumberOfZoos()+1);
		}
		else{
			System.out.println("Player doesn't own all habitats in " + biome.getName());
		}
	}
	
	public void removeZoo() {
		if(getNumberOfZoos() > 0)
			setNumZoos(getNumberOfZoos()-1);
		else {
			System.out.println("\nNum Zoos already 0\n");
		}
	}
	
	public void addNationalPark() {
		if (getNumberOfZoos() < 4){
			System.out.println("Num Zoos less than 4");
		}
		else{
			setPark(true);
			for (int i = 0; i < 4 ; i++) {
				removeZoo();
			}
		}

	}
	
	public boolean hasNationalPark() {
		return this.nationalPark;
	}
	
	public String getHabitatInfo() {
		String info = "";
		info += getSquareInfo() + "Type: Habitat\n" + "Number Of Zoos: " + getNumberOfZoos() + "\nHas Park: " + hasNationalPark() + "\nOwned by: " + getOwner().getName();
		return info;
	}


	public Biome getBiome() {
		return this.biome;
	}

	public void resetHabitat() {
		this.numZoos = 0;
		this.nationalPark = false;
		this.ownedBy = null;
	}

	@Override
	public boolean isOwned() {

		if (getOwner() == null){
			return false;
		}
		return true;
	}

	public int getLandingOnFee() {

		if(numZoos == 1){
			return fee1Zoo;
		}else if(numZoos == 2){
			return fee1Zoo;
		}else if(numZoos == 3){
			return fee1Zoo;
		}else if(numZoos == 4){
			return fee1Zoo;
		}else if(nationalPark){
			return feePark;
		}
		else{
			return fee;
		}
	}
}
