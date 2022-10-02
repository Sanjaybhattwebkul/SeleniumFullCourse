package seleium.MavenScrach;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlaceOrder {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		String productName = "ZARA COAT 3";
		
		LandingPage LandingPage = new LandingPage(driver);
		LandingPage.goTo();  // open browser/site
		CatalogProduct CatalogProduct= LandingPage.loginApplication("tom@example.com","Tom@1234"); // customer login and return obj of CatalogProduct class
		List<WebElement>cartProducts = CatalogProduct.getProductsList(); // get all products list in home page
		CatalogProduct.addProductToCart(productName); // Add product to cart		
		//goToCartPage function abstractComponenet class m or abstractComponenet class CatalogProduct m extend h   
		CartPage CartPage = CatalogProduct.goToCartPage(); // goToCartPage function CartPage ka object return kr ra h .		
		boolean isProductMatch = CartPage.veryfyDisplayProductToCart(productName);
		Assert.assertTrue(isProductMatch ); // Assertion hmesa main page m lgta h , kisi function a ander ni lgta h.
		checkoutPage checkoutPage = CartPage.goToCheckooutPage();
		checkoutPage.searchCountry("india");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");	
		confirmMessagePage confirmMessagePage = checkoutPage.submitOrder();
		String message = confirmMessagePage.getConfirmMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}
}
