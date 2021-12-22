package StepDefinition;

import org.junit.Assert;
import Pages.LoginPage;
import Utilities.BasePage;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private static String title;
	private LoginPage loginPage = new LoginPage(BasePage.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("User is in Login page");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Title of the Loginpage is: "+ title);

	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String ExpectedTitle) throws Exception {
		Thread.sleep(3000);
		Assert.assertTrue(title.contains(ExpectedTitle));

	}

	@Then("forgot your password link should be dispalyed")
	public void forgot_your_password_link_should_be_dispalyed() {
		Assert.assertTrue(loginPage.isForgotLinkDisplayed());

	}

	@When("user enters username {string}")
	public void user_enters_username(String username1) {
		loginPage.enterUserName(username1);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password1) {
		loginPage.enterPassword(password1);	
	}

	@When("user clicks on Login button")
	public void user_clicks_on_Login_button() {
		loginPage.clickOnSignInButton();
	}



}
