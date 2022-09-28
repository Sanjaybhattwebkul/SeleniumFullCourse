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
		ob1[0][0]="9759565345";
		ob1[0][1]="9997802929";
		ob1[1][0]="9759566345";
		ob1[1][1]="99978062929";
		return ob1;
		
	}

}
