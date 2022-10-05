package seleium.MavenScrach;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.baseTest;

public class ErrorValidationsTest extends baseTest {
	
	@Test
	public void LoginErrorValidation() throws InterruptedException, IOException {	
		//launchApplication method call hoga phle kyu ki us m @BeforeMethod annotation  lgaya h
		
		LandingPage.loginApplication("tom@exaple.com","om@1234"); // Login with Invali UserName or Password
		
		Assert.assertEquals("Incorrect email or password.", LandingPage.GetLoginErrorMessage());
		
	}
}
