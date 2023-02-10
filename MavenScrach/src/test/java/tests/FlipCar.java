package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.*;

public class FlipCar {
	
	@Test
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String URL =  "https://www.flipkart.com";
		driver.get(URL);
		String input = "core i5";
		driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		

	}

}
