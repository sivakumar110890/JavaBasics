package seleniumExamples;

import org.testng.annotations.Test;

public class TestMultipleTimes {
	
	@Test(invocationCount = 5)
	public void test1() {
		System.out.println("This test will execute multiple times");
	}
	

}
