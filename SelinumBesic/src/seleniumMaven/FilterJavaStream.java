package seleniumMaven;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterJavaStream {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome-exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		// Get all the records after search Rice  as A
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
	
		// Collect all data which contain Rice AS B
		List<WebElement> filteredList = veggies.stream()
				.filter(veggie -> veggie.getText().contains("Rice")).collect(Collectors.toList());
		
		// Check A== B 
		Assert.assertEquals(veggies.size(), filteredList.size()); 

	}

}
