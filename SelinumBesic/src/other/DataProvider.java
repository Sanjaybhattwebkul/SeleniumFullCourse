package other;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {
	
	
	
	@Test(dataProvider="ob")
	public void login(String username,String Password)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chrome-exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.cssSelector("button[name='login']")).submit();
	};
	
	
	@org.testng.annotations.DataProvider
	public Object[][] ob()
	{
		Object ob1[][]=new Object[2][2];
		ob1[0][0]="858585855";
		ob1[0][1]="5559852";
		ob1[1][0]="5555555";
		ob1[1][1]="121212521";
		return ob1;
		
	}

}
