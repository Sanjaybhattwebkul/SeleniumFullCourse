package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmMessagePage {
	WebDriver driver;
	public confirmMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector(".hero-primary")).getText();
	@FindBy(css=".hero-primary")
	WebElement message;
	
	public String getConfirmMessage() {
		return message.getText();
	}
}
