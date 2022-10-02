package testComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	WebDriver driver;
	public void initlizeBrowser() throws IOException {
		
		// Get GlobalData using Properties class
		Properties prop = new Properties(); // create Properties() object for get GlobalData.properties file 
		FileInputStream files = new FileInputStream("C:\\Users\\DELL\\SeliniumFullCourse\\MavenScrach\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(files); // load the GlobalData.properties file.
		String browserName = prop.getProperty("browser"); // get the browser name from GlobalData.properties file
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("fireFox")) {
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver = new fireFox();
			
		}  else if(browserName.equalsIgnoreCase("edge")) {
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver = new fireFox();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();		
	}

	
}
