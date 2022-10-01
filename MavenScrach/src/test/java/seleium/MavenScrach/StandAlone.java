package seleium.MavenScrach;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		String productName = "ZARA COAT 3";
		
		LandingPage object = new LandingPage(driver);
		object.goTo();  // open browser/site
		object.loginApplication("tom@example.com","Tom@1234"); // customer login
		
		CatalogProduct obj= new CatalogProduct(driver);
		List<WebElement>cartProducts = obj.getProductsList(); // get all products list in home page
		obj.addProductToCart(productName); // Add product to cart
		
	}

}
