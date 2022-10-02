package seleium.MavenScrach;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import AbstractComponenets.AbstractComponent;

public class CatalogProduct extends AbstractComponent {
	
	WebDriver driver;
	public CatalogProduct(WebDriver driver) {
		super(driver); // initilize driver to AbstractComponent class's constructor
		this.driver = driver;
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));		
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	// WebElement loader = driveer.findElement(By.cssSelector(".ng-animating"));
	@FindBy(css=".ng-animating")
	WebElement loader;	
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By flashMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductsList(){
		waitForElementToAppear(productsBy); // call explicit waite function
		return products;
		
	}
	
	public WebElement getProductByName(String ProductName) {		
		WebElement actualProduct =	getProductsList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return actualProduct;
		//System.out.print(getProductsList().stream().map(data->data.findElement(By.cssSelector("b")).getText()).findFirst());
	}
	
	public void addProductToCart(String ProductName) throws InterruptedException {
		System.out.println(ProductName);
		WebElement ProName = getProductByName(ProductName);
		ProName.findElement(addToCart).click();
		waitForElementToAppear(flashMessage); // waite while flash message is displaying
		waiteForElementToDisAppear(loader); // waite till loader will display
		
		
	}
}
