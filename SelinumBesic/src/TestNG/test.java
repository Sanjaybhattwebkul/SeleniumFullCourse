package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test {
	
	@Parameters({ "URL" })
	@Test
	public static void test1(String URL) {
		System.out.println("Hello testNG ONE URL="+URL);
	}
	
	@Test
	public static void test2() {
		System.out.println("Hello testNG TWO");
	}

}
