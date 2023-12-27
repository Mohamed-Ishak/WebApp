package stepDefinitions;





import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import tests.TestBase;

public class ShoppingSteps extends TestBase {

	HomePage homePage;

	@Given("User is navigated to the automation practice website")
	public void user_is_navigated_to_the_automation_practice_website() {
		homePage = new HomePage(driver);

	}

	@When("User is scroll down to choose the desired item")
	public void user_is_scroll_down_to_choose_the_desired_item() {
		homePage.scrollDownToView();
	}

	@Then("The {string} book is displayed along with its price")
	public void thinking_in_html_book_is_displayed_along_with_its_price(String book) throws InterruptedException {
		Assert.assertEquals(homePage.getBookName(), book);
		homePage.clickOnAddToBasketBasedOnProductName(book);
		Thread.sleep(1000);
		homePage.handleAdPopup();
	}



}
