import java.util.ArrayList;

public class Habitat extends Square{

	private int id;
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
	
	public Habitat(String name, int pos, int cost, int fee, int fee1Zoo, int fee2Zoo, int fee3Zoo, int fee4Zoo, int feePark, int buildCost, Biome Biome, int ID) {
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

		this.id = ID;
		
	}

	private void setBiome(Biome biome) {
		this.biome = biome;
	}

	public void execute(Player player) {
		System.out.println(StdIO.printHabitatLandedOn(player, this.getName(), this.biome));
		if (ownedBy == null) {
			System.out.println("\nWould you like to invest in the " + this.getName() + "?" + "\nCost: " + getCost() + " y/n\n");
			
			String answer = StdIO.read();

			if (answer.equals("y")) {
				if (player.getInventory().checkPlayerMaterials(cost)) {
					player.getInventory().deductPlayerMaterials(cost);
					setOwner(player);
					Habitat habitatBought = this;
					Biome copiedBiome = new Biome(biome.getID(), biome.getName(), biome.getNumberOfHabitats());
					for(int i = 0; i < player.getInventory().getBiomes().size(); i++) {
						if (player.getInventory().getBiomes().get(i).getID() == biome.getID()) {
							player.getInventory().getBiomes().get(i).addAnimalHabitat(habitatBought);
							return;
						}
					}
					copiedBiome.addAnimalHabitat(this);
					player.getInventory().addBiome(copiedBiome);
//					Biome addedBiome = null;
//					for(int i = 0; i < player.getInventory().getBiomes().size(); i++) {
//						if (player.getInventory().getBiomes().get(i).getName() == copiedBiome.getName()) {
//							player.getInventory().getBiomes().get(i).addAnimalHabitat(habitatBought);
//							addedBiome = player.getInventory().getBiomes().get(i);
//						}
//					}
					System.out.println(StdIO.printBiomeAdded(player, copiedBiome.getName(), copiedBiome.getNumberOwnedHabitats(), copiedBiome.getNumberOfHabitats(), habitatBought.getName()));
					System.out.println(StdIO.showMaterialsDeducted(player, getCost()));
				}
			}
			else if (answer.equals("n")) {
				System.out.println("You decided not to invest in " + getName());
				return;
			}

		}
		else if(player != ownedBy) {

			int feeToPay = getFee();

			if(hasNationalPark()){
				feeToPay = feePark;
			}else{
				switch(getNumberOfZoos()){
					case 0: feeToPay = getFee();
					break;
					case 1: feeToPay = getFee1Zoo();
					break;
					case 2: feeToPay = getFee2Zoo();
					break;
					case 3: feeToPay = getFee3Zoo();
					break;
					case 4: feeToPay = getFee4Zoo();
					break;
				}
			}

			if(player.getInventory().checkPlayerMaterials(feeToPay)) {
				player.deductMaterials(feeToPay);
				this.getOwner().increasePlayerMaterials(feeToPay);

				System.out.println(StdIO.printOwnedHabitatPay(player, feeToPay, this));

			}else{
				player.setOutOfMaterials(true);
			}

		}else if(player == getOwner()){
			System.out.println("\nYou own this Habitat!");
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
			if (numZoos < 4) {
				setNumZoos(getNumberOfZoos()+1);
			} else {
				System.out.println("Reached maximum number of zoos. Upgrade to National Park?");
			}
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
			setNumZoos(100);
			}
		}

	public boolean hasNationalPark() {
		return this.nationalPark;
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

		if (nationalPark) {
			return feePark;
		}else if(numZoos == 1){
			return fee1Zoo;
		}else if(numZoos == 2){
			return fee1Zoo;
		}else if(numZoos == 3){
			return fee1Zoo;
		}else if(numZoos == 4){
			return fee1Zoo;
		}
		else{
			return fee;
		}
	}

	public int getID() {
		return id;
	}
}
