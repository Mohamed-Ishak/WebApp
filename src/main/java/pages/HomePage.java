package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class HomePage extends PageBase {

	public JavascriptExecutor js;

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h3[contains(text(),'Thinking in HTML')]")
	WebElement bookItem;

	@FindBy(xpath = "//h3[contains(text(),'Thinking in HTML')]")
	WebElement bookName;

	@FindBy(css = "ul[class='products'] h3")
	List<WebElement> productsName;

	@FindBy(xpath = "//a[contains(text(),'Add to basket')]")
	List<WebElement> addToCartBTN;

	@FindBy(css = "ul[id='main-nav'] li:last-of-type")
	WebElement shoppingCart;

	@FindBy(css = "a[class='woocommerce-LoopProduct-link'] ins span")
	WebElement price;

	@FindBy(xpath = "//div[@class='toprow']/div[@id='dismiss-button']")
	WebElement removeAdButton;

	@FindBy(css = "iframe[id='aswift_11']")
	WebElement popupFrame;

	@FindBy(tagName = "iframe")
	WebElement iframeTag;

	public void scrollDownToView(WebElement bookItem) {
	   scrollDownToView(bookItem);
	}

	public void scrollDownToView() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", bookItem);
	}

	public String getBookName() {
		return getText(bookName);

	}

	public List<WebElement> getAllProducts() {
		return productsName;
	}

	public void clickOnAddToCartBTN(int index) {
		clickOnListOfElements(addToCartBTN, index);
	}

	public String getPrice() {
		return getText(price);
	}

	public void clickOnShoppingCart() {
		clickOnElement(shoppingCart);
	}

	public void clickOnRemoveAdBTN() {
		clickOnRemoveBtn(removeAdButton);
	}

	public void handleAdPopup() {
		try {
			clickOnRemoveBtn(iframeTag);
		} catch (Exception e) {
			switchToCartPage();
		}
	}



	public void clickOnAddToBasketBasedOnProductName(String prodName) {
		for (int i = 0; i < productsName.size(); i++) {
			String name = productsName.get(i).getText();
			if (name.equalsIgnoreCase(prodName)) {
				addToCartBTN.get(i).click();
			}

		}

	}

}
