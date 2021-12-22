package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.ElementUtil;



public class ContactUsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	//1. Constructor of the Page class

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// By Locators
	private By contactUsLink = By.linkText("Contact Us");
	private By subjectHeading = By.xpath("//select[@id='id_contact' and @name ='id_contact']");
	private By email = By.id("email");
	private By orderref = By.id("id_order");
	private By messageText = By.id("message");
	private By successMessage = By.xpath("//p[@class='alert alert-success']");
	private By sendBtn = By.id("submitMessage");


	public void fillForm(String heading, String emailid, String orderReference, String message) throws Exception {
		Thread.sleep(3000);
		elementUtil.doSelectByVisibleText(subjectHeading, heading);
		elementUtil.doSendKeys(email, emailid);
		elementUtil.doSendKeys(orderref, orderReference);
		elementUtil.doSendKeys(messageText, message);
	}
	
	public void clickSend() {
		elementUtil.doClick(sendBtn);
	}

	public String getSuccessMessage() throws Exception {
		Thread.sleep(3000);
		return elementUtil.doGetText(successMessage);
	}

}
