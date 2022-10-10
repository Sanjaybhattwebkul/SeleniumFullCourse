package seleium.MavenScrach;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testComponents.baseTest;

public class PlaceOrder extends baseTest {
	
	String productsName = "ZARA COAT 3";
	
	@Test(dataProvider="getTestData",groups="customerCheckout")
	// String email,String password,String productName  [While send data using Object]
	// HashMap<String,String> input // While sending data using HashMap
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
			
		//launchApplication method call hoga phle kyu ki us m @BeforeMethod annotation  lgaya h
		CatalogProduct CatalogProduct= LandingPage.loginApplication(input.get("email"),input.get("password")); // customer login and return obj of CatalogProduct class
		List<WebElement>cartProducts = CatalogProduct.getProductsList(); // get all products list in home page
		CatalogProduct.addProductToCart(input.get("productName")); // Add product to cart
		
		//goToCartPage function abstractComponenet class m or abstractComponenet class CatalogProduct m extend h   
		CartPage CartPage = CatalogProduct.goToCartPage(); // goToCartPage function CartPage ka object return kr ra h .		
		boolean isProductMatch = CartPage.veryfyDisplayProductToCart(input.get("productName"));
		Assert.assertTrue(isProductMatch ); // Assertion hmesa main page m lgta h , kisi function a ander ni lgta h.
		checkoutPage checkoutPage = CartPage.goToCheckooutPage();
		checkoutPage.searchCountry("india");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");	
		confirmMessagePage confirmMessagePage = checkoutPage.submitOrder();
		String message = confirmMessagePage.getConfirmMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//closeBrowser(); //call hoga kyu ki us m @AfterTest lgaya h
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() {
		CatalogProduct CatalogProduct= LandingPage.loginApplication("tom@example.com","Tom@1234"); // customer login and return obj of CatalogProduct class
		orderPage ordersPageObj = CatalogProduct.goToOrdersPage();
		Assert.assertTrue(ordersPageObj.VerifyOrderDisplay(productsName));
		
		
	}
	
	
	@DataProvider
	public Object[][] getTestData() throws IOException {
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\checkoutTestData.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
	}
	
/* 
 // DataProvider using HahMap
	@DataProvider
	public Object[][] getTestData() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email","tom@example.com");
		map.put("password","Tom@1234");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email","sanjay@qa.com");
		map1.put("password","Admin@123");
		map1.put("productName", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
	}*/
	
	
	// DataProvider using object
	
	/*@DataProvider
	public Object[][] getTestData(){
		
		return new Object[][] {{"tom@example.com","Tom@1234","ZARA COAT 3"},{"sanjay@qa.com","Admin@123","ADIDAS ORIGINAL"}};
	}*/
	
}



