package seleniumMaven;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome-exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)");
		// April 23
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click(); //click on date inputBox
		
		// check if October month selected on calendar
		while (!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("October")) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click(); // click on next arrow
		}

		int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size(); // count total dates on caalendar
		for (int i = 0; i < count; i++)	{
			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText(); // get text of datebox
			if (text.equalsIgnoreCase("26")) {
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click(); // click on dateBox
				System.out.println(text);
				break;
			}
		}
		System.out.println(driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value")); // print selected date

	}

}
