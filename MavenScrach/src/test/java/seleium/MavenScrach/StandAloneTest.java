package seleium.MavenScrach;

import java.time.Duration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// ISE RUN KRNE K LIYE JAVA COMPILER 1.8 HONA CHAHIYE NIMIMUM. property->java-compiler m click kr k change krna hota h.
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		String productName = "ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("tom@example.com");
		driver.findElement(By.id("userPassword")).sendKeys("Tom@1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		waite.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		// ADD Item to cart.
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));	
		WebElement actualProduct = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);		
		actualProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click(); // agr 2 button h to 2 vala find hoga.
		// Check if flash message showing or not after add product  into cart
		waite.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// check the loader is invisible or not
		waite.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		// VALIDATE IF THE ADDED ITEM IS PRESNT IN CART PAGE OR NOT.
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		// Match added product with each item of cart . steam() k sath filter ki jgh anyMatch bhi use kr skte h , ye true/false return krega
		boolean isProductMatch = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(isProductMatch ); // check if added product match with cart item 
		
		driver.findElement(By.cssSelector(".totalRow button ")).click(); // click on checkout page
		
		// Search data by search box
		
		Actions a  = new Actions(driver); // entery text by Actions class, Actions class keyboard/mouse k event ko handle krti h
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		waite.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click(); // select india from search result
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");		
		waite.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		driver.findElement(By.cssSelector(".action__submit")).click();
		String successMessage = driver.findElement(By.cssSelector(".hero-prime")).getText(); // get text of thanku page
		Assert.assertTrue(successMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")); // check if thankyiu message received or not.
		// agr console m text small m h or DOM m capital  m to  equalsIgnoreCase use kr skte h .
		
		
	}

}









