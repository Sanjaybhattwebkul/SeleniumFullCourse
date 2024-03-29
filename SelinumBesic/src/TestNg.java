import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestNg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Rahul";
		System.setProperty("webdriver.chrome.driver", "C:\\chrome-exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver); // Call getPassword Function		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");		
		driver.manage().window().maximize();
		Thread.sleep(2000);    			
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit ')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());		
		// Using testNG check expected and actual result
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		// <button classs="demo">Log Out</button>
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		//driver.findElement(By.xpath("//button[text()='Log out']")).click();
		driver.close();
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String passwordText =driver.findElement(By.cssSelector("form p")).getText();
		
		String[] passwordArray = passwordText.split("'");
		
		return  passwordArray[1].split("'")[0];	
		
		//0th index - Please use temporary password		
		//1st index - rahulshettyacademy' to Login.
		
		
		//0th index - rahulshettyacademy		
		//1st index - to Login.

	}

}



