package StepDefinition;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Utilities.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {
	private BasePage basePage;
	private WebDriver driver;
	Properties prop;

	@Before
	public void getProperty() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
	}
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		}
		driver.quit();
	}
}
