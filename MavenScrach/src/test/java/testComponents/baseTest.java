package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleium.MavenScrach.LandingPage;

public class baseTest {
	
	public WebDriver driver;
	public LandingPage LandingPage;
	
	public WebDriver initlizeBrowser() throws IOException {
		
		// Get GlobalData using Properties class
		Properties prop = new Properties(); // create Properties() object for get GlobalData.properties file 
		FileInputStream files = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(files); // load the GlobalData.properties file.
		String browserName = prop.getProperty("browser"); // get the browser name from GlobalData.properties file
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("fireFox")) {
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver = new fireFox();
			
		}  else if(browserName.equalsIgnoreCase("edge")) {
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver = new fireFox();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {		
		driver = initlizeBrowser();
		LandingPage = new LandingPage(driver);
		LandingPage.goTo();  // open browser/site
		return LandingPage; // LandingPage object ko is liye return kiya kyuki loginApplication() function bhi call  ho ra hai.
	}
	
	@AfterTest(alwaysRun=true)
	public  void closeBrowser() {
		driver.close();
	}
}
