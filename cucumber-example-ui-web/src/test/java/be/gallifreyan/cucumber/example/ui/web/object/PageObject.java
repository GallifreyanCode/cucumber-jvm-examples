package be.gallifreyan.cucumber.example.ui.web.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import be.gallifreyan.cucumber.example.ui.web.scenario.WebDriverFacade;


public abstract class PageObject {

	protected WebDriver webDriver;

	public PageObject() {
		tryCreateWebDriver();
	}

	protected <T extends PageObject> T openAs(String address, Class<T> pageClass) {
		open(address);
		return pageObjectInstance(pageClass);
	}

	private <T extends PageObject> T pageObjectInstance(Class<T> pageClass) {
		return PageFactory.initElements(webDriver, pageClass);
	}

	private void open(String address) {
		webDriver.navigate().to(address);
	}

	private void tryCreateWebDriver() {
		try {
			webDriver = new WebDriverFacade().getWebDriver();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}