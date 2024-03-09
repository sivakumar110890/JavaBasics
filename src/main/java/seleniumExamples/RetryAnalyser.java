package seleniumExamples;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	int failedCount=0;
	int Retrycount=4;
	
	public boolean retry(ITestResult result) {
		if(failedCount<Retrycount) {
			failedCount++;
			return true;
		}
		return false;
	}

}
