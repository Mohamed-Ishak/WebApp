package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import pages.HomePage;

public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	//public static RemoteWebDriver remoteDriver;
	HomePage homePage;
	ChromeOptions options;
	
	
	public WebDriver setupDriver(String webBrowser) throws IOException {

//		Properties prop = new Properties();
//		FileInputStream stream = new FileInputStream(
//				System.getProperty("user.dir") + "//src//test//java//resources//globalData.properties");
//		prop.load(stream);
//        String selectedBrowser = prop.getProperty("browser");
//
//		if (selectedBrowser.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//
//		} else if (selectedBrowser.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//
//		}
	//	DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability(CapabilityType.BROWSER_NAME, webBrowser);
		MutableCapabilities caps  = new MutableCapabilities();
		driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),caps);

		return driver;
	}
	
	@Parameters("browserName")
	@BeforeMethod(alwaysRun = true)	
	public HomePage launchApplication() throws IOException {

		driver = setupDriver("browserName");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://practice.automationtesting.in/");
		return homePage;
	}

	@AfterMethod(alwaysRun = true)	
	public void tearDownDriver() {
		if (driver != null)
			driver.quit();
	}
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	public String getScreenShot(String testCaseName , WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName + ".png");
		FileUtils.copyFile(source,file);
		return testCaseName;
	}

}
