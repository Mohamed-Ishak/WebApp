package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pages.CheckoutPage;
import tests.TestBase;

public class CeckoutSteps extends TestBase{
 
	CheckoutPage checkoutPage ;
	
	
	@Then("The Billing details form is displayed successfully")
	public void the_billing_details_form_is_displayed_successfully() {
     checkoutPage = new CheckoutPage(driver);
     Assert.assertEquals(checkoutPage.checkThatBillingDetailsTextisExist(), "Billing Details");  
     Assert.assertTrue(checkoutPage.clickFirstNameField());
     Assert.assertTrue(checkoutPage.clickLasttNameField());
	}
}
