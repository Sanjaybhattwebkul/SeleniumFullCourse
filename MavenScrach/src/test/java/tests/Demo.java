package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@Test
	public  void GetAllproducts() {
		// TODO Auto-generated constructor stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Phone",Keys.ENTER);
		List<WebElement> allProducts = driver.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
		allProducts.forEach(name->System.out.println(name.getText()));
		
	}

}
