package seleniumExamples;

import org.testng.annotations.Test;

public class TimeOutExample {
	@Test(timeOut=3000)
	public void test() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Application should through TimeOut exception");
	}

}
