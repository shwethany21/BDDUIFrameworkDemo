package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ElementUtil;



public class AccountsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	//1. Constructor of the Page class

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	private By accountSections = By.cssSelector("div#center_column span");
	
	public int getAccountSectionCount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<>();
		List<WebElement> accountHeaderList = driver.findElements(accountSections);
		for(WebElement e: accountHeaderList ) {
			String text = e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		return accountList;
	}
	
	public String getAccountPageTitle() {
		return elementUtil.doGetTitle();
	}

}
