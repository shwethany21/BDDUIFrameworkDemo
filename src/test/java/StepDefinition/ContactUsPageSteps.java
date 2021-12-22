package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import Pages.ContactUsPage;
import Utilities.BasePage;
import Utilities.ExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {

	private ContactUsPage contactUsPage = new ContactUsPage(BasePage.getDriver());
	ExcelUtil reader = new ExcelUtil();


	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		BasePage.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String contactus, Integer rowNumber) throws Exception {
		String path =System.getProperty("user.dir")+ "\\Configurations\\TestData.xlsx";
		List<Map<String,String>> testData = reader.getData(path, contactus);
		String heading = testData.get(rowNumber).get("subjectheading");
		String email = testData.get(rowNumber).get("email");
		String orderRef = testData.get(rowNumber).get("orderref");
		String message = testData.get(rowNumber).get("message"); 
		contactUsPage.fillForm(heading, email, orderRef, message);
	}	

	@When("user clicks on send button")
	public void user_clicks_on_send_button() throws Exception {
		contactUsPage.clickSend();
		Thread.sleep(3000);

	}

	@Then("it shows a successfull message {string}")
	public void it_shows_a_successfull_message(String expectedSuccessMessage) throws Exception {
		Assert.assertEquals(expectedSuccessMessage, contactUsPage.getSuccessMessage());
		Thread.sleep(3000);
		

	}

}
