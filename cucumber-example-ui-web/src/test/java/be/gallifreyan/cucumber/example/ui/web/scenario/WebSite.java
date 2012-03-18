package be.gallifreyan.cucumber.example.ui.web.scenario;

import org.springframework.stereotype.Component;

import be.gallifreyan.cucumber.example.ui.web.object.HomePage;
import be.gallifreyan.cucumber.example.ui.web.object.PageObject;

@Component
public class WebSite extends PageObject {

	public HomePage openHomePage() {
		return openAs("http://localhost:9773/", HomePage.class);
	}
}
