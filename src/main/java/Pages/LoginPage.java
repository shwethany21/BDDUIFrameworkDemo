package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.BasePage;
import Utilities.ElementUtil;

public class LoginPage extends BasePage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	//2. By  Locators
	static By emailId = By.id("email");
	static By password = By.id("passwd");
	static By signInButton = By.id("SubmitLogin");
	static By forgotPasswordLink = By.linkText("Forgot your password?");

	// 3. Page actions: features(behavior) of the page in the form of methods
	public String getLoginPageTitle() {
		return elementUtil.doGetTitle();
	}

	public boolean isForgotLinkDisplayed() {
		return elementUtil.doIsDisplayed(forgotPasswordLink);
	}

	public void enterUserName(String username) {
		elementUtil.doSendKeys(emailId, username);
	}

	public void enterPassword(String pwd) {
		elementUtil.doSendKeys(password, pwd);
	}

	public void clickOnSignInButton() {
		elementUtil.doClick(signInButton);
	}

	public AccountsPage doLogin(String un, String pw) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pw);
		elementUtil.doClick(signInButton);
		return new AccountsPage(driver);
	}

}
