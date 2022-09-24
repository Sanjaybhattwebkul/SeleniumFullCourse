package JavaCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Dimension {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\\\chrome-exe\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement ele=driver.findElement(By.cssSelector("a.blinkingText"));
		System.out.println(ele.getRect().getDimension().getHeight());
		System.out.println(ele.getRect().getDimension().getWidth());

	}

}