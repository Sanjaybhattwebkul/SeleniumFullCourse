/*package Selenium.exercise;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLab {
	public static final String USERNAME = "Your UserName";

	public static final String ACCESSKEY = "Your Access Key";

	//Go to platform-configurator of sauce lab for auto generated code

	//Go to user setting of profile of sauce lab for credential

	public static final String URL = "https:" + USERNAME + ACCESSKEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";



	public static void main(String[] args) throws MalformedURLException {



	ChromeOptions browserOptions = new ChromeOptions();

	browserOptions.setPlatformName("Windows 10");

	browserOptions.setBrowserVersion("99");

	Map<String, Object> sauceOptions = new HashMap<>();

	sauceOptions.put("build", "Google Test");



	browserOptions.setCapability("sauce:options", sauceOptions);

	RemoteWebDriver driver = new RemoteWebDriver(new java.net.URL (URL), browserOptions);

	driver.get("https://google.com");

	WebElement searchBox = driver.findElement(By.name("q"));



	//seems like the below provided lines doesn't work

	sauceOptions.put("username", System.getenv("SAUCE_USERNAME"));

	sauceOptions.put("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
}
}
*/