package v1;

public class AnimalHabitat implements Sqaure {
	private String animalName;
	private Player owner;
	private int numZoos;
	private int numNationalParks;
	private String biomeColour;
	private int investmentCost;
	private int fee_normal;
	private int fee_monopoly;
	private int fee_onehouse;
	private int fee_twohouse;
	private int fee_threehouse;
	private int fee_fourhouse;
	private int fee_NationalPark;
	private int Zoo_cost;
	
	public AnimalHabitat(String animalName, String biomeColour, int investCost, int f_n, int f_biome, int f_1z, int f_2z, int f_3z, int f_4z, int f_np, int zooCost)
	{
		this.animalName = animalName;
		this.biomeColour = biomeColour;
		this.investmentCost = investCost;
		this.fee_normal = f_n;
		this.fee_monopoly = f_biome;
		this.fee_onehouse = f_1z;
		this.fee_twohouse = f_2z;
		this.fee_threehouse = f_3z;
		this.fee_fourhouse = f_4z;
		this.fee_NationalPark = f_np;
		this.Zoo_cost = zooCost;
	
	}
	public String getName()
	{
		return animalName;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return biomeColour;
	}
	@Override
	public void addHouse() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeHouse() {
		// TODO Auto-generated method stub
		
	}

}
