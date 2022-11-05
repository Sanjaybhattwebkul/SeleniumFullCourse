package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponents.baseTest;
import pageobjects.LandingPage;
import pageobjects.checkoutPage;
import pageobjects.confirmMessagePage;
import pageobjects.CartPage;
import pageobjects.CatalogProduct;

public class StepDefinitionImpl extends baseTest {
	
	public LandingPage landingPage;
	public CatalogProduct CatalogProduct;
	public confirmMessagePage confirmMessagePage;
	
	@Given("I landed on Ecommerce Page") // given ki value PlaceOrder.feature file m h @Regression ya Backgroud m hogi.Background ka use feature file m tb krte h jb dependsOn vala test cse run ho ra ho.
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		LandingPage = launchApplication();
		//code
	}
	
	// ^  or $ ka use tb krte h jb @Given m parameter pass hora h .
	@Given("^Logged in with username (.+) and password (.+)$") // (.+) ye paramete h iski value feature file se aati h .
	public void logged_in_username_and_password(String username, String password)
	{
		CatalogProduct = landingPage.loginApplication(username, password);

	}
	
	@When("^I add product (.+) to Cart$") // productName ki value feature file se aayegi . or "(.+)" is ka use kr access kr re h .
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = CatalogProduct.getProductsList();
		CatalogProduct.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		CartPage cartPage = CatalogProduct.goToCartPage();
		boolean isProductMatch = cartPage.veryfyDisplayProductToCart(productName);
		Assert.assertTrue(isProductMatch);
		checkoutPage checkoutPage = cartPage.goToCheckooutPage();
		checkoutPage.searchCountry("india");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");	
		confirmMessagePage = checkoutPage.submitOrder();
	}
	
	 @Then("{string} message is displayed on ConfirmationPage")
	    public void message_displayed_confirmationPage(String string)
	    {
		 String message = confirmMessagePage.getConfirmMessage();
			Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			driver.close();
	    }
}
