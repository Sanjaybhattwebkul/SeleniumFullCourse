package seleium.MavenScrach;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.baseTest;

public class ErrorValidationsTest extends baseTest {
	
	@Test
	public void LoginErrorValidation() throws InterruptedException, IOException {	
		//launchApplication method call hoga phle kyu ki us m @BeforeMethod annotation  lgaya h
		
		LandingPage.loginApplication("tom@exaple.com","om@1234"); // Login with Invali UserName or Password
		
		Assert.assertEquals("Incorrect email or password.", LandingPage.GetLoginErrorMessage());
		
	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException {
		String productName = "ZARA COAT 3";	
		//launchApplication method call hoga phle kyu ki us m @BeforeMethod annotation  lgaya h
		CatalogProduct CatalogProduct= LandingPage.loginApplication("sanjay@qa.com","Admin@123"); // customer login and return obj of CatalogProduct class
		List<WebElement>cartProducts = CatalogProduct.getProductsList(); // get all products list in home page
		CatalogProduct.addProductToCart(productName); // Add product to cart
		
		//goToCartPage function abstractComponenet class m or abstractComponenet class CatalogProduct m extend h   
		CartPage CartPage = CatalogProduct.goToCartPage(); // goToCartPage function CartPage ka object return kr ra h .		
		boolean isProductMatch = CartPage.veryfyDisplayProductToCart("ZARA COAT 32");
		Assert.assertFalse(isProductMatch); // assertFalse tb use krte h jd hme pta h ki return value false hogi.
	}
}
