package StepDefinition;

import java.sql.Driver;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import Pages.AccountsPage;
import Pages.LoginPage;
import Utilities.BasePage;
import Utilities.ExcelUtil;
import java.util.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	ExcelUtil excel = new ExcelUtil();
	String sheetName ="contantus";
	String colName="email";
	private LoginPage loginPage = new LoginPage(BasePage.getDriver());
	private AccountsPage accountPage;


	@Given("user has already loggged in to the application")
	public void user_has_already_loggged_in_to_the_application(DataTable credTable) {
		List<Map<String, String>>	credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		BasePage.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage = loginPage.doLogin(userName, password);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title =accountPage.getAccountPageTitle();
		System.out.println("Page title is : "+ title);

	}

	@Then("user gets account section")
	public void user_gets_account_section(DataTable sectionsTable) {
		List<String> expectedAccountSectionList = sectionsTable.asList(); 
		System.out.println("Expected account section list: "+ expectedAccountSectionList);
		List<String> actualAccountSectionList = accountPage.getAccountSectionList();
		System.out.println("Actual account section list: "+ actualAccountSectionList);
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountPage.getAccountSectionCount() == expectedSectionCount);

	}

}
