package stepDefinitions;

import org.testng.Assert;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import tests.TestBase;

public class CartSteps extends TestBase{

	HomePage homePage ;
	CartPage cartPage ;
	
	
	@When("User is adding {string} book to the Shopping cart page")
	public void user_is_navigated_to_shopping_cart_page(String bookName) {
		homePage = new HomePage(driver);
		homePage.clickOnAddToBasketBasedOnProductName(bookName);
		homePage.handleAdPopup();
		
		//cartPage.clickOnTheShoppingCartButton();
		
	}

	@Then("User is validated that the selected item is added to cart with its details successfully")
	public void user_is_validated_that_the_selected_item_is_added_to_cart_with_its_details_successfully() {
		cartPage  = new CartPage(driver);
		cartPage.productDetails();
		Assert.assertEquals(cartPage.getProductLink(),"Thinking in HTML");
		Assert.assertEquals(cartPage.getBookPrice(), "400.00");
		Assert.assertEquals(cartPage.getAttributeValue("value"),"1");
		cartPage.checkProductDetails();
        System.out.println(cartPage.getProductLink());
	}
	
	
	@When("User is Proceed To checkout")
	public void user_is_proceed_to_checkout() throws InterruptedException {
		cartPage  = new CartPage(driver);
		Thread.sleep(2000);
		
        cartPage.clickingOnCheckoutButton();
	}


	

}
