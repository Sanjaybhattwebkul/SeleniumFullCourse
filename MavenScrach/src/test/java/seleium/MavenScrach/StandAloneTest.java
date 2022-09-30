package seleium.MavenScrach;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("tom@example.com");
		driver.findElement(By.id("userPassword")).sendKeys("Tom@1234");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		//Optional<String> actualProduct = products.stream().map(product->product.findElement(By.cssSelector("b")).getText()).findFirst();
		
		//System.out.println("Product Nmae -: "+ actualProduct.isEmpty());
		
		WebElement actualProduct = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		actualProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click(); // agr 2 button h to 2 vala find hoga.
		
	}

}
