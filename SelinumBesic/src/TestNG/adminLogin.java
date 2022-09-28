package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class adminLogin {
	@Parameters({ "URL" })
	@Test
	public static void demo1(String siteURL) {
		System.out.println("Admin login  ONE parameter="+siteURL);
	}
	
	
	@Test
	public static void demo2() {
		System.out.println("admin Login TWO");
	}
}
