package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h3[contains(text(),'Billing Details')]")
	WebElement billingDetailsTxt;

	@FindBy(className = "woocommerce-billing-fields")
	WebElement billingFieldsContent;
	
	@FindBy(css = "div[class='woocommerce-billing-fields'] label")
	List<WebElement> formLabels;
	
	@FindBy(id = "billing_first_name")
	WebElement firstNameTxtField;

	@FindBy(id = "billing_last_name")
	WebElement lastNameTxtField;
	
	 
    public String checkThatBillingDetailsTextisExist() {
    	
    	return getText(billingDetailsTxt);
    }
    
    public boolean clickFirstNameField() {
    	if (firstNameTxtField.isDisplayed()) {
    		sendText(firstNameTxtField, "test");
        	return true;
		} else { 
         return false;
		}
    }
    
    public boolean clickLasttNameField() {
    	if (lastNameTxtField.isDisplayed()) {
        	return true;
		} else {
         return false;
		}
   

    } 
}
