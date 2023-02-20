driver.findElement(By.xpath("//div(contains[class,'name'])"))
driver.findElemen(By.cssSelector("div"))

//@Relative xpath
driver.finElement(By.xpath("//div[@class='name']/p[0]"));

//@ Child To Parent Xpath
driver.findElement(By.xpath("//input[@name='email']/parent::div/button[1]"));

// @Parent To child Xpath
driver.findELement(By.xpath("//p[contains(@class='email')]/span[2]  //h1[@class='cls']"));
//@Abslute xpath
driver.findElement(By.xpath("/html/head/body/div/p"));

/// @css selector
System.out.println(driver.findElement(By.cssSelector("form p")).getText()); //parentTag ChildTag
System.out.println(driver.findElement(By.cssSelector("p.error")).getText());  //tagName.className

driver.manage().timeOutes().implicitlyWait(Durations.Ofseconds(10));
driver.manage().timeouts().implicitlyWait(10,timeouts.MINUTES);
WebDriverWait wait = new WebDriverWait(driver);
wait.until(ExpectedCondition.visiblityOfElementLocated(By.xpath("//div[@class='name']")));
driver.findElement(By.cssSelector("div[id='name'] :nth-child(1)"));


driver.findElemen(By.tagName("p")).click();
driver.findElemen(By.className("class")).click();
driver.findElemen(By.name("email")).click();
driver.findElemen(By.id("idname")).click();

WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedCondition.visiblityOfElementLocated(By.xpath("div[class='class']")));

TakesScreenshot ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFIle(ss, new File("sc.png"));

String url = driver.findELement(By.xpath("//div[@class=link']")).getAttribute(hre);
HttpURLConection conn = new URL(url).openConnection();
SoftAssertion assert = new SoftAssertion();
conn.setRequestMenth("HRAD");
conn.connect();
if(conn.getResponseCode() >400) {
    System.out.println("this is Broken Link");
}
assert.assertTrue(true);
assert.assertAll();

WebElement color = driver.findElement(By.cssSelector(".className")).getCssValue();
String colorCode = color.fromString(color).asHax();
System.out.println(colorCode);


driver.manage().timeouts().implicitlyWait(10,timputs.SECONDS);
driver.manage().timeouts().implicityWait(12,timeouts.MINUTES);
driver.manage().timeouts().implicitlyWait(Duration.OfSeconds(12));


JavaScriptExecutor js = (JavaScriptExecutor)driver;
js.executeScript(windows.scrollBy(0,300));

String parentWindow = driver.getWindowHandle();
Set<String> windows = driver.getWindowHandlers();
Itrator<String> it = windows.Itrator;
while(it.hasNext()) {
    String chiledWindow = it.next;
    driver.switchTo().window(childWindow);
    driver.switchTo().window(parentWindow);
}

ChromeOptions chromeOption = new ChromeOptions();
chromeOption.setAcceptInsecureCerts(true);


ChromeOption oprion = new ChromeOption()
option.setAcceptInsureCerts(true)

option.addArgument("--disabled-notifications");