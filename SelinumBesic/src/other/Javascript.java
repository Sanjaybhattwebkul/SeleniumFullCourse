package other;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Javascript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\chrome-exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('inputUsername').value='akgoel476@gmail.com'");
		js.executeScript("document.querySelector('.signInBtn').click()");

	}

}
