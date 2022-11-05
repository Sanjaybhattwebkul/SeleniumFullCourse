package pageobjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver drivere;
	
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click(); // click on checkout page
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;
	
	public CartPage(WebDriver driver) {
		this.drivere = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean veryfyDisplayProductToCart(String productName) {
		boolean isProductMatch = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return isProductMatch;
	}
	
	public checkoutPage goToCheckooutPage() {
		checkoutButton.click();		
		return new checkoutPage(drivere);
	}
	
}
