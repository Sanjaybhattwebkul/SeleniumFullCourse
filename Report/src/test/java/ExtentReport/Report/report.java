package ExtentReport.Report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class report {
	ExtentReports extent;
	@BeforeTest
	public void Extent()
	{
		String path=System.getProperty("user.dir")+"\\reports\\abhay.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation");
		report.config().setDocumentTitle("Extent Report");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester","Abhay Goel");

	}
	
	
	
	
	
	@Test
	public void IntialDemo()
	{
		extent.createTest("IntialDemo");
		System.setProperty("webdriver.chrome.driver", "C:\\chrome-exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String title=driver.getTitle();
		Assert.assertEquals(title,"Rahul Shetty Academy - Login Page");
		extent.flush();
	}


}
