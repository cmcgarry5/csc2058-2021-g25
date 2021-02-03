public abstract class WildCard {
	private String name;
	
	public WildCard(String cardName) {
		this.name = cardName;
	}
	
	public String getName() {
		return name;
	}
	
	public void restoreCard(WildCard wildcard) {
		getCard();
		System.out.println("Wild card has been restored.");
	}
	
	public WildCard getCard() {
		return this;
	}

	public abstract void execute(Player player);
}
