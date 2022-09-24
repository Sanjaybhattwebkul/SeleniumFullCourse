package JavaCode;

import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\\\chrome-exe\\\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		WebDriver driver= new ChromeDriver(option);
		driver.get("https://www.spicejet.com/");
	}

}
