package Selenium.exercise;
import java.io.File;

import java.io.IOException;

import java.util.HashMap;



//import org.testng.Assert;

//import org.testng.annotations.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		String downloadPath = System.getProperty("user.dir"); //get current working directory

		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); //Set prefecses for change default download path

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs); // set the Chrome download path.

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://altoconvertpdftojpg.com/"); // invoke the url.

		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\rahul\\Documents\\check\\fileupload.exe"); // auto losect the fille from our system  to upload 

		//WebDriverWait wait = new WebDriverWait(driver, 10);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));

		driver.findElement(By.cssSelector("button[class*='medium']")).click();

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));

		driver.findElement(By.linkText("Download Now")).click();

		Thread.sleep(5000);

		File f = new File(downloadPath + "/converted.zip"); // get downloaded file from our system

		if (f.exists())

		{
			
			//Assert.assertTrue(f.exists());  // check if file exist in [ downloadPath + "/converted.zip ]

			if (f.delete())  // delete the downloaded file

				System.out.println("file deleted");

		}
	}

}
