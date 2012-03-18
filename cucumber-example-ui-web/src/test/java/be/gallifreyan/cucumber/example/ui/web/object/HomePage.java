package be.gallifreyan.cucumber.example.ui.web.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

	@FindBy(id="page-heading")
	private WebElement pageHeading;

	public boolean hasPageHeading(String expectedTitle) {
		WebElement idfield = this.webDriver.findElement(By.id("page-heading"));
		System.out.println(idfield);
		return expectedTitle.equals(pageHeading.getText());
	}
}