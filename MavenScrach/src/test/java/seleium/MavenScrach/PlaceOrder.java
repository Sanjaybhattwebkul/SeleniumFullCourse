package seleium.MavenScrach;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.baseTest;

public class PlaceOrder extends baseTest {
	
	@Test
	public void submitOrder() throws InterruptedException, IOException {
		
		String productName = "ZARA COAT 3";	
		//launchApplication method call hoga phle kyu ki us m @BeforeMethod annotation  lgaya h
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
		//closeBrowser() call hoga kyu ki us m @AfterTest lgaya h
	}
}
