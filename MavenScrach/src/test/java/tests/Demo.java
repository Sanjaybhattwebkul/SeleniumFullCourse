package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.*;
import java.util.Map.Entry;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static boolean isDisplay;
	public static boolean isEnable;
	
	@Test
	public  void GetAllproducts() {
		// TODO Auto-generated constructor stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String URL =  "https://www.flipkart.com";
		driver.get(URL);
		String input = "core i5";
		driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		List<WebElement> productCard = driver.findElements(By.className("//div[@class='_4ddWXP']"));
		double  minPrice = 0;
		HashMap<String,Double> map = new HashMap<String,Double>();
		for(int i=0; i <productCard.size(); i++) {			
			String outPutName = productCard.get(i).findElement(By.xpath("//a[2]")).getText();		    
		 	if(outPutName.contains(input)) {
		        String  previous = productCard.get(i).findElement(By.xpath("//a[2]/div[2]")).getText().replaceAll("[0-9]", "");
		        String  next = productCard.get(i+1).findElement(By.xpath("//a[2]/div[2]")).getText().replaceAll("[0-9]", "");		
		       double previosPrice= Double.parseDouble(previous);		       
		       double NextPrice= Double.parseDouble(next);		       
		       if(previosPrice > NextPrice) {
		    	   minPrice = NextPrice;
		       }
		       map.put(outPutName, previosPrice);		      
		 	}		 	
		}
		
	 	for(Entry<String, Double> entry:map.entrySet()) {
	 		if(entry.getValue()==minPrice) {
	 			System.out.println(entry.getKey()+" "+entry.getValue());
	 		}
	 	}
		
		
		
		
//		driver.get("https://www.amazon.in/");
//		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Phone",Keys.ENTER);
//		
//		//System.out.println("The 16th Products IS = "+ allProducts.get(15).getText());
//		 isDisplay = driver.findElement(By.cssSelector("a[aria-label='Go to next page, page 2']")).isDisplayed();
//		 isEnable = driver.findElement(By.cssSelector("a[aria-label='Go to next page, page 2']")).isEnabled();
//		if(isDisplay && isEnable ) {
//			PrintProductsName(driver);
//		}
		
	}
	
	// print all products with pagination
	public static void PrintProductsName(WebDriver driver) {
		List<WebElement> allProducts = driver.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
		allProducts.forEach(name->System.out.println(name.getText()));
		driver.findElement(By.cssSelector("a[aria-label*='next page']")).click();
		if(isDisplay && isEnable ) {
			PrintProductsName(driver);
		}
	}

}
