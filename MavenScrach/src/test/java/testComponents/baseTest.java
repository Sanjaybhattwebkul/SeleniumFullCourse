package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@AfterMethod(alwaysRun=true)
	public  void closeBrowser() {
		driver.close();
	}
	
	// This function will get data from JSON file and return the data in from of HashMap 
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//read json file  to string
		String jsonContent = 	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		//String to HashMap- using Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		 return data;
		//{map, map}
	}
}


