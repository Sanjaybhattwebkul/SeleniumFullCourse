package seleium.MavenScrach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponenets.AbstractComponent;

public class checkoutPage extends AbstractComponent {

	WebDriver driver;
	
	//driver.findElement(By.cssSelector("[placeholder='Select Country']"))
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css="action__submit")
	WebElement placeorder;
	
	By searchResult = By.cssSelector(".ta-results");
	By ckeckoutButton = By.cssSelector(".action__submit"); 
	
	
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchCountry(String countryForSarch) {
		Actions a  = new Actions(driver); // entery text by Actions class, Actions class keyboard/mouse k event ko handle krti h
		a.sendKeys(country, countryForSarch).build().perform();
		waitForElementToAppear(searchResult);
		selectCountry.click();
	}
	
	public confirmMessagePage submitOrder() {
		waitForElementToAppear(ckeckoutButton);
		placeorder.click();		
		return new confirmMessagePage(driver);
	}
	
}
