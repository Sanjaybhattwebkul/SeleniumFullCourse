package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.net.URL;

public class FlipCar {
	
	
	@Test
	public void flipKartTest() throws IOException 
	{		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		dynamicDropDown(driver);
		
		//filpKartTest(driver);
		
	}
	
	public void filpKartTest(WebDriver driver)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		String input="core i5";
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("input[title*=\"Search\"]")).sendKeys(input, Keys.ENTER);
		List<WebElement> allProducts = driver.findElements(By.cssSelector("div[class=\"_13oc-S\"]"));
		List<WebElement> productsName = driver.findElements(By.cssSelector("div[class=\"_4rR01T\"]"));
		List<WebElement> productPrice = driver.findElements(By.cssSelector("div[class=\"_30jeq3 _1_WHN1\"]"));		
		for (int i = 0; i < allProducts.size(); i++) {				
			String productName = productsName.get(i).getText().toLowerCase();
			if(productName.contains(input)) {
				int price = Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", ""));
				list.add(price);				
			}
		}
		
		if(list.isEmpty()) {
			System.out.println("No record Found for serarchKeyword");
		}else {
			int minimumPrice = Collections.min(list);			
			for (int i = 0; i < allProducts.size(); i++) {
				String name = productsName.get(i).getText().toLowerCase();
				if(name.contains(input)) {
					if(minimumPrice == Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", ""))){					
						System.out.println(productsName.get(i).getText());
						System.out.println(Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", "")));
						break;
					}
				}				
			}
		}
	}
	
	
	
	
	public static void dynamicDropDown(WebDriver driver)
	{
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(By.xpath("//input[contains(@id,'downshift-')]")).sendKeys("s");		
		List<WebElement> resultContainer = driver.findElements(By.xpath("//ul[contains(@id,'downshift-')]/li/span[2]"));		
		System.out.println(resultContainer.size());		
		for(int i=0; i < resultContainer.size(); i++) {
			String Text = resultContainer.get(i).getText();
			System.out.println(Text);
			
		}
	}

	
	
}
