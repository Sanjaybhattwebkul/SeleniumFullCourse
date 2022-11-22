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

	public static boolean isDisplay;
	public static boolean isEnable;
	
	@Test
	public  void GetAllproducts() {
		// TODO Auto-generated constructor stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Phone",Keys.ENTER);
		
		//System.out.println("The 16th Products IS = "+ allProducts.get(15).getText());
		 isDisplay = driver.findElement(By.cssSelector("a[aria-label='Go to next page, page 2']")).isDisplayed();
		 isEnable = driver.findElement(By.cssSelector("a[aria-label='Go to next page, page 2']")).isEnabled();
		if(isDisplay && isEnable ) {
			PrintProductsName(driver);
		}
		
	}
	
	// print all products with pagination
	public static void PrintProductsName(WebDriver driver) {
		List<WebElement> allProducts = driver.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
		allProducts.forEach(name->System.out.println(name.getText()));
		driver.findElement(By.cssSelector("a[aria-label*='next page']")).click();
		if(isDisplay && isEnable ) {
			PrintProductsName(driver);
		}
	}

}
