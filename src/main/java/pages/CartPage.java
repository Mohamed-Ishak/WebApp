package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(css = "div[class='woocommerce']")
    public WebElement productContent;
	
	
	@FindBy(xpath = "//td[@class='product-name']/a")
	WebElement productLink;
	
	@FindBy(css = "ul[id='main-nav'] li:last-of-type")
	 WebElement shoppingCart ;
	
	@FindBy(css = "td[class='product-price'] span[class*='woocommerce-Price-amount']")
	WebElement productPrice ;
	
	@FindBy(css = "input[value='1']")
	WebElement productQuantity;
	
	@FindBy(css = "tr[class='cart_item'] td")
	List<WebElement> productDetailsRow;
	
	@FindBy(xpath = "//a[contains(@href,'/checkout')]")
	WebElement checkoutBTN;
	
	@FindBy(className = "checkout-button")
	WebElement checkoutButton;
	
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;
	
	
	@FindBy(tagName = "iframe")
	WebElement iframeTag ;
	
	public void productDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(productContent));
	}
	
   public String getProductLink() {
	  return getText(productLink);
   }
   
   public void clickOnTheShoppingCartButton() {
	   clickOnElement(shoppingCart);
   }
   
   public String getBookPrice() {
	   
	   String price = getText(productPrice);
	   String priceNum = price.split("₹")[1];
	   return priceNum;
   }
   
   public String getAttributeValue(String attName) {
	   
	  return productQuantity.getAttribute(attName);
   }
 
	public void checkProductDetails() {
		for (int i = 0; i < productDetailsRow.size(); i++) {
			System.out.println(productDetailsRow.get(i).getText());
		}
	}
	
	public void clickingOnCheckoutButton() {
		scrollDown();
		clickOnElement(checkoutBTN);
	}
	
//	public boolean verifyOrderIsDisplayed(String productName) {
//		Boolean matchedOrder = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
//		return matchedOrder ;
//	}
	
	public void clickOnProceedToCheckout() {
		scrollDown();
		locateElemntWithJSExecuter(checkoutButton);
	}

}
