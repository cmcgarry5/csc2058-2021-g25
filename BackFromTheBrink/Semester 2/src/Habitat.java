import java.util.Scanner;

public class Habitat extends Square{
	
	Scanner sc = new Scanner(System.in);
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
		
	}

	private void setBiome(Biome biome) {
		this.biome = biome;
	}

	public void execute(Player player) {
		if (ownedBy == null) {
			System.out.println("\nDo you want to invest in this Habitat? \nCost: "+ getCost() + " y/n\n");
			
			String answer = sc.nextLine();

			if (answer.equals("y")) {
				if (player.getInventory().getMaterials() >= cost) {
					player.getInventory().deductPlayerMaterials(cost);
					setOwner(player);
				}
			}
			else if (answer.equals("n")) {
				//next
			}

		}
		else if (player != ownedBy) {
			int feeToOwe = 0;
			if (getNumberOfZoos() == 0 && hasNationalPark() == false) {
				feeToOwe = getFee();
			}
			else if(getNumberOfZoos() == 1) {
				feeToOwe = getFee1Zoo();
			}
			else if(getNumberOfZoos() == 2) {
				feeToOwe = getFee2Zoo();
			}
			else if(getNumberOfZoos() == 3) {
				feeToOwe = getFee3Zoo();
			}
			else if(getNumberOfZoos() == 4) {
				feeToOwe = getFee4Zoo();
			}
			else if(hasNationalPark() == true) {
				feeToOwe = getFeePark();
			}
			
			System.out.println(player.getName() + " owes " + feeToOwe + " to " + getOwner().getName());
			if (player.getInventory().getMaterials() >= feeToOwe){
				player.deductMaterials(feeToOwe);
				getOwner().getInventory().increasePlayerMaterials(feeToOwe);
			}

			else {
				System.out.println("Player " + player.getName() + " is bankrupt ...");
			}
		}
		else {
			//next
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
		setNumZoos(getNumberOfZoos()+1);
	}
	
	public void removeZoo() {
		if(getNumberOfZoos() > 0)
			setNumZoos(getNumberOfZoos()-1);
		else {
			System.out.println("\nNum Zoos already 0\n");
		}
	}
	
	public void addNationalPark() {
		setPark(true);
		for (int i = 0; i < 4 ; i++) {
			removeZoo();
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
}
