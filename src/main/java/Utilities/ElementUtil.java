package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil extends BasePage {

	public WebDriver driver;
	WebDriverWait wait;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Constants.PAGE_LOAD_TIME_OUT);
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = getDriver().findElement(locator);
		} catch (Exception e) {
		}
		return element;
	}

	public void doSendKeys(By locator, String value ) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		String text = getElement(locator).getText();
		return text;
	}

	public  String doGetTitle() {
		String title = getDriver().getTitle();
		return title;
	}

	public boolean doIsDisplayed(By locator ) {
		return getElement(locator).isDisplayed();
	}

	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForVisibilityOf(By locator) {
		wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	public Boolean waitForIsTitle(String title ) {
		return  wait.until(ExpectedConditions.titleIs(title));
	}
	
	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void doActionClick(By locator) {
		Actions action = new Actions(getDriver());
		action.moveToElement(getElement(locator)).click().build().perform();
	}
	
	public void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public boolean doMouseHover(By locator) {
		boolean selected = getElement(locator).isSelected();
		if(!selected) {
			getElement(locator).click();
		} 
		return selected;
	}
	
	public WebDriver switchToFrame(String frame) {
		return getDriver().switchTo().frame(frame);
	}

}
