package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageBase {

	protected WebDriver driver;
    Actions actions ;
    JavascriptExecutor js ;
    
	public PageBase(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);

		PageFactory.initElements(driver, this);
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	public void clickOnListOfElements(List<WebElement> element,int index) {
		element.get(index).click();
	}
	
	public void sendText(WebElement element, String txt) {		
		element.sendKeys(txt);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public void clickEnterFromKeyboard() {
	 actions.sendKeys(Keys.ENTER);
	}
	

	
	public void clickOnRemoveBtn(WebElement element) {
		 actions.moveToElement(element).moveByOffset(10, 10).click().perform();
		}
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchBackToDefaultFrame() {
		driver.switchTo().defaultContent();
	}
	
	public void switchToCartPage() {
		String currentURL = driver.getCurrentUrl();
		String url = currentURL.split("/#")[0];
		driver.navigate().to(url+"/basket");
		
	}
	
	public void scrollDown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void locateElemntWithJSExecuter(WebElement element) {
		String javaScriptLocator = "document.getElementsByClassName('"+element+"')[0]";
		js = (JavascriptExecutor) driver ;
		WebElement ele = (WebElement) js.executeScript(javaScriptLocator);  
		ele.click();
	}

}
