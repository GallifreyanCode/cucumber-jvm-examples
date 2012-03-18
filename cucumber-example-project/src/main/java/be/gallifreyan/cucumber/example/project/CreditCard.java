package be.gallifreyan.cucumber.example.project;

public class CreditCard {
	private boolean valid = true;
	private boolean inUse = false;
	protected Account account;
	
	public CreditCard() {}
	
	public CreditCard(Account account) {
		this.account = account;
	}

	public boolean isValid() {
		return valid;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void insertCard(){
		inUse = true;
	}
	
	public void returnCard(){
		inUse = false;
	}

	public boolean isInUse() {
		return inUse;
	}

}
