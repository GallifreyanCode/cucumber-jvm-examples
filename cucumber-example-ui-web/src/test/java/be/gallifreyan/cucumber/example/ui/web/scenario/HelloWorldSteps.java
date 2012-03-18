package be.gallifreyan.cucumber.example.ui.web.scenario;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import be.gallifreyan.cucumber.example.ui.web.object.HomePage;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class HelloWorldSteps {
	
	@Autowired WebSite webSite;
	private HomePage homePage;
	
	@Given("I have a skeleton web application")
	public void haveSkeletonWebApplication() {
		assertNotNull(webSite);
	}

	@When("I open the home page")
	public void openHomePage() {
		homePage = webSite.openHomePage();
	}

	@Then("the page heading should be \"(.*)\"")
	public void shouldHavePageHeading(String expectedTitle) {
		System.out.println(expectedTitle);
		System.out.println(homePage.hasPageHeading(expectedTitle));
		assertTrue(homePage.hasPageHeading(expectedTitle));
	}
}
