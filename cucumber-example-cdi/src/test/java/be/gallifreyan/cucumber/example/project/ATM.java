package be.gallifreyan.cucumber.example.project;

public class ATM {
	protected int money;

	public ATM(int money) {
		this.money = money;
	}

	public ATM() {}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int requestMoney(CreditCard creditCard, int amount) {
		if (!creditCard.isValid() || amount > money) {
			return 0;
		}
		
		amount = creditCard.getAccount().getMoney(amount);
		money = money - amount;
		return amount;
	}

}
