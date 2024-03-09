package seleniumExamples;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class ExceptionHandlingTestNg {
	
	@Test(timeOut=4000,expectedExceptions=ThreadTimeoutException.class)
	public void test1() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("This test should pass ");
	}

}
