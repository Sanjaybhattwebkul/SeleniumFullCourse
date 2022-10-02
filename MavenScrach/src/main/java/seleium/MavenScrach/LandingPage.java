package seleium.MavenScrach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	WebDriver driver;
	// Conductor creation
	public LandingPage(WebDriver driver) {
		this.driver = driver; // Ab WebDriver driver = driver ho gya. or driver ki value dusri class se pass hogi.
		
		// PageFactory k bare m Interview-Question.text k  LINE NO 984 m lkha h 
		
		PageFactory.initElements(driver, this); // PageFactory ko driver initialize kr diya
	}
	
	//WebElement userEmail  = driver.findElement(By.id("userEmail")); =  @FindBy(id="userEmail") WebElement userEmail
	//
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	
	@FindBy(id="login")
	WebElement submit;
	

	
	public CatalogProduct loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		
		//create object of CatalogProduct class and can access by calling any function of LandingPage class. 
		return  new CatalogProduct(driver);
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
