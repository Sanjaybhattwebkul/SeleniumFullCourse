package testComponents;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listeners extends baseTest implements ITestListener{
	
	ExtentTest test; // variable declear
	ExtentReports extent = ExtentReporterNG.getReportObject();  // static funxtion call from ExtentReporterNG() class
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName()); 
		//.getMethod() -> testNg.xml File m jo method ka name h ya jo method mil ra h class k through.
		// getMethodName() ->.Actual method name of testG mrthod mtlb. jo className.java k ander method hoga vo lava.
		extentTest.set(test);//ab jo bhi test case if function m aayega un sab ki unique id [(ErrorValidationTest)->test ] milegi
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);

		String FilePath=null;
		extentTest.get().fail(result.getThrowable());
		// get driver obj from restlt parameter, because the result have all data of test class even WebDriver also.
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
			//getTestClass -> testNG.XML m jo testClass ka name h vo.
			//getRealClass-> JO testNG.xml test class ki Actual class.java h uska name
			// getField -> class ka jo filed chhiye usko passs krenge. 
			// getInstance-> is se hme WeDriver class ka object mil jayega.
			// Yha p hm class ko access kr re h kyu ki WebDriver driver class label pr set hota h na ki function label pr.s
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			FilePath = getScreenshot(result.getMethod().getMethodName(), driver); // take screenshot by getScreenshot() method of base class
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName()); //store screenshot to given path
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

}
