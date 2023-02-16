package test;

import java.io.*;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PublicisSapient {
   public static void main(String[] args) throws IOException {
	   WebDriver driver = new ChromeDriver();
	   dynamicDropDown(driver);
	   
	   getMostRepeatedWord("String.text");
	}
   
   public static void getMostRepeatedWord(String filePath) throws IOException
   {
	   File file = new File(System.getProperty("user.dir")+"/"+filePath); 
	   BufferedReader br  = new BufferedReader(new FileReader(file));
	   String[] str  = br.readLine().split(" ");
	   HashMap<String,Integer> map = new HashMap<String,Integer>();
	   for (String word:str) {
		   if (map.containsKey(word)) {
			   map.put(word, map.get(word)+1); 
		   } else {
			   map.put(word, 1);
		   }
	   }
	   
	   Collection<Integer> vaues = map.values();
	   Object[] obj = vaues.toArray();
	   
	   for (int i=0; i <obj.length; i++) {
		   int temp;
		   for (int j=0; j <obj.length-1; j++) {
			   if ((int)obj[i] > (int)obj[j]) {
				   temp = (int)obj[i];
				   obj[i] = (int)obj[j];
				   obj[j] = temp;
			   }
		   }
	   }
	   
	   int count=0;
	   String word="";
	   for (Entry<String, Integer> entry: map.entrySet()) {
		   if (entry.getValue() == obj[0]) {
			   word = entry.getKey();
			   count++;
			}
		  
	   }
	   
	   if(count > 1) {
		  System.out.println(-1);
	   } else {
		  System.out.println(word);
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