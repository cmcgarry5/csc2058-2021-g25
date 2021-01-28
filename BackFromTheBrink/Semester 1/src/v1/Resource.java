package v1;

public class Resource {
	
	private int balance;
	

	
	public Resource(int balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;

	}

	public boolean gain(int amt) {
		
		balance += amt;
		
		return true;
		
	}
	
	public boolean lose(int amt) {
		
		if(amt < 0) {
			return false;
		}
		
		balance -= amt;
		
		return true;
	}
	
	public boolean isBankrupt() {
		if (balance <= 0) {
			return true;
		
		}
		return false;
	}
	
	public int getBalance() {
		return balance;
	}

}
