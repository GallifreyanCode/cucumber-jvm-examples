package be.gallifreyan.cucumber.example.spring.scenario;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;

import be.gallifreyan.cucumber.example.project.ATM;
import be.gallifreyan.cucumber.example.project.Account;
import be.gallifreyan.cucumber.example.project.CreditCard;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class SpringCucumberScenario {
	@Autowired private ATM atm;
	@Autowired private CreditCard creditCard;
	@Autowired private Account account;
	private int money;
	
	@Given("^the account balance is (\\d*)$")
    public void createAccount(int balance) {
		assertNotNull(account);
        account.setBalance(balance);
    } 
	
	@And("^the card is valid$")
    public void createCreditCard() {
		assertNotNull(creditCard);
		creditCard.setAccount(account);
    } 
	
	@And("^the machine contains (\\d*)$")
    public void createATM(int money) {
		assertNotNull(atm);
		atm.setMoney(money);
    } 
	
    @When("^the Account Holder requests (\\d*)$")
    public void requestMoney(int amount) {
        money = atm.requestMoney(creditCard, amount);
    }
    
    @Then("^the ATM should dispense (\\d*)$")
    public void checkMoney(int amount) {
        assertThat(money, is(amount));
    }
    
    @And("^the account balance should be (\\d*)$")
    public void checkBalance(int newBalance) {
        assertThat(newBalance, is(creditCard.getAccount().getBalance()));
    }
    
    @And("^the card should be returned$")
    public void cardShouldBeReturned() {
        assertFalse(creditCard.isInUse());
    }
}
