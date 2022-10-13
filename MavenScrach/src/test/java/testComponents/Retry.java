package testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count = 0;
	int maxTry = 1; // Jitni bar test case reRun krna h yha p vo number dal do
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

	// JB tk TRUE return hoga tb tk testcase ReRun hoterhega
	// Jis test case ko rerun krana h us m [ retryAnalyzer=Retry.class] likhna hoga 
	// tb test case execute hote h to ye class Listeners k class k ontestFail method k pass jati h or failf method ko rerun krti h 
	
}
