import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserActvity {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome-exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// MAXIMIZE THE BROWSER
		driver.manage().window().maximize();
		
		// NAVIGATE TO OTHER URL
		driver.navigate().to("https://github.com/SanjuDeveloper/SeleniumFullCourse");
		
		// COME BACK TO URL
		driver.navigate().back();
		
		// GO FORWORD TO URL
		driver.navigate().forward();

	}

}
