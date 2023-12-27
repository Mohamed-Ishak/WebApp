package resources;

import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	ExtentSparkReporter reporter ;
	static	ExtentReports extent ;
	
	@BeforeMethod
	public static ExtentReports getReport() { 
	String path = System.getProperty("user.dir")+"\\test-output\\Reports\\report.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Automation Practice web Report ");
	reporter.config().setDocumentTitle("Automation Practice Website");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Automation Tester", "Mohamed Ishak");
	
	return extent ;
	}
}
